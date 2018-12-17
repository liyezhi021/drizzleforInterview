package com.example.zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.List;

public class ClusterMonitor implements Runnable{

    private static String memberShipRoot = "/Members";
    private final Watcher connectionWatcher;
    private final Watcher childrenWatcher;
    private ZooKeeper zk;
    boolean alive = true;

    public ClusterMonitor(String HostPort) throws IOException, InterruptedException, KeeperException{
        connectionWatcher = new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                if (event.getType() == Watcher.Event.EventType.None && event.getState() == Watcher.Event.KeeperState.SyncConnected) {
                    System.out.printf("\nEvent Received: %s", event.toString());
                }
            }
        };

        childrenWatcher = new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.printf("\nEvent Received: %s", event.toString());
                if (event.getType() == Event.EventType.NodeChildrenChanged) {
                    try {
                        //Get current list of child znode,
                        //reset the watch
                        List<String> children = zk.getChildren(memberShipRoot, this);
                        wall("!!!Cluster Membership Change!!!");
                        wall("Members: " + children);
                    } catch (KeeperException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        alive = false;
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        zk = new ZooKeeper(HostPort, 2000, connectionWatcher);

        // Ensure the parent znode exists
        if (zk.exists(memberShipRoot, false) == null) {
            zk.create(memberShipRoot, "ClusterMonitorRoot".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }

        // Set a watch on the parent znode
        List<String> children = zk.getChildren(memberShipRoot, childrenWatcher);
        System.err.println("Members: " + children);

    }

    public synchronized void close() {
        try {
            zk.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void wall(String message) {
        System.out.printf("\nMESSAGE: %s", message);
    }

    @Override
    public void run() {
        try {
            synchronized (this) {
                while (alive) {
                    wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } finally {
            this.close();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        String hostPort = "localhost:2181";
        new ClusterMonitor(hostPort).run();
    }
}
