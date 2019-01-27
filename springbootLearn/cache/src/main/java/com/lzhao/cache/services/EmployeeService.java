package com.lzhao.cache.services;

import com.lzhao.cache.bean.Employee;
import com.lzhao.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Cacheable(cacheNames = {"emps"})
    public Employee getEmployeeById(int id) {
        return employeeMapper.getEmployeeById(id);
    }

    public Employee updateEmployee(Employee employee) {
        employeeMapper.updateEmployee(employee);
        return employee;
    }
}
