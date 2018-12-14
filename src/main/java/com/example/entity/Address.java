package com.example.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Address implements Serializable {

    private String postcode;

    private String stress;

    private String state;

}
