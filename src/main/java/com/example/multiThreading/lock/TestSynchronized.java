package com.example.multiThreading.lock;

public class TestSynchronized {

    private static int a = 0;

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
            synchronized (TestSynchronized.class){
                for(int i=0; i<1000; i++)
                    a++;
            }
        }
    }

}
