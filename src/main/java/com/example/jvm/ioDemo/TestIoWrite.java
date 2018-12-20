package com.example.jvm.ioDemo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class TestIoWrite {

    public static void appendMethod1(String fileName, String content){
        RandomAccessFile randomFile = null;
        //打开一个随机访问文件流，按读写方式
        try{
            randomFile = new RandomAccessFile(fileName, "rw");
            long fileLength = randomFile.length();
            //将写文件指针移到文件尾
            randomFile.seek(fileLength);
            randomFile.writeBytes(content);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(randomFile!= null) {
                try {
                    randomFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void appendMethod2(String fileName, String content){
        FileWriter writer = null;
        try{
            writer = new FileWriter(fileName, true);
            writer.write(content);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(writer!= null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args){
        String fileName = "/home/payne/demo/hello.txt";
        String content = "new append! ";
        TestIoWrite.appendMethod1(fileName, content);
        TestIoWrite.appendMethod1(fileName, "append end. \n");
        TestIoRead.readFileByLines(fileName);

        TestIoWrite.appendMethod2(fileName, content);
        TestIoWrite.appendMethod2(fileName, "2222222 end. \n");
        TestIoRead.readFileByLines(fileName);
    }

}
