# Cache

## 1. dependency

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-cache</artifactId>
</dependency>
```

## 2. Enable cache

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

## 3. Cacheable

Using `@Cacheable(cacheNames = {"cacheName"})` for the **method** that you want to cache.

**`@Cacheable` is used before method running.** Because cache need to check if it has the key first.

Some Paramters you can use:

-   `cacheNames`/`value`
-   `key`/`keyGenerator`
-   `cacheManager`/`cacheResolver`
-   `condition`/`unless`
-   `sync`
