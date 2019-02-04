# rabbitmq

## 0. install

`brew install rabbitmq`

default username and password: `guest/guest`


## 1. dependency and configuration in yml file

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-amqp</artifactId>
</dependency>
```

```yml
spring:
  rabbitmq:
    host: localhost
    port: 5672
    username: guest
    password: guest
    # virtual-host: /
```

## 2. set up use json to searialize your data

```java
@Configuration
class MyRabbitMqConfig {

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
```

Note:

-   It's `org.springframework.amqp.support.converter.Jackson2JsonMessageConverter`;

## 3. `RabbitTemplate` usage

**Please make sure you create your rabbitmq exchange and queue. Then you need to bind them with routing key**

```java
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Test
    public void sendMessageTest() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "This is the first message");
        map.put("data", Arrays.asList("helloWorld", 123, true));

        rabbitTemplate.convertAndSend("exchange.direct", "lzhao.news", map);
    }

    @Test
    public void receiveMessageTest() {
        Object newsMessage = rabbitTemplate.receiveAndConvert("lzhao.news");
        System.out.println(newsMessage.getClass()); // class java.util.HashMap
        System.out.println(newsMessage); // {msg=This is the first message, data=[helloWorld, 123, true]}
    }
}
```
