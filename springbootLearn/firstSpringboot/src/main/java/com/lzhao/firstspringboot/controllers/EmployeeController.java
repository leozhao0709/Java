package com.lzhao.firstspringboot.controllers;

import com.lzhao.firstspringboot.dao.DepartmentDao;
import com.lzhao.firstspringboot.dao.EmployeeDao;
import com.lzhao.firstspringboot.entities.Department;
import com.lzhao.firstspringboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.List;

@Controller
class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String employeeList(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    @GetMapping("/emp/add")
    public String toAddEmployeePage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/add";
    }

    @PostMapping("/emp/add")
    public String addEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/edit/{id}")
    public String toEditEmployeePage(@PathVariable("id") int employeeId, Model model) {
        Employee employee = employeeDao.get(employeeId);
        model.addAttribute("employee", employee);

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/edit";
    }

    @PostMapping("/emp/edit/{id}")
    public String editEmployee(Employee employee) {
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int employeeId) {
        employeeDao.delete(employeeId);
        return "redirect:/emps";
    }
}
