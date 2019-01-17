package com.example.controller;

import com.example.java.java.TestAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/he")
public class WelcomeController {

    /*@TestAnnotation
    private String name;*/

    @RequestMapping(value = "/tt", method = RequestMethod.GET)
    public String index(ModelMap map) {
        map.addAttribute("host", "http://39.105.4.0:8080");
        //System.out.println("name:"+ name);
        return "/welcome";
    }

    @RequestMapping(value = "/xx", method = RequestMethod.GET)
    public void ha(){
        int a = 1;
        System.out.println("--------------------->s"+ a);
    }
}
