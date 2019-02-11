package com.example.test;

public class Box<E> {

    private E data;

    public Box(){
    }

    public Box(E date){
        this.data = date;
    }

    public E getData() {
        return data;
    }
}
