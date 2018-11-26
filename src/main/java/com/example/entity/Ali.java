package com.example.entity;

import java.util.Date;

public class Ali {
    private Integer id;

    private Date date;

    private String city;

    private String age;

    private String category;

    private Integer price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ali{" +
                "id=" + id +
                ", date=" + date +
                ", city='" + city + '\'' +
                ", age='" + age + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}