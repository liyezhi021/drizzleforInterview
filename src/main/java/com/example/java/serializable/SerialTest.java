package com.example.java.serializable;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerialTest {

    public static void main(String[] args){

        Book book = new Book(3, "janeLove");
        System.out.println("Book Serial:" + book);
        try {
            FileOutputStream fos = new FileOutputStream("/home/drizzle/demo/book.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(book);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
