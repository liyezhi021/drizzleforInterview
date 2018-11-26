package com.example.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @RequestMapping(value = "/test")
    public String index(ModelMap map) {
        map.addAttribute("host", "http://39.105.4.0:8080");
        return "welcome";
    }
}
