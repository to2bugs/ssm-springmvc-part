package com.otto.exp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    /*
        空指针异常 java.lang.NullPointerException
     */
    @GetMapping("data1")
    public String data1() {
        String name = null;
        name.toString(); // 空指针异常 java.lang.NullPointerException
        return "空指针异常";
    }


    /*
        算术异常 java.lang.ArithmeticException
     */
    @GetMapping("data2")
    public String data2() {
        int i = 10 / 0; // 除零异常 java.lang.ArithmeticException
        return "除零异常";
    }
}
