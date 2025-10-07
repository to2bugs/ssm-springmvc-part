package com.otto.output.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("jsp")
public class JspController {

    /*
        todo: 快速的查找视图
            1. 方法的返回值是字符串类型
            2. 不能添加@ResponseBody注解
            3. 返回值 对应中间的视图名称即可
     */
    @GetMapping("/index")
    public String index(HttpServletRequest request) {
        request.setAttribute("data", "Hello JSP");
        return "index";
    }


    /*
        todo: 转发
            转发只能到项目下的资源哦，所有可以忽略applicationContext
            1. 方法的返回值是字符串类型
            2. 不能添加@ResponseBody注解
            3. 返回的字符串前添加 forward:/转发的地址
                返回值中 forward: 是固定的写法
     */
    @GetMapping("forward")
    public String forward() {
        return "forward:/jsp/index";
    }


    /*
        todo: 重定向
            重定向可以是项目下的资源，也可以是外部资源
            重定向是二次请求，但忽略applicationContext
            1. 方法的返回值是字符串类型
            2. 不能添加@ResponseBody注解
            3. 返回的字符串前添加 redirect:/重定向的地址
                返回值中 redirect: 是固定的写法
     */
    @GetMapping("redirect")
    public String redirect() {
        return "redirect:/jsp/index";
        // return "redirect:https://www.bing.com";
    }
}
