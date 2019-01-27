package com.lzhao.cache.controllers;

import com.lzhao.cache.bean.Employee;
import com.lzhao.cache.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable("id") int id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/emp/update/{id}")
    public Employee updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
        System.out.println(employee);
        employee.setId(id);
        System.out.println(employee);
        return employeeService.updateEmployee(employee);
    }
}
