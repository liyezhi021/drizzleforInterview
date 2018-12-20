package com.example.jvm.nioRWDemo;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestNioWR {

    private static Boolean APPENDABLE = true;

    public static void nioRead(String path){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
            FileChannel fc = fis.getChannel();
            //创建缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            //数据读入缓冲区
            fc.read(buffer);
            buffer.flip();
            StringBuffer s = new StringBuffer();
            while(buffer.remaining()>0){
                byte b = buffer.get();
                s.append((char) b);
            }
            System.out.println(s);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }finally {
            if(fis!= null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void nioWrite(String path){
        File file = new File(path);
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file, APPENDABLE);
            FileChannel fc = outputStream.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            String str = "java.nio";
            //buffer.wrap(str.getBytes(Charset.forName ISO-8859-1));
            buffer.put(str.getBytes());
            buffer.flip();
            fc.write(buffer);
            fc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(outputStream!= null) {
                try {
                    outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args){
        String path = "/home/payne/demo/hello.txt";
        TestNioWR.nioRead(path);
        System.out.println("--------------------------------");
        nioWrite(path);
        System.out.println("++++++++++++++++++++++++++++++++");
        TestNioWR.nioRead(path);
    }

}
