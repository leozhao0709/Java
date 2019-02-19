# JPA in spring boot

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
```

Note:

-   You need to create db by yourself.
-   for `ddl-auto`, there are different value: `update`, `create`, `create-drop` etc. We are always using `update`. `create` will drop old table if you rerun your app. `create-drop` will delete table before your app exit.


## 2. create entity

```java
@Table(name = "girl")
@Entity
public class Girl {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "字段必传")
    private String cupSize;

    @Min(value = 18, message = "未成年禁止入内")
    private int age;

    @NotNull(message = "金额必传")
    private Double money;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "insertDate")
    private LocalDate addDate;

    @Transient // `transient` property won't map to table
    private String info;

    public Girl() {
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", cupSize='" + cupSize + '\'' +
                ", age=" + age +
                ", money=" + money +
                ", addDate=" + addDate
                ;
    }

// ignore setter and getter
}
```

Note:

-   **Must have an empty constructor.**

## 3. create repository

```java
public interface GirlRepository extends JpaRepository<Girl, Integer> {
    List<Girl> findGirlsByAge(int age);
}
```

## 4. use repository

```java
@GetMapping("/girls")
public List<Girl> girlList() {
    return girlRepository.findAll();
}

@PostMapping("/girl/add")
public Girl addGirl(@Valid @RequestBody Girl girl, BindingResult bindingResult) {
    System.out.println("girl..." + girl);
    if (bindingResult.hasErrors()) {
        System.out.println(bindingResult.getFieldError().getDefaultMessage());
        return null;
    }

    return girlRepository.save(girl);
}
```
