package com.example.jvm.classLoader;

public class TClass {

    static {
        System.out.println("TClass static be executed!");
    }

    private String testStr;

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }
}
