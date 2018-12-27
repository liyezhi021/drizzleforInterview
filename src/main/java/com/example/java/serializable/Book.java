package com.example.java.serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Book implements Serializable {

    private static final long serialVersionUID = 12786387123L;

    private Integer bookId;

    private String bookName;

    public Book(Integer bookId, String bookName){
        this.bookId = bookId;
        this.bookName = bookName;
    }

    private void readObject(ObjectInputStream in){
        try {
            in.defaultReadObject();
            System.out.println("start readObject");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void writeObject(ObjectOutputStream os){
        try {
            os.defaultWriteObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                '}';
    }
}
