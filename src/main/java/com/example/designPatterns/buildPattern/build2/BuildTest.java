package com.example.designPatterns.buildPattern.build2;

public class BuildTest {

    public static void main(String[] args){
        System.out.println(new Book.Builder(1).buildBookName("jane love")
                .buildBookMark("favorite").build());
    }

}
