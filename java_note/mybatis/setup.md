# Setup

## 1. maven setup

Dependency:

```xml
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.4.6</version>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>6.0.6</version>
</dependency>
<dependency>
    <groupId>log4j</groupId>
    <artifactId>log4j</artifactId>
    <version>1.2.17</version>
</dependency>
```

Setup pom.xml:

Add this xml under `<build>` tag.

```xml
<resources>
    <resource>
        <directory>src/main/java</directory>
        <includes>
            <include>**/*.xml</include>
        </includes>
    </resource>
</resources>
```

## 2. add log4j.properties under resources folder

```propertis
log4j.logger.java=debug,console

#控制台附加器
log4j.appender.console = org.apache.log4j.ConsoleAppender
log4j.appender.console.Target = System.out
log4j.appender.console.layout = org.apache.log4j.PatternLayout
log4j.appender.console.layout.ConversionPattern= [%-5p][%d{yyyy-MM-dd HH:mm:ss}]%m%n
```

## 3. add db.properties

```properties
jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/mybatis?useSSL=false&serverTimezone=America/Los_Angeles
```

## 5. create java file

```java
public class MyBatisUtil {

    private static volatile SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession() {
        try {
            if (sqlSessionFactory == null) {
                InputStream input = Resources.getResourceAsStream("mybatis.xml");
                synchronized (MyBatisUtil.class) {
                    if (sqlSessionFactory == null){
                        sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sqlSessionFactory.openSession();
    }
}
```

```java
public class Student {

    private int id;
    private String name;
    private int age;
    private double score;

    //省略getter和setter
}
```

```java
public interface StudentDao {
    void insertStudent(Student student);
}
```

```java
class StudentDaoImpl implements StudentDao {

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
}
```

## 4. create mapper file in DAO folder

```xml (studentMapper.xml)
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="">
    <insert id="insertStudent">
        INSERT INTO student(name,age,score) VALUES (#{name},#{age},#{score})
    </insert>
</mapper>
```

## 5. add mybatis.xml in resource folder

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

    <!--注册配置文件-->
    <properties resource="db.properties"/>
    <typeAliases>
        <package name="bean"/>
    </typeAliases>

    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="${jdbc.driver}"/>
                <property name="url" value="${jdbc.url}"/>
                <property name="username" value="${env: DB_USER}"/>
                <property name="password" value="${env: DB_PASS}"/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <!--注册映射文件-->
        <mapper resource="dao/StudentMapper.xml"/>
    </mappers>
</configuration>
```