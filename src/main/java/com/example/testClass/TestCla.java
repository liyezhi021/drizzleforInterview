package com.example.testClass;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TestCla {

    public static String privateUrl;

    public static AtomicInteger a = new AtomicInteger(129);

    public static void main(String[] args) {
        //System.out.println(2 << 3);
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);
        System.out.println(test());

    }

    private static AtomicInteger test() {
        try {
            a.addAndGet(2);
            return a;
        } finally {
            a.addAndGet(4);
            //return a;
        }
    }
}
