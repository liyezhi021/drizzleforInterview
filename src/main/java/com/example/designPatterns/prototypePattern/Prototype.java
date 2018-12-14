package com.example.designPatterns.prototypePattern;

public class Prototype implements Cloneable{

    public Object clone() throws CloneNotSupportedException{
        Prototype prototype = (Prototype) super.clone();
        return prototype;
    }
}
