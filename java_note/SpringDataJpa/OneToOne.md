# One To One

## 1. create entity

```java
@Entity
@Table(name = "jpa_manager")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", unique = true)
    private Department department;

    public Manager() {
    }
}
```

```java
@Entity
@Table(name = "jpa_department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToOne(mappedBy = "department")
    private Manager manager;

    public Department() {
    }
}
```

```java
@SpringBootTest
@RunWith(SpringRunner.class)
public class DepartmentAndManagerTest {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private ManagerRepository managerRepository;

    @Test
    public void insert() {
        Department department = new Department("D-BB");
        departmentRepository.save(department);

        Manager manager = new Manager("M-BB", department);
        department.setManager(manager);
        managerRepository.save(manager);
    }
}
```

Note:

-   Must have an empty constructor.
-   `@ManyToOne(fetch = FetchType.LAZY)` can do the lazy fetch
-   Using the many side to manage relation which means use `JoinColumn`. For the one side, use `mappedBy`.
-   **When you see the sqlSession endup error**, then use `@Transactional` to your method.