# Cache

## 0. dependency

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-cache</artifactId>
</dependency>
```

## 1. Enable cache

Add `@EnableCaching` for your spring boot application. **The default cache is a `ConcurrentMap`.**

```java
@SpringBootApplication
@EnableCaching
public class CacheApplication {
    public static void main(String[] args) {
        SpringApplication.run(CacheApplication.class, args);
    }
}
```

## 2. example

```java
@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Cacheable(cacheNames = {"emps"})
    public Employee getEmployeeById(int id) {
        return employeeMapper.getEmployeeById(id);
    }

    @CachePut(cacheNames = {"emps"}, key = "#result.id")
    public Employee updateEmployee(Employee employee) {
        employeeMapper.updateEmployee(employee);
        return employee;
    }

    @CacheEvict(cacheNames = {"emps"}, key = "#id", beforeInvocation = true)
    public void deleteEmp(int id) {
        employeeMapper.deleteEmployeeById(id);
    }

    @Caching(
        cacheable = {
            @Cacheable(cacheNames = {"emps"}, key = "#lastName")
        },
        put = {
            @CachePut(cacheNames = {"emps"}, key = "#result.id"),
            @CachePut(cacheNames = {"emps"}, key = "#result.email")
        }
    )
    public Employee getEmployeeByLastName(String lastName) {
        return employeeMapper.getEmployeeByLastName(lastName);
    }
}
```


## 3. Cacheable

Using `@Cacheable(cacheNames = {"cacheName"})` for the **method** that you want to cache. **This is used to cache the method return object.**

**`@Cacheable` is used before method running.** Because cache need to check if it has the key first.

Some Paramters you can use:

-   `cacheNames`/`value`
-   `key`/`keyGenerator`
-   `cacheManager`/`cacheResolver`
-   `condition`/`unless`
-   `sync`


## 4. Cacheput

Using `@CachePut(cacheNames = {"emps"}, key = "#result.id")` to an update method. 

**`@Cacheput` is used after method running.** This will update the cache value.

Also if you mark `@Cacheput`, it means the method **must** be running even if you also have `@Cacheable` in the same method.

parameters:

-   `cacheNames`/`value`
-   `key`/`keyGenerator`
-   `cacheManager`/`cacheResolver`
-   `condition`/`unless`
-   `sync`


## 5. CacheEvict

Using `@CacheEvict(cacheNames = {"emps"}, key = "#id")` to clear cache with key `#id`.

You can set clear cache before or after. There's a parameter `beforeInvocation`.

parameters:

-   `cacheNames`/`value`
-   `key`/`keyGenerator`
-   `cacheManager`/`cacheResolver`
-   `condition`
-   `allEntries`
-   `beforeInvocation`


## 6. Caching

`Caching` is used if you want to define a complex cache strategy. If you want to define some `Cacheable`, `Cacheput` and `CacheEvict` together, then use it.

```java
@Caching(
    cacheable = {
        @Cacheable(cacheNames = {"emps"}, key = "#lastName")
    },
    put = {
        @CachePut(cacheNames = {"emps"}, key = "#result.id"),
        @CachePut(cacheNames = {"emps"}, key = "#result.email")
    }
)
public Employee getEmployeeByLastName(String lastName) {
    return employeeMapper.getEmployeeByLastName(lastName);
}
```

## 7. CacheConfig

Annotated this for a **class name**. Note this is not used in a `method name`.

You can define some shared value here. Then you don't need to piont the same thing you already defined for you method cahce.


## 8. Cache Spel metadata

![cacheSpel](./images/cacheSpel.png)


## 9. customize the keyGenerator

```java
@Configuration
class MyCacheConfig {

    @Bean("myKeyGenerator")
    public KeyGenerator keyGenerator() {
        return (target, method, params) -> method.getName() + "[" + Arrays.asList(params).toString() + "]";
    }
}
```

Note:

-   `KeyGenerator` is the `org.springframework.cache.interceptor.KeyGenerator;`