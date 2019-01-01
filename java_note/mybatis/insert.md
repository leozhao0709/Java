# Insert

## 1. mapper filer

```xml
<insert id="insertStudent">
    INSERT INTO student(name,age,score) VALUES (#{name},#{age},#{score})
    <selectKey resultType="int" keyProperty="id" order="AFTER">
        select @@identity
    </selectKey>
</insert>
```

Note:

-   `selectKey` is used to get the inserted value.
-   `student(name,age,score)` should match database column name.
-   `VALUES (#{name},#{age},#{score})` should match bean `private variable`.

## 2. java

```java (DAO)
public interface StudentDao {
    void insertStudent(Student student);
}
```

```java (DaoImpl)
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
```
