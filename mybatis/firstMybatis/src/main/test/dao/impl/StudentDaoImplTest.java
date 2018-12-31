package dao.impl;

import bean.Student;
import dao.StudentDao;
import org.junit.Before;
import org.junit.Test;


public class StudentDaoImplTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void insertStudent() {
        StudentDao studentDao = new StudentDaoImpl();
        Student student = new Student("刘德华", 52, 98.50);

        studentDao.insertStudent(student);
    }
}