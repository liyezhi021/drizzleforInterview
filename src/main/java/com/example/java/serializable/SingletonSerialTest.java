package com.example.java.serializable;

import org.junit.Assert;

import java.io.*;

public class SingletonSerialTest {

    public static void main(String[] args){
        SingletonBook s1;
        SingletonBook s = SingletonBook.getInstance();
        try {
            FileOutputStream fos = new FileOutputStream("/home/drizzle/demo/SigBook.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("/home/drizzle/demo/SigBook.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (SingletonBook) ois.readObject();
            Assert.assertEquals(s, s1);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
