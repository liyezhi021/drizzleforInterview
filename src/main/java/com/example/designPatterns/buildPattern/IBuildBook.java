package com.example.designPatterns.buildPattern;

public interface IBuildBook {

    void buildId();

    void buildName();

    void buildMakes();

    Book createBook();

}
