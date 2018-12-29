# @DateTimeFormat

## 0. if your java is lower than 1.7

Then you need to add this dependency:

```xml
 <dependency>
  <groupId>joda-time</groupId>
  <artifactId>joda-time</artifactId>
  <version>2.9.9</version>
</dependency>
```

Note: sice 1.8, you don't need to manually add this.

## 1. time converter for Date

```java
@Controller
@RequestMapping("/user")
public class UserController{

    @RequestMapping("/addUser.do")
    public ModelAndView addUser(String name,int age,@DateTimeFormat(pattern = "yyyy-MM-dd") Date birthday) throws Exception{

        ModelAndView mv = new ModelAndView();


        mv.addObject("name", name);
        mv.addObject("age", age);
        mv.addObject("birthday", birthday);
        mv.setViewName("user");
        return mv;
    }
}
```

## 2. time converter for LocalDate

For LocalDate, we cannot directly use it like Date. We need to pass an object instead.

```java
public class User {

    private String name;

    private int age;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    /*
        省略setter和getter
     */
}
```

```java
@RequestMapping("/addUser.do")
public ModelAndView addUser(User user) throws Exception{

    ModelAndView mv = new ModelAndView();

    mv.addObject("name",user.getName());
    mv.addObject("age", user.getAge());
    mv.addObject("birthday", user.getBirthday());
    mv.setViewName("user");
    return mv;
}
```