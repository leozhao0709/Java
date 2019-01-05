# Many to One

## 1. mapper xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="dao.PlayerDao">

    <resultMap id="playerMap" type="player">
        <id column="pid" property="id" />
        <result column="pname" property="name" />

        <association property="team" javaType="Team">
            <id column="tid" property="id" />
            <result column="tname" property="name" />
        </association>
    </resultMap>
    
    <select id="selectPlayerById" resultMap="playerMap">
        select p.id pid, p.name pname, t.id tid, t.name tname
        from t_player p
                 join t_team t on p.tid = t.id and p.id = #{id}
    </select>

    <select id="selectAllPlayers" resultMap="playerMap">
        select p.id pid, p.name pname, t.id tid, t.name tname
        from t_player p
                 join t_team t on p.tid = t.id
    </select>
</mapper>
```

Note:

-  We need to define `<resultMap>` and use `<association>`


## 2. 多对一自关联

```xml
<resultMap id="leaderMap" type="Employee">
    <id column="id" property="id"/>
    <result column="name" property="name"/>
    <association property="leader" javaType="Employee" select="selectLeaderByPid" column="mgr"/>
</resultMap>

<select id="selectLeaderByPid" resultMap="leaderMap">
    SELECT id,name,job,mgr
    FROM t_employee
    WHERE id=#{id}
</select>
```

-   There's a recursion for `<association property="leader" javaType="Employee" select="selectLeaderByPid" column="mgr"/>`. This will recursion to run the sql and return the result to collection.
-   This will run several sql, so it's better to avoid this kind of query.
