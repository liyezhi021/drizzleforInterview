package com.example.multiThreading.deadLock;

public class SimpleDeadLockDemo {

    public static void main(String[] args){

        new Thread(new LockDemo(true)).start();
        new Thread(new LockDemo(false)).start();

    }

    static class LockDemo implements Runnable{

        public static final Object A = new Object();
        public static final Object B = new Object();

        boolean flag;

        LockDemo(boolean flag){
            this.flag = flag;
        }


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
