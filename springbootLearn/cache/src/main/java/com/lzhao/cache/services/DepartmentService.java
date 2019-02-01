package com.lzhao.cache.services;

import com.lzhao.cache.bean.Department;
import com.lzhao.cache.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Cacheable(cacheNames = {"dept"})
    public Department getDepartmentById(int id) {
        return departmentMapper.getDepartmentById(id);
    }
}
