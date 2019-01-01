package dao.impl;

import bean.Student;
import dao.StudentDao;
import org.apache.ibatis.session.SqlSession;
import utils.MyBatisUtil;

import java.util.List;

class StudentDaoImpl implements StudentDao {

    @Override
    public void insertStudent(Student student) {
        //SqlSession继承了AutoCloseable接口，所以可以自动关闭
        try(SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            //新增数据操作
            sqlSession.insert("insertStudent", student);
            //提交SqlSession
            sqlSession.commit();
        }
    }

    @Override
    public void deleteStudent(int id) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            sqlSession.delete("deleteStudent", id);
            sqlSession.commit();
        }
    }

    @Override
    public void updateStudent(Student student) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            sqlSession.update("updateStudent", student);
            sqlSession.commit();
        }
    }

    @Override
    public List<Student> selectAllStudents() {
        List<Student> allStudents;
        try(SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            allStudents = sqlSession.selectList("selectAllStudent");
        }

        return allStudents;
    }

    @Override
    public Student selectStudentById(int id) {
        Student student;
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            student = sqlSession.selectOne("selectStudentById", id);
        }

        return student;
    }

    @Override
    public List<Student> selectStudentByNameLike(String name) {
        List<Student> students;
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            students = sqlSession.selectList("selectStudentByNameLike", name);
        }
        return students;
    }
}
