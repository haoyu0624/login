package com.hy.controller;

import com.hy.model.OrderInfo;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class OrderController {

    @GetMapping("/order")
    public OrderInfo Login(HttpServletRequest request, HttpServletResponse response){
        OrderInfo order = new OrderInfo();
        order.setNumber(10000);
        order.setName("三居室");
        return order;
    }
}
