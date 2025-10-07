package com.otto.json.controller;

import com.otto.json.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/*
    todo:
        返回json格式的字符串
            HandlerAdapter 将对象转换为Json格式的字符串
            因为使用了@ResponseBody 所以不会去查找视图解析器，直接放在响应体中返回

    @ResponseBody 数据直接放入响应体返回
                  不会走视图解析器，即快速查找视图、转发和重定向都不会生效了

 */
@RequestMapping("json")
// @Controller
// @ResponseBody // 响应Json对象，HandlerAdapter 将对象转换为Json格式的字符串
@RestController
public class JsonController {

    /*
        @RequestBody
        接受json对象
     */

    /*
        返回json
     */
    @GetMapping("user")
    public User user() {
        User user = new User();
        user.setAge(18);
        user.setName("otto");
        // user对象会在HandlerAdapter中转为Json格式的字符串
        // 并在@ResponseBody的加持下，将Json格式的字符串放在响应体中返回
        return user;
    }

    /*
        返回json
     */
    @GetMapping("users")
    public List<User> users() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setAge(18 + i);
            user.setName("otto_" + i);
            users.add(user);
        }
        return users;
    }
}
