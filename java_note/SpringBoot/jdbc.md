# JDBC

## 1. dependency

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
```

## 2. set up `application.yml`

```yml
spring:
  profiles:
    active: dev
  datasource:
    username: ${DB_USER}
    password: ${DB_PASS}
    url: localhost:3306/jdbcLearn
    driver-class-name: com.mysql.cj.jdbc.Driver
```

## 3. using java

```java
@Autowired
private JdbcTemplate jdbcTemplate;

@RequestMapping("/query")
@ResponseBody
public Map<String, Object> query() {
    List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from category where cid=?", "c002");
    return list.get(0);
}
```

Note:

-   We can autowired `JdbcTemplate` which is already defined in spring boot itself.
-   Default datasource is `org.apache.tomcat.jdbc.pool.DataSource`.

## 4. run sql script

You can run some sql script during springboot start. Just create a file with name `schema-*.sql` or `data-*.sql`

```properties
schema-*.sql、data-*.sql
默认规则：schema.sql，schema-all.sql；
可以使用   
	schema:
      - classpath:department.sql
      指定位置
```