# Delete

## 1. mapper

```xml
<delete id="deleteStudent">
    DELETE from student where id=#{id}
</delete>
```

Note:

-   `#{id}` is just a placeholder, you can set every name for it.

## 2. java

```java (DAO)
void deleteStudent(int id);
```

```java (impl)
@Override
public void deleteStudent(int id) {
    try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
        sqlSession.delete("deleteStudent", id);
        sqlSession.commit();
    }
}
```