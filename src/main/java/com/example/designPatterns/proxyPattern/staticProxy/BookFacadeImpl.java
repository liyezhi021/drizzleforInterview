package com.example.designPatterns.proxyPattern.staticProxy;

public class BookFacadeImpl implements IBookFacade{
    @Override
    public void queryBook() {
        System.out.println("query book ...");
    }

    @Override
    public void updateBook() {
        System.out.println("update book...");
    }
}
