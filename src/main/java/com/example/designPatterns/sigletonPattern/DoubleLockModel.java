package com.example.designPatterns.sigletonPattern;

public class DoubleLockModel {

    private static DoubleLockModel dobleLockModel;

    DoubleLockModel(){}

    public static DoubleLockModel getInstance(){
        if(dobleLockModel==null){
            synchronized(DoubleLockModel.class){
                if(dobleLockModel ==null)
                    dobleLockModel = new DoubleLockModel();
            }
        }
        return dobleLockModel;
    }

}
