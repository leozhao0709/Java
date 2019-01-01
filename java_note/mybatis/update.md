# update

## 1. mapper

```xml
<update id="updateStudent">
    update student set name=#{name},age=#{age},score=#{score} where id=#{id}
</update>
```

## 2. java

```java (DAO)
void updateStudent(Student student);
```


