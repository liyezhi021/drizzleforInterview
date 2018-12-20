package com.example.jvm.classLoader;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.lang.reflect.Method;

@Slf4j
public class HelloMain {
    private static MethodExecuteThread methodExecuteThread = new MethodExecuteThread();
    private static ClassFileChangeListenerThread classFileChangeListenerThread = new ClassFileChangeListenerThread();

    private static volatile Class desClazz;//共享变量

    public static void main(String[] args) { //创建两个线程，一个线程负责运行方法  另一个线程负责监听观察的文件是否有变动

        /**启动类文件监听线程**/
        classFileChangeListenerThread.start();

        /**启动方法执行线程**/
        methodExecuteThread.start();

    }

    private static class ClassFileChangeListenerThread extends Thread {
        @Override
        public void run() {
            try {
                File file = new File(HelloMain.class.getResource("").getPath() + "Worker.class");
                long lastTime = file.length();
                boolean isFirst = true;
                while (true) {
                    Thread.sleep(4000);
                    File newFile = new File(HelloMain.class.getResource("").getFile() + "Worker.class");
                    long nowModified = newFile.length();
                    if (lastTime != nowModified) {
                        log.info("--->fileChanged（发现文件改变了）:" + nowModified);
                        lastTime = nowModified;
                        reloadFile(newFile, methodExecuteThread);
                    } else {
                        if (isFirst) {
                            log.info("首次，也应该加载文件");
                            reloadFile(newFile, methodExecuteThread);
                            isFirst = false;
                        } else {
                            log.debug("--->文件没有改变");
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 方法执行线程
     */
    private static class MethodExecuteThread extends Thread {
        volatile InheritableThreadLocal<Class> executeClassLocal = new InheritableThreadLocal<>();

        @Override
        public void run() {
            while (true) {
                try {
                    Class executeClazz = desClazz;
                    if (null == executeClazz) {
                        Thread.sleep(2000);
                        System.out.println("还没有CLASS信息，[无法执行代码]");
                        continue;
                    }
                    System.out.println("MethodExecuteThread   要执行代码了");
                    Thread.sleep(1000);
                    Object objObject = executeClazz.getConstructor(new Class[]{}).newInstance(new Object[]{});
                    Method executeClazzMethod = executeClazz.getMethod("doit", null);
                    executeClazzMethod.invoke(objObject, null);//执行
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public InheritableThreadLocal<Class> getExecuteClassLocal() {
            return executeClassLocal;
        }

        public void setExecuteClassLocal(InheritableThreadLocal<Class> ExecuteClassLocal) {
            this.executeClassLocal = ExecuteClassLocal;
        }
    }

    /**
     * 重新加载FILE
     * 在这里，将这个CLASS文件重新加载到内存中，从而替换掉之前的CLASS文件
     * 即将之前那个类重新new一下
     */
    private static void reloadFile(File newFile, MethodExecuteThread methodExcuteThread) {
        log.debug("[reloadFile]");
        HotClassLoader hotClassLoader = new HotClassLoader();
        hotClassLoader.setObjFile(newFile);
        try {
            Class<?> objClass = hotClassLoader.findClass("com.example.jvm.classLoader.Worker");
            //把这个新的CLASS设置到另一个线程中
            methodExcuteThread.getExecuteClassLocal().set(objClass);//把新的class设置上
            desClazz = objClass;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
