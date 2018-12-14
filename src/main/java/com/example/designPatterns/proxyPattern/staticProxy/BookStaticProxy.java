package com.example.designPatterns.proxyPattern.staticProxy;

public class BookStaticProxy implements IBookFacade{

    private BookFacadeImpl bookFacade;

    public BookStaticProxy(BookFacadeImpl bookFacade){
        this.bookFacade = bookFacade;
    }

    @Override
    public void queryBook() {
        bookFacade.queryBook();
    }

    @Override
    public void updateBook() {
        bookFacade.updateBook();
    }
}
