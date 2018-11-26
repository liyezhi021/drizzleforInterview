package com.example.Zookeeper;



import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ZkDemo {

    private static String HOST_POST = "localhost:2181";

    public static void main(String args[]) throws IOException {

        List<String> zooChildren = new ArrayList<>();
        ZooKeeper zk = new ZooKeeper(HOST_POST, 2000, null);

        try {
            if(zk!= null){
                String zpath = "/";
                zooChildren = zk.getChildren(zpath, false);
                System.out.println("Znodes of '/'");
                zooChildren.forEach(t-> System.out.println(t));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
