# Redis

## 0. dependency

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
```

## 1. config in your yml/properties file and add configure java file for spring boot cache

```yml
spring:
  redis:
    host: localhost
```

```java
@Configuration
class MyRedisConfig {

    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory connectionFactory) {

        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new GenericJackson2JsonRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return template;
    }

    @Bean
    public RedisCacheManager redisCacheManager(LettuceConnectionFactory lettuceConnectionFactory) {
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .disableCachingNullValues()
                .entryTtl(Duration.ofHours(1))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.json()));
        redisCacheConfiguration.usePrefix();

        return RedisCacheManager.RedisCacheManagerBuilder.fromConnectionFactory(lettuceConnectionFactory)
                .cacheDefaults(redisCacheConfiguration).build();
    }
}
```

Note:

-   If you want to use redis as cache. Then you need add the config file. Then check the `simpleCache.md`. Config the same way as introduced in that mark down file. Springboot will automatically use redis cache as long as you import the dependency.

-   This config java file is used to store json in your redis cache.


## 2. StringRedisTemplate for general usage

`StringRedisTemplate` is only used for **string value**.

```java
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void stringRedisTemplateTest() {
        stringRedisTemplate.opsForValue().append("msg", "hello");
        String msg = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(msg);

        stringRedisTemplate.opsForList().leftPush("mylist", "1");
        stringRedisTemplate.opsForList().leftPush("mylist", "2");
        stringRedisTemplate.opsForList().leftPush("mylist", "3");
    }
}
```

## 3. RedisTemplate for general usage

`RedisTemplate` is used for **object**. But please make sure your object implements `Serializable` if you want to use the default jdk object Serializable

**If you want to use `json` to store your object, then just add above config and you don't need to implements `Serializable`:**


```java
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void redisTemplateTest() {
        Employee employee = employeeMapper.getEmployeeById(2);
        redisTemplate.opsForValue().set("emp-01", employee);

        Employee employee1 = (Employee) redisTemplate.opsForValue().get("emp-01");
        System.out.println(employee1);
    }
}
```
