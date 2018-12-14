package com.example.designPatterns.proxyPattern.jdkProxy;

public class BookFacadeImpl implements BookFacade{
    @Override
    public void addBook() {
        System.out.println("新增图书方法...");
    }
}
