package com.lzhao.springbootmybatis.bean;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


public class Student {

    private int id;
    @Length(min = 2, max = 4, message = "name is between 1 to 3")
    private String name;
    @Min(value = 18, message = "min value is 18")
    @Max(value = 30, message = "max value is 30")
    private int age;
    @Min(value = 60, message = "must have a score")
    private Double score;

    public Student(String name, int age, Double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", score='" + score + '\'' +
                '}';
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
