package com.hy.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class LoginController {

    @RequestMapping("/authentication/form")
    public String Login(HttpServletRequest request, HttpServletResponse response){
        System.out.println("登陆成功");
        return "success";
    }
}
