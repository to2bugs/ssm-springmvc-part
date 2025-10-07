package com.otto.initializer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OneController {

    @RequestMapping("/one")
    @ResponseBody
    public String one() {
        return "one one one";
    }
}
