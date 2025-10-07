package com.otto.param.controller;

import com.otto.param.pojo.User;
import jakarta.json.Json;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/*
    param 参数
        param 类型的参数会被编码为 ASCII 码。例如，假设 name=john doe，则会被编码为 name=john%20doe
        形式：name=jo&age=18
 */
@Controller
@RequestMapping("param")
public class UserController {

    /*
        直接接收值
        /param/data1?name=root&age=18
        请求参数名 == 形参参数名
        ‼️前端如果不传递，不会报错的哦，且不传的值为null
     */
    @RequestMapping("/data1")
    @ResponseBody
    public String data1(String name, Integer age) {
        return "name = " + name + ", age == " + age;
    }


    /*
        @RequestParam 注解指定接值
        /param/data2?name=root&age=18
        可以指定请求参数名，可以要求必须传递，可以要求不必传递，还可以设置默认值
        要求：
        指定请求参数名为account, 且必须传递
        age可以不传递，其默认值为50
     */
    @RequestMapping("data2")
    @ResponseBody
    public String data2(
            @RequestParam(value = "account", required = true) String name,
            @RequestParam(value = "age", required = false, defaultValue = "50") Integer age
    ) {
        System.out.println("name: " + name + ", age: " + age);
        return "name = " + name + ", age == " + age;
    }


    /*
        特殊值接值
        一名多值： key=value1&key=value2&key=value3
        直接使用集合List<?>接值
        param/data3?hbs=吃&hbs=玩&hbs=睡
       ㊙️对于形参是List<?>类型的，必须使用注解@RequestParam，否则接受不到数据的
       ㊙️如果不添加注解@RequestParam，会将hbs对应的一个字符串直接赋值给集合的，所以会报类型异常的
     */
    @RequestMapping("data3")
    @ResponseBody
    public List<String> data3(@RequestParam("hbs") List<String> habits) {
        habits.forEach(System.out::println);
        return habits;
    }


    /*
        使用实体对象接值
        /param/data4?name=二狗子&age=36&gender=男
        接受参数: 准备一个有对应属性和getter、setter方法的实体类即可哦
                🛑请求的参数名 === 接受对象的属性名，多余的参数接受对象是接受不到的
        ❌注意：不能使用注解@RequestParam
     */
    @RequestMapping("data4")
    @ResponseBody
    public String data4(User user) {
        System.out.println(user);
        return user.toString();
    }
}
