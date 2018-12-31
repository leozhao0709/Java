package dao.impl;

import bean.Student;
import dao.StudentDao;
import org.apache.ibatis.session.SqlSession;
import utils.MyBatisUtil;

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
}
