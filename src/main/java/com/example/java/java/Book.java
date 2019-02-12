package com.example.java.java;

@MyAnnotation
public class Book {

    @MyAnnotation()
    private String name;

    @MyAnnotation(name = "define", email = "define@qq.com")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @MyAnnotation(name = "usages")
    public String usagesAnn(){
        return "ann";
    }
}
