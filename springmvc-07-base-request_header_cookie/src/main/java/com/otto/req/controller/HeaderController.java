package com.otto.req.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/header")
public class HeaderController {

    /*
        @RequestHeader 获取请求头
     */
    @GetMapping("data")
    public String data(@RequestHeader("Accept") String accept) {
        return "accept = " + accept;
    }
}
