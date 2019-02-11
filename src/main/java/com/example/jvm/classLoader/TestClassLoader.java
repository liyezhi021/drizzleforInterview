package com.example.jvm.classLoader;

public class TestClassLoader {

    public static void main(String[] args) throws InterruptedException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        try {
            System.out.println("loader start loaded TClass");
            try {
                Object o = loader.loadClass("com.example.jvm.classLoader.TClass").newInstance();
                System.out.println("o's class-->"+ o.getClass());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
            System.out.println("loader end load TClass");
            Thread.sleep(3000);
            System.out.println("forName start loader TClass");
            Class.forName("com.example.jvm.classLoader.TClass");
            System.out.println("forName end loader TClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
