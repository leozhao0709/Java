# Dynamic Sql

## 0. special character

原符号	 | Column B
---------|----------
 `<`     | `&lt;`
 `<=`    | `&lt;=`
 `>`     | `&gt;`
 `>=`    | `&gt;=`
 `&`     | `&amp;`
 `"`     | `&quot;`
 `'`     | `&apos;`

 Note:

 -  If you don't want to use these special characters, we can also use CDATA, like `<![CDATA[ < ]]>`


## 1. <if> and <select>

```xml
<select id="findByNameAndAge" resultType="student">
    select id, name, age, score from student
    <where>
        <if test="name != ''">
            name like '%' #{name} '%'
        </if>
        <if test="age>0">
            and age &lt;= #{age}
        </if>
    </where>
</select>
```

Note:

-   `<select>` is used to avoid first `and` problem for joining the sql. If we don't use the `<select>` then if we are joining the sql, we need to use `1=1`, see the example:

    ```xml
    <select id="findByNameAndAge" resultType="student">
        select id, name, age, score from student
        where 1=1
            <if test="name != ''">
                and name like '%' #{name} '%'
            </if>
            <if test="age>0">
                and age &lt;= #{age}
            </if>
    </select>
    ```
-   Note in mybatis sql, there's some special character as it's xml. Please check the special charcter part.

## 2. foreach

`foreach` can be used for array and list. Please take care of the `where` place in example. **If we pass null, then we should not break the sql, it should return select all result.**

```xml (array example)
<select id="selectForeachArray" resultType="student">
    select id, name, age, score from student
    <if test="array != null and array.length > 0">
        where id in
        <foreach collection="array" open="(" close=")" item="id" separator="," >
            #{id}
        </foreach>
    </if>
</select>
```

```xml (list example)
<select id="selectForeachList" resultType="student">
    select id, name, age, score from student
    <if test="list != null and list.size() > 0">
        where id in
        <foreach collection="list" open="(" close=")" item="student" separator=",">
            #{student.id}
        </foreach>
    </if>
</select>
```