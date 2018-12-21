package com.example.zookeeper;

import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;

import static com.example.constants.Constants.ZK_HOST_PORT;

public class ZkDemo {

    public static void main(String args[]) throws IOException {

        List<String> zooChildren;
        ZooKeeper zk = new ZooKeeper(ZK_HOST_PORT, 2000, null);

        try {
            if(zk!= null){
                String zPath = "/Members";
                zooChildren = zk.getChildren(zPath, false);
                System.out.println("zNodes of '/Members'");
                zooChildren.forEach(System.out::println);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
