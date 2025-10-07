package com.otto.req.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("cookie")
public class CookieController {

    /*
        取 Cookie
        @CookieValue(value = "cookie的key") 接受cookie上的值
     */
    @RequestMapping("data")
    public String data(@CookieValue(value = "cookieName") String cookie) {
        System.out.println("cookie:" + cookie);
        return cookie;
    }

    /*
        存 Cookie
     */
    @GetMapping("save")
    public String save(HttpServletResponse response) {
        Cookie cookie = new Cookie("cookieName", "root");
        response.addCookie(cookie);
        return "ok";
    }
}
