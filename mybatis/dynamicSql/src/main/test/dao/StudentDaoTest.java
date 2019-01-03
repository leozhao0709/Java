package dao;

import bean.Student;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.MyBatisUtil;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StudentDaoTest {

    private SqlSession sqlSession;
    private StudentDao studentDao;

    @Before
    public void setUp() throws Exception {
        sqlSession = MyBatisUtil.getSqlSession();
        studentDao = sqlSession.getMapper(StudentDao.class);
    }

    @After
    public void tearDown() throws Exception {
        sqlSession.close();
    }

    @Test
    public void findByNameAndAge() {
        List<Student> students = studentDao.findByNameAndAge(new Student("刘", 60));
        students.forEach(System.out::println);
    }

    @Test
    public void selectForeachArray() {
        int[] ids = {1,3,5,7,9};
        List<Student> students = studentDao.selectForeachArray(null);
        students.forEach(System.out::println);
    }

    @Test
    public void selectForeachList() {
        List<Student> studentsList = new ArrayList<>();
        studentsList.add(new Student(1));
        studentsList.add(new Student(3));
        studentsList.add(new Student(5));
        List<Student> students = studentDao.selectForeachList(studentsList);
        students.forEach(System.out::println);
    }
}