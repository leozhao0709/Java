# Many To One

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

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

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

```java
@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerAndOrderTest {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void oneToManyInsert() {
        Customer customer = new Customer("bb", "bb@163.com", 18, LocalDateTime.now(), LocalDate.now());

        Order order1 = new Order("O-BB-1", customer);
        Order order2 = new Order("O-BB-2", customer);

        List<Order> orderList = Arrays.asList(order1, order2);
        customer.setOrders(orderList);

        customerRepository.save(customer);
        orderRepository.save(order1);
        orderRepository.save(order2);
    }

    @Test
    @Transactional
    public void oneToManySelect() {
        Optional<Order> order1 = orderRepository.findById(5);
        order1.ifPresent(order -> {
            System.out.println(order);
            Customer customer = order.getCustomer();
            System.out.println(customer);
        });
    }
}
```

Note:

-   Must have an empty constructor.
-   `@ManyToOne(fetch = FetchType.LAZY)` can do the lazy fetch.
-   Using the many side to manage relation which means use `JoinColumn`. For the one side, use `mappedBy`. `MappedBy` the property name.
-   Note bio-direction may cause `circular dependency`. So when you refer an object, make sure no `circular dependency`.
-   **When you see the sqlSession endup error**, then use `@Transactional` to your method.