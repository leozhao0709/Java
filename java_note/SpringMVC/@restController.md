# RestController

## 1. dependency

```xml
<dependency>
    <groupId>com.fasterxml.jackson.datatype</groupId>
    <artifactId>jackson-datatype-jsr310</artifactId>
    <version>2.9.4</version>
</dependency>
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>fastjson</artifactId>
    <version>1.2.54</version>
</dependency>
```

## 2. restController

```java
@RestController
class UserRestController {

    @GetMapping("/users")
    public String findAll() {
        Map<String, User> allUsers = DataUtil.findAll();
        return JSON.toJSONString(allUsers);
    }

    @GetMapping("/users/{id}")
    @ResponseBody
    public String findById(@PathVariable String id) throws Exception {
        User user = DataUtil.findById(id);


        return JSON.toJSONString(user);
    }

    @PostMapping("/users")
    public String create(@RequestBody User user) {
        try {
            DataUtil.create(user);
            System.out.println(user.getName());
        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString("fail");
        }

        return JSON.toJSONString("success");
    }

    @PutMapping("/users/{id}")
    public String update(@PathVariable String id, @RequestBody User user) {
        try {
            DataUtil.update(id, user);
        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString("fail");
        }
        return JSON.toJSONString("success");
    }

    @DeleteMapping("/users/{id}")
    public String delete(@PathVariable String id) {

        try {
            DataUtil.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString("fail");
        }
        return JSON.toJSONString("success");
    }
}
```

Note:
-   `@RestController` 我们通常使用ajax+json实现restful架构风格，请求和响应的数据都使用json格式，那就需要在controller的每个方法上加上@ResponseBody来标注该方法返回值放到响应体中，这样就不太方便了，此时就可以使用@RestController注解来代替之前的@Controller注解，这样就标注了当前controller中的每个方法的返回值要放到响应体中，就不用在每个方法上写@ResponseBody注解了。
-   `@RequestBody` restful风格的请求数据是使用json格式，此时我们在要接收请求参数的javabean前面添加@RequestBody就可以将请求的数据赋值到相应的bean属性中。
-   `@GetMapping` 该注解用来替代RequestMapping，特点是@GetMapping只处理get方式的请求。
-   `@PostMapping` 该注解用来替代RequestMapping，特点是@PostMapping只处理post方式的请求。
-   `@PutMapping` 该注解用来替代RequestMapping，特点是@PutMapping只处理put方式的请求。
-   `@DeleteMapping` 该注解用来替代RequestMapping，特点是@DeleteMapping只处理delete方式的请求。