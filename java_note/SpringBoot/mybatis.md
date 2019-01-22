# Mybatis with spring boot

## 1. dependency

```xml
 <dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>2.0.0</version>
</dependency>

<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
```

## 2. setup `application.yml`

```yml
spring:
  datasource:
    username: ${DB_USER}
    password: ${DB_PASS}
    url: jdbc:mysql://localhost:3306/mybatis?useSSL=false&serverTimezone=America/Los_Angeles
    driver-class-name: com.mysql.cj.jdbc.Driver
```

## 3. create mapper and java bean

```java
public class Student {

    private int id;
    private String name;
    private int age;
    private Double score;

    public Student(String name, int age, Double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    // 省略getter和setter
}
```

```java
@Component
@Mapper
public interface StudentMapper {

    @Select("select * from student where id=#{id}")
    Student getStudentById(int id);

    @Select("select * from student")
    List<Student> getAllStudent();

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into student(name, age, score) values(#{name}, #{age}, #{score})")
    void insertStudent(Student student);

    @Delete("delete from student where id=#{id}")
    void deleteStudent(int id);

    @Update("update student set name=#{name},age=#{age},score=#{score} where id=#{id}")
    void updateStudent(Student student);
}
```

## 4. use the mapper

```java
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentMapperTest {

    @Autowired
    private StudentMapper studentMapper;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getStudentById() {
        Student student = studentMapper.getStudentById(2);
        System.out.println(student);
    }

    @Test
    public void getAllStudent() {
        List<Student> students = studentMapper.getAllStudent();
        System.out.println(students);
    }

    @Test
    public void insertStudent() {
        Student s = new Student("lzhao", 27, 99.5);
        System.out.println(s);
        studentMapper.insertStudent(s);
        System.out.println(s);
    }

    @Test
    public void deleteStudent() {
        studentMapper.deleteStudent(15);
    }

    @Test
    public void updateStudent() {
        Student s = new Student("lzhao", 27, 96.5);
        s.setId(13);
        System.out.println(s);
        studentMapper.updateStudent(s);
    }
}
```
