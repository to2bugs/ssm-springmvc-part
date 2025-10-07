package com.otto.quick.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    /*
        @RequestMapping 将访问地址注册到 HandleMapping中
        @ResponseBody 直接返回字符串给前端，不找视图解析器
     */
    @GetMapping("/mvc/hello")
    @ResponseBody
    public String hello() {
        return "hello SpringMVC!!!";
    }
}
