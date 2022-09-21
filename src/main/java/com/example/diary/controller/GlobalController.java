package com.example.diary.controller;

import com.example.diary.dto.Asd;
import com.example.diary.dto.User;
import com.example.diary.service.GlobalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GlobalController {
    @Autowired
    private GlobalService globalService;

    @ResponseBody
    @RequestMapping("/test")
    public Asd test() {

        for(User user : globalService.getUserList()) {
            System.out.println(user.toString());
        }

        return globalService.getAsdList().get(0);
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
