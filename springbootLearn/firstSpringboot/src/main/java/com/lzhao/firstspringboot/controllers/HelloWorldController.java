package com.lzhao.firstspringboot.controllers;

import com.lzhao.firstspringboot.exceptions.UserNotFindException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class HelloWorldController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "name", required = false) String name) {
        if (name != null && name.equals("aaa")) {
            throw new UserNotFindException();
        }
        return "helloWorld";
    }
}
