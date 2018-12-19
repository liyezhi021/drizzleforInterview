package com.example.aop;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("aop")
public class TestAopMethod {

    @RequestMapping("test")
    public String test(){
        System.out.println("do Something!");
        return "success";
    }

}
