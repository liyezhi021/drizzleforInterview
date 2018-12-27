package com.example.designPatterns.buildPattern.build1;

public class Test {

    public static void main(String[] args){
        Direct direct = new Direct();
        Book book = direct.createBook(new SmartBuilder());
        System.out.println("book name --->"+book.getBookName());
    }
}
