package com.example.entity;

public class User {
    private Integer id;

    private String name;

    private String password;

    private String sex;

    private String phone;

    private String email;

    private String hobby;

    private String goodat;

    private String githubaccount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby == null ? null : hobby.trim();
    }

    public String getGoodat() {
        return goodat;
    }

    public void setGoodat(String goodat) {
        this.goodat = goodat == null ? null : goodat.trim();
    }

    public String getGithubaccount() {
        return githubaccount;
    }

    public void setGithubaccount(String githubaccount) {
        this.githubaccount = githubaccount == null ? null : githubaccount.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", hobby='" + hobby + '\'' +
                ", goodat='" + goodat + '\'' +
                ", githubaccount='" + githubaccount + '\'' +
                '}';
    }
}