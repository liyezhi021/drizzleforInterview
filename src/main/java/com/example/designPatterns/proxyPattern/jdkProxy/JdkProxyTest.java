package com.example.designPatterns.proxyPattern.jdkProxy;

public class JdkProxyTest {

    public static void main(String[] args){
        BookFacadeImpl bookFacade = new BookFacadeImpl();
        BookFacadeJdkProxy bookFacadeJdkProxy = new BookFacadeJdkProxy();
        BookFacade bookFacade1 = (BookFacade) bookFacadeJdkProxy.bind(bookFacade);
        bookFacade1.addBook();
    }
}
