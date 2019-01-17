package com.lzhao.firstspringboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
class LoginController {

    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, String> map, HttpSession session) {
        if (!StringUtils.isEmpty(username) && "12345".equals(password)) {
            session.setAttribute("username", username);
            return "redirect:/dashboard";
        }

        map.put("msg", "invalid username or password!");
        return "login";
    }
}
