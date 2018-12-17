package com.example.controller;

import com.example.mapper.majorDs.DrizzleMapper;
import com.example.mapper.minorDs.AliMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mulDataSource")
public class MultipleDataSourceController {

    @Autowired
    private AliMapper aliMapper;

    @Autowired
    private DrizzleMapper drizzleMapper;

    @GetMapping("/test")
    public void test(){
        System.out.println("drizzle..."+drizzleMapper.selectByPrimaryKey(1));
        System.out.println("ali..."+aliMapper.selectByPrimaryKey(1));
    }


}
