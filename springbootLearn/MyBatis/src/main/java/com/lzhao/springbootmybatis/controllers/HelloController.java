package com.lzhao.springbootmybatis.controllers;

import com.lzhao.springbootmybatis.bean.Result;
import com.lzhao.springbootmybatis.bean.Student;
import com.lzhao.springbootmybatis.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
class HelloController {

    @Autowired
    private StudentMapper studentMapper;

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable("id") int id) {
        return studentMapper.getStudentById(id);
    }

    @PostMapping("/student/add")
    public Result addStudent(@Valid @RequestBody Student s, BindingResult bindingResult) {
        Result result = new Result();

        if (bindingResult.hasErrors()) {
            result.setCode(1);
            result.setMsg(bindingResult.getFieldError().getDefaultMessage());
            return result;
        }

        studentMapper.insertStudent(s);
        result.setCode(0);
        result.setMsg("success");
        result.setData(s);

        return result;
    }
}
