package com.example.designPatterns.buildPattern.build1;

public class Direct {

    public Book createBook(IBuildBook bb){
        bb.buildId();
        bb.buildName();
        bb.buildMakes();
        return bb.createBook();
    }

}
