# Many To One (Don't use OneToMany)

## 1. create entity

```java
@Entity
@Table(name = "JPA_CUSTOMERS")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "LAST_NAME", length = 50, nullable = false)
    private String lastName;
    private String email;
    private int age;

    private LocalDateTime createTime;
    private LocalDate birth;

    public Customer() {
    }
}
```

```java
@Table(name = "JPA_ORDERS")
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String orderName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;


    public Order() {
    }
}
```

Note:

-   Must have an empty constructor.
-   `@ManyToOne(fetch = FetchType.LAZY)` can do the lazy fetch
-   Just use this `ManyToOne`. Don't use `OneToMany` as OneToMany will use more sql.