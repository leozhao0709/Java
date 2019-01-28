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
        employee.setId(id);
        return employeeService.updateEmployee(employee);
    }

    @GetMapping("/emp/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmp(id);
        return "success";
    }

    @GetMapping("/emp/lastname/{lastname}")
    public Employee getEmployee(@PathVariable("lastname") String lastName) {
        return employeeService.getEmployeeByLastName(lastName);
    }
}
