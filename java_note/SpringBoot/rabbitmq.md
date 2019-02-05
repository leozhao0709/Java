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

## 3. `RabbitTemplate` and `AmqpAdmin` usage

**Please make sure you create your rabbitmq exchange and queue. Then you need to bind them with routing key**

```java
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private AmqpAdmin amqpAdmin;

    @Test
    public void createExchangeAndQueueAndBinding() {
        // create exchange
        amqpAdmin.declareExchange(new DirectExchange("test.exchange"));

        // create queue
        amqpAdmin.declareQueue(new Queue("test.queue"));

        // binding queue and exchange
        amqpAdmin.declareBinding(new Binding("test.queue", Binding.DestinationType.QUEUE, "test.exchange", "test.routingKey", null));
    }

    @Test
    public void sendMessageTest() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "This is the first message");
        map.put("data", Arrays.asList("helloWorld", 123, true));

        rabbitTemplate.convertAndSend("exchange.direct", "lzhao.news", map);
    }

    @Test
    public void sendObjectTest() {
        Book book = new Book("西游记", "吴承恩");
        rabbitTemplate.convertAndSend("exchange.direct", "lzhao.news", book);
    }

    @Test
    public void receiveMessageTest() {
        Object newsMessage = rabbitTemplate.receiveAndConvert("lzhao.news");
        System.out.println(newsMessage.getClass()); // class java.util.HashMap
        System.out.println(newsMessage); // {msg=This is the first message, data=[helloWorld, 123, true]}
    }
}
```

Note:

-   For a fanout exchange, you don't need to give the `routingKey` as fanout will broadcast its message.
-   All object(not matter jdk or your self object) can be send as message body.
-   **Your object should have a default empty constructor.**
-   Use `AmqpAdmin` to create exchange, queue and binding.


## 4. rabbitmq in springboot

You need to enable rabbitmq with `@EnableRabbit` first.

```java
@EnableRabbit
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```

Then you can use `@RabbitListener` in your application:

```java
@Service
class BookService {

    @RabbitListener(queues = "lzhao.news")
    public void receiveBook(Book book) {
        System.out.println("receive message" + book);
    }

    @RabbitListener(queues = "lzhao.news")
    public void receiveMessage(Message message) {
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
```

Note:

-   When queue receive any message, `@RabbitListener` will receive the message/object directly.
