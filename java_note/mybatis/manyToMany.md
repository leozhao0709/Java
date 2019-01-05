# many to many

## 1. mapper xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.monkey1024.dao.CourseDao">

    <resultMap id="courseMapper" type="Course">

        <id property="id" column="cid"/>
        <result property="name" column="cname"/>
        <collection property="students" ofType="Student">
            <id property="id" column="sid"/>
            <result property="name" column="sname"/>
        </collection>
    </resultMap>


    <select id="selectCourseStudent" resultMap="courseMapper">
        SELECT
            c.id cid, c.name cname, s.id sid, s.name sname
        FROM
            t_course c,
            t_student s,
            t_student_course sc
        WHERE
            c.id = #{id}
            AND s.id = sc.sid
            AND c.id = sc.cid;
    </select>
</mapper>
```

Note:

-   Many to many is actually 3 tables. The mapper is almost same with one to Many.
