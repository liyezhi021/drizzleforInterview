package com.example.algorithm.base64;

import org.apache.commons.codec.binary.Base64;

public class Base64Test {

    public static void main(String[] args){
        String base64String = "yoo愁";
        System.out.println("Base64 start!\norigin str is->"+ base64String);
        byte[] result = Base64.encodeBase64(base64String.getBytes());
        String res = new String(result);
        System.out.println("decode str is->"+ new String(Base64.decodeBase64(res)));
        System.out.println("decode ok!");

    }
}
