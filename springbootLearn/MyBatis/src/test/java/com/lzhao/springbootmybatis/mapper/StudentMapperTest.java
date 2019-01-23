package com.lzhao.springbootmybatis.mapper;

import com.lzhao.springbootmybatis.bean.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentMapperTest {

    @Autowired
    private StudentMapper studentMapper;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getStudentById() {
        Student student = studentMapper.getStudentById(2);
        System.out.println(student);
    }

    @Test
    public void getAllStudent() {
        List<Student> students = studentMapper.getAllStudent();
        System.out.println(students);
    }

    @Test
    public void insertStudent() {
        Student s = new Student("lzhao", 17, 99.5);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Set<ConstraintViolation<Student>> violations = factory.getValidator().validate(s);
        for (ConstraintViolation<Student> violation : violations) {
            throw new RuntimeException(violation.getMessage());
        }
        System.out.println(s);
        studentMapper.insertStudent(s);
        System.out.println(s);
    }

    @Test
    public void deleteStudent() {
        studentMapper.deleteStudent(15);
    }

    @Test
    public void updateStudent() {
        Student s = new Student("lzhao", 27, 96.5);
        s.setId(13);
        System.out.println(s);
        studentMapper.updateStudent(s);
    }
}