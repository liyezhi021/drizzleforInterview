package com.example.algorithm.base64;

import org.apache.commons.codec.binary.Base64;

public class Base64Test {

    public static void main(String[] args){
        String base64String = "刚下去抽过烟了，我要被这帮人吵死了";
        System.out.println("Base64 start!\norigin str is->"+ base64String);
        byte[] result = Base64.encodeBase64(base64String.getBytes());
        String res = new String(result);
        System.out.println("密文："+ res);
        String res2 = "5L2g5oCO5LmI5rKh5pyJ5LiL5Y67";
        System.out.println("decode str is->"+ new String(Base64.decodeBase64(res2)));
        System.out.println("decode ok!");

    }
}
