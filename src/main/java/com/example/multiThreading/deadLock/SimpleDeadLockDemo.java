package com.example.multiThreading.deadLock;

import java.util.concurrent.locks.Lock;

public class SimpleDeadLockDemo {

    public static void main(String[] args){

        new Thread(new LockDemo(true)).start();
        new Thread(new LockDemo(false)).start();

    }

    static class LockDemo implements Runnable{

        boolean flag;

        LockDemo(boolean flag){
            this.flag = flag;
        }

        public static final Object A = new Object();
        public static final Object B = new Object();


        @Override
        public void run() {
            if(flag)
                synchronized (A){
                    System.out.println("currentThread"+ Thread.currentThread().getName()+ " lock A");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B){
                        System.out.println("currentThread"+ Thread.currentThread().getName()+ " try to lock B");
                    }
                }
            else{
                synchronized (B){
                    System.out.println("currentThread"+ Thread.currentThread().getName()+ " lock B");
                    synchronized (A){
                        System.out.println("currentThread"+ Thread.currentThread().getName()+ " try to lock A");
                    }
                }
            }
        }
    }

}
