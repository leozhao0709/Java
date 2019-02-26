# Many To Many

## 1. create entity

```java
@Entity
@Table(name = "jpa_items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @JoinTable(
            name = "item_category",
            joinColumns = {@JoinColumn(name = "ITEM_ID", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id", referencedColumnName = "id")}
    )
    @ManyToMany
    private Set<Category> categories = new HashSet<>();

    public Item() {
    }
}
```

```java
@Entity
@Table(name = "jpa_categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToMany(mappedBy = "categories")
    private Set<Item> items = new HashSet<>();

    public Category() {
    }
}
```

```java
@SpringBootTest
@RunWith(SpringRunner.class)
public class ItemAndCategoryTest {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void manyToManyInsert() {
        Category category1 = new Category("C-AA-1");
        Category category2 = new Category("C-AA-2");

        Item item1 = new Item("I-AA-1");
        Item item2 = new Item("I-AA-2");

        category1.getItems().add(item1);
        category1.getItems().add(item2);
        category2.getItems().add(item1);
        category2.getItems().add(item2);

        item1.getCategories().add(category1);
        item1.getCategories().add(category2);
        item2.getCategories().add(category1);
        item2.getCategories().add(category2);

        categoryRepository.save(category1);
        categoryRepository.save(category2);
        itemRepository.save(item1);
        itemRepository.save(item2);
    }
}
```

Note:

-   Using `manyToMany` and `@JoinTable` to do many to many mapping. For `@JoinTable`, `name` is internal table name. `joinColumns` is current object mapped column in internal table. `inverseJoinColumns` is the other table mapped column in internal table.
