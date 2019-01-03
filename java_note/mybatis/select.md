# select

## 1. mapper

```xml
<!-- select all -->
<select id="selectAllStudent" resultType="student">
    select id, name, age, score from student
</select>

<!-- select single -->
<select id="selectStudentById" resultType="student">
    select id, name, age, score from student where id=#{id}
</select>

<!-- select like -->
<select id="selectStudentByNameLike" resultType="student">
    select id, name, age, score from student where name like '%' #{name} '%'
</select>
```

## 2. java

```java (DAO)
List<Student> selectAllStudents();
Student selectStudentById(int id);
List<Student> selectStudentByNameLike(String name);
```

```java (impl, optional if you are using mapper proxy)
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
```
