package com.lzhao.springbootmybatis.controllers;

import com.lzhao.springbootmybatis.bean.Student;
import com.lzhao.springbootmybatis.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloController {

    @Autowired
    private StudentMapper studentMapper;

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable("id") int id) {
        return studentMapper.getStudentById(id);
    }
}
