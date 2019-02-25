package com.lzhao.jpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "jpa_manager")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", unique = true)
    private Department department;

    public Manager() {
    }

    public Manager(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


}
