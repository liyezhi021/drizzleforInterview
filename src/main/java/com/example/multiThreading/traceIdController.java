package com.example.multiThreading;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/traceId")
public class traceIdController {

    @Autowired
    private TestTraceId testTraceId;

    @RequestMapping("/hello")
    public String test(){
        testTraceId.test1();
        return "ok";
    }

}
