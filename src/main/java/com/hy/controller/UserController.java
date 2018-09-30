package com.hy.controller;

import com.hy.model.UserInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {

    @GetMapping("/user")
    public UserInfo Login(HttpServletRequest request, HttpServletResponse response){
        UserInfo user = new UserInfo();
        user.setName("张三");
        user.setAge(50);
        user.setAddress("碧桂园");
        return user;
    }
}
