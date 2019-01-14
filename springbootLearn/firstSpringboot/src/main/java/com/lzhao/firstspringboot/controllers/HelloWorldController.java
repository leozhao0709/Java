package com.lzhao.firstspringboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class HelloWorldController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "helloWorld";
    }
}
