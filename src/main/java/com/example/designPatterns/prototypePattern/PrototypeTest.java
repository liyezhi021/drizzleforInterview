package com.example.designPatterns.prototypePattern;

import com.example.entity.Address;

import java.io.IOException;

public class PrototypeTest {

    public static DeepAndShallowClone deepAndShallowClone = new DeepAndShallowClone();

    public static void main(String[] args){

        Address add = new Address();
        add.setPostcode("1");
        add.setState("2");
        add.setStress("3");
        try {
            //Address add2 = add.clone();
            Address add1 = (Address) deepAndShallowClone.deepClone(add);
            add1.setState("100");
            System.out.println("state--->"+ add.getState());
            System.out.println("state1--->"+ add1.getState());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
