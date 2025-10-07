package com.otto.quick.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/*
  Controller 中的 handler 方法返回视图时，DispatcherServlet 会调用视图解析器解析获得的字符串
  视图解析器会给获得的字符串添加前缀 /WEB-INF/html 和后缀 .html，寻找到一个视图的完全路径
 */
@Controller
public class HelloController {

    /*
        @RequestMapping 将访问地址注册到 HandleMapping中
        @ResponseBody 直接返回字符串给前端，不找视图解析器
     */
    @RequestMapping("/mvc/hello")
    @ResponseBody
    public String hello() {
        return "hello SpringMVC!!!";
    }
}
