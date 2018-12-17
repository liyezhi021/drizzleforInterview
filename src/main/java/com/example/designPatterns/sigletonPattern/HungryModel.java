package com.example.designPatterns.sigletonPattern;

public class HungryModel {

    private static HungryModel hungryModel = new HungryModel();

    public HungryModel(){
    }

    public static HungryModel getInstance() {
        return hungryModel;
    }
}
