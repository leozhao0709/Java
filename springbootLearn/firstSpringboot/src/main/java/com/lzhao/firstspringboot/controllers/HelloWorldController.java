package com.lzhao.firstspringboot.controllers;

import com.lzhao.firstspringboot.exceptions.UserNotFindException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
class HelloWorldController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/query")
    @ResponseBody
    public Map<String, Object> query() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from category where cid=?", "c002");
        return list.get(0);
    }


    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "name", required = false) String name) {
        if (name != null && name.equals("aaa")) {
            throw new UserNotFindException();
        }
        return "helloWorld";
    }
}
