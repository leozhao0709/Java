package dao;

import bean.Student;

import java.util.List;

interface StudentDao {
    List<Student> findByNameAndAge(Student student);
    List<Student> selectForeachArray(int[] ids);
    List<Student> selectForeachList(List<Student> students);
}
