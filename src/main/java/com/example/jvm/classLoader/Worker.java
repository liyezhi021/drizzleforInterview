package com.example.jvm.classLoader;

public class Worker {

    public Worker(){
        System.out.println("worker construct method be executed... ");
    }

    public void doit() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("This classLoader is777777777777777777777777"+
            this.getClass().getClassLoader().toString()+ "<-----");
        System.out.println("\n");
    }
}
