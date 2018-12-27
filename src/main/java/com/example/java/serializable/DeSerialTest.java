package com.example.java.serializable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerialTest {

    public static void main(String[] args){
        Book book;
        try {
            FileInputStream fis = new FileInputStream("/home/drizzle/demo/book.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            book = (Book) ois.readObject();
            ois.close();
            System.out.println(book);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

}
