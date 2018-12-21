package com.example.jvm.nioRWDemo;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class TestNioWR {

    private static Boolean APPENDABLE = true;

    /**
     *nio 一个字节一个字节的读取
     * */
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

    /**
     *nio 一次性从缓冲区读多个
     */
    public static void nioReadMany(String path){
        try {
            InputStream is = new FileInputStream(path);
            FileChannel fc = ((FileInputStream) is).getChannel();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            WritableByteChannel wbc = Channels.newChannel(bos);
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while(true){
                try {
                    //数据读到缓冲区
                    int i = fc.read(buffer);
                    if(i==0 || i==-1) break;
                    buffer.flip();
                    wbc.write(buffer);
                    buffer.clear();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("nio read file --->"+ bos.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * nio 写入
     * */
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
        String path = "/home/drizzle/demo/haha.txt";
        TestNioWR.nioRead(path);
        System.out.println("--------------------------------");
        nioWrite(path);
        System.out.println("++++++++++++++++++++++++++++++++");
        TestNioWR.nioReadMany(path);
    }

}
