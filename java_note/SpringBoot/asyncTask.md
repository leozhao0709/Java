# async Task in springboot

## 1. async task

we have `@EnableAsync` and `@Async` annotation. Rember to `@EnableAsync`.

```java
@EnableAsync
@SpringBootApplication
public class TaskApplication {
    public static void main(String[] args) {
        SpringApplication.run(TaskApplication.class, args);
    }
}
```

```java
@Service
public class TaskService {
    @Async
    public void asyncFunc() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("asyncFunc...");
    }
}
```

```java
@RestController
class TaskController {
    @Autowired
    private TaskService taskService;

    @RequestMapping("/async")
    public String asyncFunc() throws InterruptedException {
        taskService.asyncFunc();
        return "success";
    }
}
```
