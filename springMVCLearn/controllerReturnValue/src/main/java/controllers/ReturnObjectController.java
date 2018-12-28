package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
class ReturnObjectController {

    @RequestMapping(value = "/returnString", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String returnString() {
        return "哈哈哈哈哈";
    }

    @RequestMapping("/returnMap")
    @ResponseBody
    public Map<String, String> returnMap() {
        Map<String, String> map = new HashMap<>();

        map.put("hello", "你好");
        map.put("world", "世界");

        return map;
    }
}
