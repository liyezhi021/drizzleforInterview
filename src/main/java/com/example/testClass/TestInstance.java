package com.example.testClass;

import java.util.*;

public class TestInstance {

    public static void main(String[] args){
        Book b = new Book();
        BookFacade bc = new BookFacade();
        Object[] numbers = {1,2,"s",4,5};
        Object[] numbers1 = Arrays.copyOf(numbers, 5);
        System.out.println("b.instanceOf-->" + (bc instanceof Book));
    }

}
