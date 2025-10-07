package com.otto.req.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("origin")
@ResponseBody
public class HttpOriginController {

    @Autowired
    private ServletContext servletContext;

    /*
        原生对象的获取
            HttpServletResponse
            HttpServletRequest
     */
    public void data(
            HttpServletResponse response,
            HttpServletRequest request,
            HttpSession session
            ) {
        /**
         * ServletContext 会自动的装入IOC容器中
         *  是最大的配置文件
         *  是全局最大的共享域♨️
         *  是核心的API
         */
        ServletContext servletContext1 = request.getServletContext();
        ServletContext servletContext2 = session.getServletContext();
    }
}
