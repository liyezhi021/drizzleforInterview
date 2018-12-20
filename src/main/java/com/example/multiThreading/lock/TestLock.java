package com.example.multiThreading.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {

    public static int a = 0;

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

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
            System.out.println("线程->"+ Thread.currentThread().getName() +"进来");
            lock.lock();
            System.out.println("线程->"+ Thread.currentThread().getName() +"获得锁");
            try{
                for(int i=0; i<1000; i++)
                    a++;
            }finally {
                lock.unlock();
                System.out.println("线程->"+ Thread.currentThread().getName() +"释放锁");
            }
        }
    }

}
