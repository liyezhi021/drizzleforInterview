package com.example.miniMybatis;

public interface UserMapper {

    @Insert("insert into user (name,password) values (?,?)")
    void addUser(String name, String password);
}
