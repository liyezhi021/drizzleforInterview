package com.example.TestMultiThreading;

public class TestVolatile {

    public static volatile int race = 0;

    public static final int THREADS_COUNTS = 20;

    public static void increase(){
        race++;
    }

    public static void main(String args[]){

        Thread[] threads = new Thread[THREADS_COUNTS];
        for(int i=0; i<THREADS_COUNTS; i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0; i<1000; i++){
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        //这里还有个守护线程 所以判断大于1会陷入死循环
        while(Thread.activeCount() >2)
            //Thread.currentThread().getThreadGroup().list();
            Thread.yield();

        System.out.println(race);

    }

}
