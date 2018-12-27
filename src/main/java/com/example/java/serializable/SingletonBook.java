package com.example.java.serializable;

import java.io.Serializable;

public class SingletonBook implements Serializable {

    private static final long serialVersionUID = 12893182736L;

    private SingletonBook(){
    }

    private static final SingletonBook singletonBook = new SingletonBook();

    public static SingletonBook getInstance(){
        return singletonBook;
    }

    public Object readResolve(){
        return singletonBook;
    }

}
