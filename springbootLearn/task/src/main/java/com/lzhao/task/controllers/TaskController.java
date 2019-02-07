package com.lzhao.task.controllers;

import com.lzhao.task.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping("/async")
    public String asyncFunc() throws InterruptedException {
        taskService.asyncFunc();
        return "success";
    }
}
