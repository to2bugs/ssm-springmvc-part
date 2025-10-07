package com.otto.path.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("path")
@ResponseBody
public class PathController {

    /*
        使用注解@PathVariable指定路径参数
        /path/账号/密码
     */
    @RequestMapping("{account}/{password}")
    public String login(
            @PathVariable("account") String username,
            @PathVariable("password") String password
    ) {

        return "account:" + username + ", password:" + password;
    }
}
