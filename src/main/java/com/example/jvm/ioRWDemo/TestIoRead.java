package com.example.jvm.ioRWDemo;

import java.io.*;

public class TestIoRead {

    /**
     *  以字节为单位读取文件，常用于读二进制文件，如图片、声音、影像等文件。
     * */
    public static void readFileByBytes(String fileName){
        File file = new File(fileName);
        InputStream is = null;
        /*try {
            System.out.println("以字节为单位进行读取，一次读一个字节");
            is = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int i;
            while((i= is.read())!= -1){
                bos.write(i);
            }
            System.out.println("read string is ->"+ bos.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(is!= null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }*/

        try{
            System.out.println("以字节为单位进行读取，一次读取多个字节：");
            //一次读取多个字节
            byte[] tempbytes = new byte[100];
            int byteread;
            is = new FileInputStream(fileName);
            TestIoRead.showAvailableBytes(is);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            while((byteread= is.read(tempbytes))!= -1){
                bos.write(tempbytes, 0, byteread);
            }
            System.out.println("read string is ->"+ bos.toString());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(is!= null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 以字符为单位读取文件，常用于读文件，数字等类型的文件
     * */
    public static void readFileByChars(String fileName){
        File file = new File(fileName);
        Reader reader = null;
        /*try{
            System.out.println("以字符为单位读取文件内容， 一次读一个字节：");
            reader = new InputStreamReader(new FileInputStream(file));
            CharArrayWriter caw = new CharArrayWriter();
            int i;
            while((i= reader.read())!=-1){
                if((char) i!= '\r'){
                    caw.append((char) i);
                }
            }
            System.out.println(caw.toString());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(reader !=null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }*/

        try{
            System.out.println("以字符为单位读取文件内容， 一次读取多个字节");
            char[] tempchars = new char[30];
            int charread;
            reader = new InputStreamReader(new FileInputStream(fileName));
            StringBuilder sb = new StringBuilder();
            //charread 为一次读取字符数
            while((charread = reader.read(tempchars))!= -1){
                if((charread == tempchars.length) &&
                        (tempchars[tempchars.length-1]!='\r'))
                    sb.append(tempchars);
                else {
                    for(int i=0; i<charread; i++){
                        if(tempchars[i]== '\r')
                            continue;
                        else sb.append(tempchars[i]);
                    }
                }
            }
            System.out.println("the answer is ->"+ sb);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(reader!= null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     * */
    public static void readFileByLines(String fileName){
        File file = new File(fileName);
        BufferedReader reader = null;
        try{
            System.out.println("以行为单位读取文件内容，一次读一整行");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            StringBuilder sb = new StringBuilder();
            int line =1;
            while((tempString= reader.readLine())!= null){
                System.out.println("line:"+ line+ ":" + tempString);
                sb.append(tempString);
                line++;
            }
            System.out.println("sb:");
            System.out.println(sb.toString());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 随机读取文件内容
     * */
    public static void readFileByRandomAccess(String fileName){
        RandomAccessFile randomFile = null;
        try{
            System.out.println("随机读取一段文件内容：");
            //打开一个随机访问文件流 按只读方式
            randomFile = new RandomAccessFile(fileName, "r");
            long fileLength = randomFile.length();
            //读文件的起始位置
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int beginIndex = (fileLength>4) ? 4:0;
            randomFile.seek(beginIndex);
            byte[] bytes = new byte[10];
            int byteread = 0;
            //一次读10个字节，如果文件内容不足10个字节，则读剩下的字节
            if((byteread= randomFile.read(bytes))!= -1){
                bos.write(bytes, 0, byteread);
            }
            System.out.println(bos.toString());
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

    /**
     * 显示输入流中还剩的字节数
     * */
    public static void showAvailableBytes(InputStream in){
        try {
            System.out.println("当前字节输入流中的字节数为：" + in.available());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        String path = "/home/payne/demo/hello.txt";
        //readFileByBytes(path);
        //readFileByChars(path);
        //readFileByLines(path);
        readFileByRandomAccess(path);
    }

}
