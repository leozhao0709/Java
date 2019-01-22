package com.lzhao.springbootmybatis.mapper;

import com.lzhao.springbootmybatis.bean.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface StudentMapper {

    @Select("select * from student where id=#{id}")
    Student getStudentById(int id);

    @Select("select * from student")
    List<Student> getAllStudent();

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into student(name, age, score) values(#{name}, #{age}, #{score})")
    void insertStudent(Student student);

    @Delete("delete from student where id=#{id}")
    void deleteStudent(int id);

    @Update("update student set name=#{name},age=#{age},score=#{score} where id=#{id}")
    void updateStudent(Student student);
}
