package com.otto.interceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("inter")
public class InterceptorController {

    @GetMapping("data1")
    public String data1() {
        System.out.println("InterceptorController data1");
        return "data1";
    }

    @GetMapping("data2")
    public String data2() {
        System.out.println("InterceptorController data2");
        return "data2";
    }
}
