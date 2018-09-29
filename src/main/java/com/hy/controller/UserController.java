package com.hy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {

    @GetMapping("/user")
    public String Login(HttpServletRequest request, HttpServletResponse response){
        System.out.println("获取用户");
        return "success";
    }
}
