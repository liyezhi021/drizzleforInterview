package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/user")
public class MvUserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/login", produces = {"application/json;charset=UTF-8"})
    public ModelAndView user_login(HttpSession session, String username, String password) {
        ModelAndView mv = new ModelAndView();
        User user = userService.userlogin(username, password);
        if (user != null) {
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            mv.addObject("message", "success");
            mv.setViewName("main");
        } else {
            mv.addObject("message", "failure");
            mv.setViewName("login_failure");
        }
        return mv;
    }
}
