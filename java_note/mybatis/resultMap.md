# ResultMap

## 1. usage

`resultMap`实际上是将数据库表中的字段与实体类中的属性建立一个映射关系，这样子，即使两者名字不一致，mybatis也会根据resultMap中的映射关系正常执行

```xml
<resultMap id="studentMapper" type="student">
    <id column="id" property="id"/>
    <result column="password" property="pwd"/>
</resultMap>

<select id="selectStudentById" resultMap="studentMapper">
    SELECT id,name,age,score,password FROM t_student where id=#{id}
</select>
```

上面示例中通过resultMap来创建了映射关系，id设置为studentMapper，然后在select查询语句中指定属性resultMap的值为studentMapper，这样子就不用在SQL语句中使用别名了。一般在较为复杂的SQL语句中会使用resultMap。

在resultMap中添加了一个id的属性来指定主键，这样子可以提高mybatis的查询性能。resultMap中的type属性用来指定要映射的实体类。