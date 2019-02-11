package com.example.test;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args){
        List list = new ArrayList();
        list.add("qq");
        list.add("ww");
        list.add(100);

        for(int i=0; i<list.size(); i++){
            String name = (String) list.get(i);
            System.out.println(name);
        }
    }
}
