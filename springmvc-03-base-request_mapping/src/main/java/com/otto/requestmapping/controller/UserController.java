package com.otto.requestmapping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/*
    @RequestMapping 的作用是将 login()和请求路径 /user/login 注册到 HandlerMapping 中
        不是必须使用 / 开头的，比如 user/login 也是可以的
        1. 精准地址 value = {"/user/login", "login"}
        2. 模糊地址
            *: 任意一层字符串 /user/a ✔️ /user/aaaa ✔️ 但是 /user/a/b ❌
           **: 任意层任意字符串 /user ✔️ /user/a ✔️ /user/aaaa ✔️ /user/a/b/a/c ✔️
        3. 类上和方法上添加@RequestMapping，类上是同样的访问地址，方法上是具体的handler地址
            访问地址 = 类上的地址 + 方法上的地址
        4. 请求地址的
            客户端 -> http(get | post | put | delete) -> ds -> controller handler
            @RequestMapping(value = "") 任何的方法都可以访问到
            @RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST}) get or post请求能访问到
            不符合请求方式，会返回405异常‼️
        5. 注解进阶，只能用在方法上
            @GetMapping @PostMapping @PutMapping @DeleteMapping
 */
@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping
    public String index() {
        return "index";
    }

    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @PostMapping("register")
    public String register() {
        return "register";
    }
}
