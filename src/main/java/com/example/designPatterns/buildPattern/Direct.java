package com.example.designPatterns.buildPattern;

public class Direct {

    public Book createBook(IBuildBook bb){
        bb.buildId();
        bb.buildName();
        bb.buildMakes();
        return bb.createBook();
    }

}
