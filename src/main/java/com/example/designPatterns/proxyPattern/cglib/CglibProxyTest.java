package com.example.designPatterns.proxyPattern.cglib;

public class CglibProxyTest {

    public static void main(String[] args){
        BookFacadeImpl1 bookFacadeImpl1 = new BookFacadeImpl1();
        BookFacadeCglib cglib = new BookFacadeCglib();
        BookFacadeImpl1 bookCglib = (BookFacadeImpl1) cglib.getInstance(bookFacadeImpl1);
        bookCglib.addBook1();
    }
}
