# Spring data JPA setup

## 0. dependency

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
```

## 1. config

```yml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/dbgirl?useSSL=false&serverTimezone=America/Los_Angeles
    driver-class-name: com.mysql.cj.jdbc.Driver
    username: ${DB_USER}
    password: ${DB_PASS}
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.MySQL5InnoDBDialect
```

Note:

-   You need to create db by yourself.
-   for `ddl-auto`, there are different value: `update`, `create`, `create-drop` etc. We are always using `update`. `create` will drop old table if you rerun your app. `create-drop` will delete table before your app exit.
-   **Default hibernate mysql engine is not InnoDB.** So you have to add the config.