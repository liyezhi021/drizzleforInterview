package com.example.designPatterns.buildPattern;

public class SmartBuilder implements IBuildBook{

    Book b ;

    public SmartBuilder(){
        b = new Book();
    }

    @Override
    public void buildId() {
        b.setBookId(1);
    }

    @Override
    public void buildName() {
        b.setBookName("围城");
    }

    @Override
    public void buildMakes() {
        b.setBookMakes("xi xi");
    }

    @Override
    public Book createBook() {
        return b;
    }
}
