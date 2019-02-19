# Unit Test

## 1. service unit Test

```java
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void findOne() {
        Optional<Girl> girl = girlService.findOne(14);
        girl.ifPresent(girl1 -> Assert.assertEquals(25, girl1.getAge()));
    }
}
```

## 2. controller test

```java
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GirlControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void girlList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/girls"))
                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().json("[{}]"))
        ;
    }
}
```