package com.example.multiThreading.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestReadWriteLock {

    private static int a = 0;

    private static ReadWriteLock rwlock = new ReentrantReadWriteLock();

    public static void main(String[] args){
        for(int i=0 ; i< 20; i++){
            new Thread(new Task()).start();
        }

        while(Thread.activeCount() >2)
            //Thread.currentThread().getThreadGroup().list();
            Thread.yield();

        System.out.println("a's value-------->"+a);
    }

    public static class Task implements Runnable{

        @Override
        public void run() {
            //rwlock.readLock().lock();
            rwlock.writeLock().lock();
            try {
                for(int i=0; i<1000; i++)
                    a++;
            }finally {
                //rwlock.readLock().unlock();
                rwlock.writeLock().unlock();
            }
        }
    }

}
