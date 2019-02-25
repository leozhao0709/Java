package com.lzhao.jpa.entity;

import com.lzhao.jpa.repository.DepartmentRepository;
import com.lzhao.jpa.repository.ManagerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DepartmentAndManagerTest {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private ManagerRepository managerRepository;

    @Test
    public void insert() {
        Department department = new Department("D-BB");
        departmentRepository.save(department);

        Manager manager = new Manager("M-BB", department);
        department.setManager(manager);
        managerRepository.save(manager);
    }
}
