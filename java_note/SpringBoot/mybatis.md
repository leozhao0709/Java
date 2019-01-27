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

mybatis:
  configuration:
    map-underscore-to-camel-case: true
```

## 3. create mapper and java bean

**Your java bean must have an empty constructor.**

```java
public class Student {

    private int id;
    @Length(min = 2, max = 4, message = "name is between 1 to 3")
    private String name;
    @Min(value = 18, message = "min value is 18")
    @Max(value = 30, message = "max value is 30")
    private int age;
    @Min(value = 60, message = "must have a score")
    private Double score;

    public Student() {
    }

    public Student(String name, int age, Double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    // 省略getter和setter
}
```

```java
@Repository
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

## 4. use mapper in controller (with validation)

```java
@RestController
class HelloController {

    @Autowired
    private StudentMapper studentMapper;

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable("id") int id) {
        return studentMapper.getStudentById(id);
    }

    @PostMapping("/student/add")
    public Result addStudent(@Valid @RequestBody Student s, BindingResult bindingResult) {
        Result result = new Result();

        if (bindingResult.hasErrors()) {
            result.setCode(1);
            result.setMsg(bindingResult.getFieldError().getDefaultMessage());
            return result;
        }

        studentMapper.insertStudent(s);
        result.setCode(0);
        result.setMsg("success");
        result.setData(s);

        return result;
    }
}
```

## 5. unit test

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

        // validate student first
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Set<ConstraintViolation<Student>> violations = factory.getValidator().validate(s);
        for (ConstraintViolation<Student> violation : violations) {
            throw new RuntimeException(violation.getMessage());
        }

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
