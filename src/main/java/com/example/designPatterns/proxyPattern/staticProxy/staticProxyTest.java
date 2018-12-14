package com.example.designPatterns.proxyPattern.staticProxy;

public class staticProxyTest {

    public static void main(String[] args){
        BookFacadeImpl bookFacade = new BookFacadeImpl();
        BookStaticProxy bookStaticProxy = new BookStaticProxy(bookFacade);
        bookStaticProxy.queryBook();
        bookStaticProxy.updateBook();
    }

}
