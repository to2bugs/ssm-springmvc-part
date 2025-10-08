package com.otto.validator.controller;

import com.otto.validator.pojo.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class ValidateController {

    /*
        参数校验的步骤：
        1. 实体类属性添加校验
        2. Controller的handler方法中使用校验注解 @Validated 校验传入的数据
            不论是 param or json 数据都可以使用 @Validated

        如果不符合校验的规则，会直接向前端抛出异常
        希望是接受到错误信息，并自定义返回结果
        捕捉错误信息
        1. 在Controller的handler中添加参数 BindingResult bindingResult
            且 BindingResult bindingResult 必须紧紧挨着校验对象
            比如 @Validated @RequestBody User user, BindingResult bindingResult, HttpSession session
            BindingResult bindingResult 不能在 HttpSession session 的后面
        2. BindingResult bindingResult 用于绑定校验的结果
     */
    @PostMapping("register")
    public Object register(@Validated @RequestBody User user, BindingResult bindingResult, HttpSession session) {
        // 校验是否失败，true 失败；false 成功
        boolean isValidateFailed = bindingResult.hasErrors();
        if (isValidateFailed) {
            Map<String, Object> errorMap = new HashMap<String, Object>();

            bindingResult.getFieldErrors().forEach((fieldError) -> {
                // System.out.println(fieldError.getField()); // 获取错误的字段
                // System.out.println(fieldError.getDefaultMessage()); // 获取字段错误的原因
                errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            });

            // 校验失败，自定义返回数据
            Map<String, Object> map = new HashMap<>();
            map.put("code", 400);
            map.put("message", errorMap);
            return map;
        }

        System.out.println("user = " + user);
        return user;
    }
}
