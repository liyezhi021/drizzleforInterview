package com.example.designPatterns.sigletonPattern;

public class FullModel {

    private static FullModel fullModel = null;

    public FullModel(){}

    public static FullModel getInstance(){
        if(fullModel!= null)
            fullModel = new FullModel();
        return fullModel;
    }

}
