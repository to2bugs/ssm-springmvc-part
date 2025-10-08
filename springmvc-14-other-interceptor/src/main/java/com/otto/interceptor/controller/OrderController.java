package com.otto.interceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("o")
public class OrderController {

    @GetMapping("order1")
    public String  order1() {
        System.out.println("OrderController order1");
        // System.out.println("OrderController order1 出现异常");
        // int i = 1 / 0;
        return "order1";
    }

    @GetMapping("order2")
    public String  order2() {
        System.out.println("OrderController order2");
        return "order2";
    }
}
