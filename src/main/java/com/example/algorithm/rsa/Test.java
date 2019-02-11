package com.example.algorithm.rsa;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        Map<String, String> keyMap = RSAUtil.createKeys(512);
        String publicKey = keyMap.get("publicKey");
        String privateKey = keyMap.get("privateKey");
        System.out.println("公钥: \n\r" + publicKey);
        System.out.println("私钥： \n\r" + privateKey);
        System.out.println("公钥加密——私钥解密");
        String str = "我十分欣赏你这个狗叼";
        System.out.println("\r明文：\r\n" + str);
        //System.out.println("\r明文大小：\r\n" + str.getBytes().length);
        String encodedData = null;
        try {
            encodedData = RSAUtil.publicEncrypt(str, RSAUtil.getPublicKey(publicKey));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        System.out.println("密文：\r\n" + encodedData);
        String decodedData = null;
        try {
            decodedData = RSAUtil.privateDecrypt(encodedData, RSAUtil.getPrivateKey(privateKey));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        System.out.println("解密后文字: \r\n" + decodedData);
    }

}
