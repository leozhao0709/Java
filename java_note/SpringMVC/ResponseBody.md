# ResponseBody annotation

## 0. additional maven dependecy for **String** responseBody

```xml
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-core</artifactId>
    <version>2.9.4</version>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.9.4</version>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-annotations</artifactId>
    <version>2.9.4</version>
</dependency>
```

Note you also need add `<mvc:annotation-driven/>` in your `springMVC.xml` config file.

## 1. return to response body

Note we can use `@ResponseBody` annotation. Return string with `@ResponseBody` will directly print the String to web browser. Return map with `@ResponseBody` will return a json.

```java
@Controller
class ReturnObjectController {

    @RequestMapping(value = "/returnString", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String returnString() {
        return "哈哈哈哈哈";
    }

    @RequestMapping("/returnMap")
    @ResponseBody
    public Map<String, String> returnMap() {
        Map<String, String> map = new HashMap<>();

        map.put("hello", "你好");
        map.put("world", "世界");

        return map;
    }
}
```


## 2. return String

If we directly return a String, then it will try to find the the jsp file. 

We can also pass values using model, then you need to pass Model as params. **But for this case, I prefer return a ModelAndView**.

```java
@Controller
class ReturnStringController {

    @RequestMapping("/welcome")
    public String welcome() {
        // directly jump to welcome.jsp
        return "welcome";
    }

    @RequestMapping("/welcome2")
    public String welcome(String name, Model model) {

        model.addAttribute("username", name);
        return "welcome2";
    }
}
```
