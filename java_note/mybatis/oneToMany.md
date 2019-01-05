# One to Many

## 1. xml mapper

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="dao.TeamDao">

    <resultMap id="teamMap" type="Team">
        <id column="tid" property="id" />
        <result column="tname" property="name" />

        <collection property="playerList" ofType="Player">
            <id column="pid" property="id" />
            <result column="pname" property="name" />
        </collection>
    </resultMap>

    <select id="selectTeamById" resultMap="teamMap">
        select t.id tid, t.name tname, tp.id pid, tp.name pname
        from t_team as t
                 join t_player as tp on t.id = tp.tid and t.id = #{id}
    </select>

</mapper>
```

Note:

-   We need to define `<resultMap>` and use `<collection>`
-   **For your `<collection>` corresponding bean, you must provide an empty constructor.**

## 2. 一对多自关联

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.monkey1024.dao.EmployeeDao">

    <!--形成递归查询-->
    <resultMap id="childrenMap" type="Employee">
        <id column="id" property="id"/>
        <result column="name" property="name"/>
        <collection property="children" ofType="Employee" select="selectChildrenByPid" column="id"/>
    </resultMap>

    <select id="selectChildrenByPid" resultMap="childrenMap">
        SELECT id, name ,job
        FROM t_employee
        WHERE mgr=#{pid}
    </select>
</mapper>
```

Note:

-   There's a recursion for `<collection property="children" ofType="Employee" select="selectChildrenByPid" column="id"/>`. This will recursion to run the sql and return the result to collection.
-   This will run several sql, so it's better to avoid this kind of query.
