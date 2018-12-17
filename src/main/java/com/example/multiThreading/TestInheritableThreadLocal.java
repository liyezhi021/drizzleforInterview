package com.example.multiThreading;

public class TestInheritableThreadLocal {

    static final InheritableThreadLocal<String> threadParam = new InheritableThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        Thread parent = Thread.currentThread();
        while(true){
            //thread 1
            new Thread(()->{
                threadParam.set("abc");
                System.out.println("t1:"+ threadParam.get());

                new Thread(()->{
                    System.out.println("t2:"+ threadParam.get());
                }).start();
            }).start();

            Thread.sleep(1);

            new Thread(()->{
                System.out.println("t3:"+ threadParam.get());
            }).start();
        }

    }

}
