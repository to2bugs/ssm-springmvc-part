package com.otto.restful.controller;

import com.otto.restful.pojo.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    /*
        Restfulf风格的分页查询
     */
    @GetMapping
    public List<User> users(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "size", required = false, defaultValue = "10") Integer size
    ) {
        return null;
    }

    /*
        Restful风格的 添加用户
     */
    @PostMapping
    public User save(@RequestBody User user) {
        return null;
    }

    /*
        Restful风格的 用户详情
     */
    @GetMapping("{id}")
    public User get(@PathVariable("id") Integer id) {
        return null;
    }

    /*
        Restful风格的 用户更新
     */
    @PutMapping
    public User update(@RequestBody User user) {
        return null;
    }

    /*
        Restful风格的 删除用户
     */
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {

    }

    /*
        Restful风格的 用户模糊查询
     */
    @GetMapping("search")
    public List<User> search(
            @RequestParam(value = "page", required = false, defaultValue = "1") String name,
            @RequestParam(value = "size", required = false, defaultValue = "10") Integer age,
            @RequestParam(value = "keyword", required = false)
            ) {
        return null;
    }
}
