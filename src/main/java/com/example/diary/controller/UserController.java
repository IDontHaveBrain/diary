package com.example.diary.controller;

import com.example.diary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public String login(String email, String pw) {
        return userService.login("jonamjun.dev@gmail.com", "123123") ? "success" : "fail";
    }
}
