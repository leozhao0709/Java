package com.lzhao.firstspringboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class LoginController {

    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        if (!StringUtils.isEmpty(username) && "12345".equals(password)) {
            return "redirect:/dashboard";
        }

        return "login";
    }
}
