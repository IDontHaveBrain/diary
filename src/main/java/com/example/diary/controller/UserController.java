package com.example.diary.controller;

import com.example.diary.dto.User;
import com.example.diary.service.GlobalService;
import com.example.diary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class UserController {
    @Autowired
    private GlobalService globalService;
    @Autowired
    private UserService userService;

    @RequestMapping("/loginTest")
    @ResponseBody
    public String loginTest(String email, String pw) {
        return userService.login("jonamjun.dev@gmail.com", "123123") ? "success" : "fail";
    }
    @RequestMapping("/login")
    public String login(Model model, User user, HttpSession session) {
        //System.out.println(user.toString());

        User check = userService.getUser(user.getEmail(), user.getPw());
        if (check != null) {
            model.addAttribute("logged", true);
            session.setAttribute("user", check);
            session.setMaxInactiveInterval(60*20);
        }

        return "login";
    }
    @RequestMapping("/logout")
    public String logout(Model model, HttpSession session) {
        session.removeAttribute("user");
        model.addAttribute("logged", false);
        return "login";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(Model model, @ModelAttribute @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("errors", globalService.getErrors(result));
        } else {
            userService.signup(user);
            return "redirect:/login";
        }
        return "signup";
    }

    @RequestMapping("/checkEmail")
    @ResponseBody
    public boolean checkEmail(String email) {
        return userService.checkEmail(email);
    }

    @RequestMapping("/asd")
    public String asd() {
        return "asd";
    }
}
