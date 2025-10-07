package com.otto.body.controller;

import com.otto.body.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("json")
@Controller
@ResponseBody
public class PersonController {

    /*
        @RequestBody 接受 json
        post方法，在请求体中的json数据 {name, age, gender}

       ❌HTTP状态 415 - 不支持的媒体类型
         原因：Java原生的API只支持路径参数和param参数，而不支持json参数
         解决：
            1，导入处理json数据的相关的依赖
                jackson-databind
            2，在HandlerAdapter中配置json转化器
                在配置类上，这里是SpringMVCConfiguration，配置@EnableWebMvc，这个注解相当于给HandlerAdapter配置了json转换器
     */
    @PostMapping("/data")
    public String data(@RequestBody Person person) {
        System.out.println("person: " + person);
        return person.toString();
    }
}
