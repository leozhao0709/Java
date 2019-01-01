package dao;

import bean.Student;

import java.util.List;

public interface StudentDao {
    void insertStudent(Student student);
    void deleteStudent(int id);
    void updateStudent(Student student);
    List<Student> selectAllStudents();
    Student selectStudentById(int id);
    List<Student> selectStudentByNameLike(String name);
}
