package com.example.java.java;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationTest {

    public static void main(String[] args){
        Field[] fields = Book.class.getDeclaredFields();
        for(int i=0; i<fields.length; i++){
            MyAnnotation ann = fields[i].getAnnotation(MyAnnotation.class);
            if(ann!= null){
                System.out.println("property="+ ann.name());
                System.out.println("pro2="+ ann.email());
            }
        }
        Method[] methods = Book.class.getDeclaredMethods();
        for(Method method : methods){
            MyAnnotation a = method.getAnnotation(MyAnnotation.class);
            if(a!= null){
                System.out.println("pro2->"+ a.name());
                System.out.println("pro2->"+ a.email());
            }
        }

        System.out.println("\n");
        MyAnnotation mas = SubBook.class.getAnnotation(MyAnnotation.class);
        System.out.println(mas.name());
        System.out.println(mas.email());
    }
}
