package com.example.jvm.classLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

//实现热替换...
public class HotClassLoader extends ClassLoader{

    public HotClassLoader(){
        super(ClassLoader.getSystemClassLoader());
    }

    private File objFile;

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException{
        System.out.println("finding class... waiting plz");
        Class clazz = null;
        try {
            byte[] data = getClassFileBytes(getObjFile());
            clazz = defineClass(name,data,0, data.length);
            if(null == clazz){

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return clazz;
    }

    //Class文件转成Byte[]
    private byte[] getClassFileBytes(File file) throws Exception{
        //采用NIO读取
        FileInputStream fis = new FileInputStream(file);
        FileChannel fileC = fis.getChannel();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        WritableByteChannel outC = Channels.newChannel(bos);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while(true){
            int i = fileC.read(byteBuffer);
            if(i ==0 || i == -1){
                break;
            }
            byteBuffer.flip();
            outC.write(byteBuffer);
            byteBuffer.clear();
        }
        fis.close();
        return bos.toByteArray();

    }


    public File getObjFile() {
        return objFile;
    }

    public void setObjFile(File objFile) {
        this.objFile = objFile;
    }
}
