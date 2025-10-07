package com.otto.share.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


/*
        共享域
            分类
                request： 一次请求
                session： 一次会话，一个浏览器的多次请求
                ServletContext: 整个项目
            操作
                存：setAttribute(key, object)
                取：getAttribute(key)
                删：removeAttribute(key)
 */
@Controller
@ResponseBody
@RequestMapping("share")
public class SharedController {

    // 全局的共享域
    @Autowired
    private ServletContext servletContext;

    /*
        原生共享域
     */
    @GetMapping
    public void data(
            HttpServletRequest request,
            HttpSession session
    ) {
        servletContext.setAttribute("share_servletContext", "servletContext");
        request.setAttribute("share_request", "request");
        session.setAttribute("share_session", "session");
    }


    /*
        SpringMVC提供的共享域
         1. request 级别的共享域
            Model
            ModelMap
            Map<String, Object>
            HttpServletRequest
            ModelAndView
     */
    public void data1(Model model) {
        model.addAttribute("share_model", "model");
    }
    public void data2(ModelMap model) {
        model.addAttribute("share_modelMap", "modelMap");
    }
    public void data3(Map<String, Object> map) {
        map.put("share_map", "map");
    }
    public ModelAndView data4() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("share_modelAndView", "modelAndView");
        mav.setViewName("视图的名称"); // 必须设置的
        return mav;
    }
}
