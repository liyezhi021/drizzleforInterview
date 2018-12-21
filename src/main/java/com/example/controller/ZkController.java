package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static com.example.constants.Constants.ZK_HOST_PORT;

@Slf4j
@RestController
@RequestMapping("zk")
public class ZkController {

    ZooKeeper zk;

    /**
     * request http://localhost:8089/zk/findChildrenByzPath?zPath=%2FMembers
     * */
    @GetMapping("findChildrenByzPath")
    public List<String> findChildrenByPath(String zPath) throws KeeperException, InterruptedException, IOException {
        try {
            zk = new ZooKeeper(ZK_HOST_PORT, 2000, null);
            if(zPath.charAt(0)!= '/')
                return null;
            List<String> zkChildren = zk.getChildren(zPath, false);
            System.out.println("zkChildren of : "+ zPath);
            zkChildren.forEach(System.out::println);
            return zkChildren;
        }finally {
            if(zk!= null)
                zk.close(); zk = null;
        }
    }

    @GetMapping("createZNode")
    public String createZNode(@RequestParam("zPath") String zPath) throws KeeperException, InterruptedException, IOException {
        /**
         * @Param1 指定数据节点的节点路径，即API调用的目的是创建该节点
         * @Param2 节点的初始数据内容，可以传入nul
         * @Param3 节点的ACL策略
         * @Param4 节点类型，是一个枚举类型，通常有4种可选的节点类型 PERSISTENT, PERSISTENT_SEQUENTIAL, EPHEMERAL, EPHEMERAL_SEQUENTIAL
         * */
        zk = new ZooKeeper(ZK_HOST_PORT, 2000, null);
        try{
            return zk.create(zPath, "data".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }finally {
            if(zk!= null)
                zk.close(); zk = null;
        }
    }

    /**
     * 删除节点
     * public void delete(final String path, int version) throws InterruptedException, KeeperException //同步
     * public void delete(final String path, int version, VoidCallback cb,Object ctx) //异步
     * */
    @GetMapping("deleteZNode")
    public String deleteZNode(String zPath) throws KeeperException, InterruptedException, IOException {
        zk = new ZooKeeper(ZK_HOST_PORT, 2000, null);
        try {
            zk.delete(zPath, -1);
            return "success";
        }finally {
            if(zk!= null) {
                zk.close(); zk = null;
            }
        }
    }

    /**
     * 获取节点内容
     * 下面是异步读取
     * public void getData(String path, boolean watch, DataCallback cb, Object ctx)
     * public void getData(final String path, Watcher watcher,DataCallback cb, Object ctx)
     * */
    @GetMapping("findNodeValue")
    public String getData(String zPath) throws IOException, InterruptedException {
        Stat stat = new Stat();
        if(zk==null) zk= new ZooKeeper(ZK_HOST_PORT, 2000, null);
        try{
            byte[] data = zk.getData(zPath, false, stat);
            String value = new String(data, "UTF-8");
            return value;
        }catch (KeeperException e){
            e.printStackTrace();
        }finally {
            if(zk!=null) {
                zk.close();
                zk = null;
            }
        }
        return null;
    }

    /**
     * 给节点内容赋值
     * public Stat setData(final String path, byte data[], int version) throws KeeperException, InterruptedException //同步获取
     * public void setData(final String path, byte data[], int version,StatCallback cb, Object ctx) //异步获取
     * */
    @GetMapping("resetNodeValue")
    public Boolean setData(@RequestParam("zPath") String zPath,@RequestParam("value") String value)
            throws KeeperException, InterruptedException , IOException{
        try{
            if(zk==null) zk= new ZooKeeper(ZK_HOST_PORT, 2000, null);
            Stat stat = zk.setData(zPath, value.getBytes(), -1);
            if(stat!= null)
                return true;
            return false;
        }finally {
            if(zk!=null){
                zk.close();
                zk = null;
            }
        }
    }



}
