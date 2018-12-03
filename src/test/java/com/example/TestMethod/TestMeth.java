package com.example.TestMethod;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestMeth {

    public static void main(String[] args) {
        //String str = "http://ht3.dcfservice.com/download/20180820/f409490b-7230-47ef-8a8b-af89e5f115e3.jpg";
        /*String reg2 = "/([com]+)$/";
        Pattern p=Pattern.compile(reg2);
        Matcher m = p.matcher(str);*/
        //System.out.println(str.replaceAll(".*com",""));
        System.out.println("aaa换页\n\f-----");
        int a = 1<<4;
        String s = "(){}[]";
        for(int i=0;i<s.length();i++){
            int j = s.charAt(i);
            System.out.println(i+"--->"+ j);
        }
    }
}
