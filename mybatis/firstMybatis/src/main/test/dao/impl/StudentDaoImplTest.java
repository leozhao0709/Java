package dao.impl;

import bean.Student;
import dao.StudentDao;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class StudentDaoImplTest {

    private StudentDao studentDao;

    @Before
    public void setUp() throws Exception {
        this.studentDao = new StudentDaoImpl();
    }

    @Test
    public void insertStudent() {

        Student student = new Student("刘德华", 52, 98.50);
        this.studentDao.insertStudent(student);
        System.out.println(student);
    }

    @Test
    public void deleteStudent() {
        this.studentDao.deleteStudent(9);
    }

    @Test
    public void updateStudent() {
        Student s = new Student(2, "郭富城", 50, 96.5);
        this.studentDao.updateStudent(s);
    }

    @Test
    public void selectAllStudents() {
        List<Student> allStudents = this.studentDao.selectAllStudents();
        allStudents.forEach(System.out::println);
    }

    @Test
    public void selectStudentById() {
        Student student = this.studentDao.selectStudentById(2);
        System.out.println(student);
    }

    @Test
    public void selectStudentByName() {
        List<Student> students = this.studentDao.selectStudentByNameLike("郭");
        students.forEach(System.out::println);
    }
}