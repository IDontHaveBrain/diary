package com.example.diary.controller;

import com.example.diary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(String email, String pw) {
        if (userService.login(email, pw)) {
            System.out.println("로그인 성공");
            return "redirect:/";
        } else {
            System.out.println("로그인 실패");
            return "redirect:/login";
        }
    }
}
