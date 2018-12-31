package controllers;

import bean.User;
import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.*;
import util.DataUtil;

import java.util.Map;

@RestController
class UserRestController {

    @GetMapping("/users")
    public String findAll() {
        Map<String, User> allUsers = DataUtil.findAll();
        return JSON.toJSONString(allUsers);
    }

    @GetMapping("/users/{id}")
    @ResponseBody
    public String findById(@PathVariable String id) throws Exception {
        User user = DataUtil.findById(id);


        return JSON.toJSONString(user);
    }

    @PostMapping("/users")
    public String create(@RequestBody User user) {
        try {
            DataUtil.create(user);
            System.out.println(user.getName());
        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString("fail");
        }

        return JSON.toJSONString("success");
    }

    @PutMapping("/users/{id}")
    public String update(@PathVariable String id, @RequestBody User user) {
        try {
            DataUtil.update(id, user);
        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString("fail");
        }
        return JSON.toJSONString("success");
    }

    @DeleteMapping("/users/{id}")
    public String delete(@PathVariable String id) {

        try {
            DataUtil.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString("fail");
        }
        return JSON.toJSONString("success");
    }
}
