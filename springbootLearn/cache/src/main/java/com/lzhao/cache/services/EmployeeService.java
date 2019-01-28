package com.lzhao.cache.services;

import com.lzhao.cache.bean.Employee;
import com.lzhao.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(
        cacheNames = {"emps"}
)
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Cacheable
    public Employee getEmployeeById(int id) {
        return employeeMapper.getEmployeeById(id);
    }

    @CachePut(key = "#result.id")
    public Employee updateEmployee(Employee employee) {
        employeeMapper.updateEmployee(employee);
        return employee;
    }

    @CacheEvict(cacheNames = {"emps"}, key = "#id", beforeInvocation = true)
    public void deleteEmp(int id) {
        employeeMapper.deleteEmployeeById(id);
    }

    @Caching(
        cacheable = {
            @Cacheable(cacheNames = {"emps"}, key = "#lastName")
        },
        put = {
            @CachePut(cacheNames = {"emps"}, key = "#result.id"),
            @CachePut(cacheNames = {"emps"}, key = "#result.email")
        }
    )
    public Employee getEmployeeByLastName(String lastName) {
        return employeeMapper.getEmployeeByLastName(lastName);
    }
}
