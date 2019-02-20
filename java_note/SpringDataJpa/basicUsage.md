# Basic usage

## 1. create entity

```java
@Table(name = "girl")
@Entity
public class Girl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int password;

    @JsonIgnore
    @Transient // `transient` property won't map to table
    private String info;

    public Girl() {
    }

// ignore setter and getter
}
```

Note:

-   **Must have an empty constructor.**
-   `@Transient` property won't map to table
-   You can use `@JsonIgnore` to ignore a field in json. Then it will ignore json when receive or send this value.
-   You can also use `@JsonProperty(access = someProperty)` to give the right access for your json value.

## 2. create repository

```java
public interface GirlRepository extends JpaRepository<Girl, Integer> {
    List<Girl> findGirlsByAge(int age);
}
```

## 3. use repository in your service/controller

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
