package com.example.entity;

import org.springframework.boot.autoconfigure.cache.CacheProperties;

import java.io.Serializable;

public class RedisUser implements Serializable {

    public static final String Table = "user_redis";

    private String username;
    private Integer age;

    public RedisUser(){

    }

    public RedisUser(String username,Integer age){
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "RedisUser{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
