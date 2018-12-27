# Controller

## 1. example

```java
@Controller()
public class HelloController {
    @RequestMapping(value = {"/hello.do", "welcome.do"}, method = RequestMethod.POST)
    public ModelAndView reqPost(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("hello", "hello springMVC");
        mv.setViewName("hello");

        return mv;
    }

    @RequestMapping(value = {"/hello.do", "welcome.do"}, method = RequestMethod.GET)
    public ModelAndView reqGet(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("hello", "hello springMVC");
        mv.setViewName("hello");

        return mv;
    }

    @RequestMapping("/params02")
    public ModelAndView getParams2(@RequestParam(name = "username") String name,
                                   @RequestParam(name = "age", defaultValue = "18") int newAge,
                                   @RequestParam(name = "password", required = false) String password) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("username", name);
        mv.addObject("age", newAge);
        mv.setViewName("result");

        return mv;
    }
}
```

Note:
-   If you don't give **method** value, then it will support both POST/GET/PUT/DELETE etc
-   The method params can be empty or the following 5 types:
    -   `HttpServletRequest`
    -   `HttpServletResponse`
    -   `HttpSession`
    -   `请求携带的参数`
    -   `用于承载数据的Model`
-   You can directly give the parameter key as the method params, like 
    ```java
    @RequestMapping("/params01")
    public ModelAndView getParams(String username, int age) {}
    ```
-   You can also use `@RequestParam(name = "age", defaultValue = "18")` when you params name is different with you method params name. You can define `name`, `defaultValue` or `required` properties.
-   For `@RequestParam`, you can't use `name` and `value` at the same time as they are the same effect.


## 2. request mapping

-   `@RequestMapping(value="/test.do", params={"name", "age"})` 要求请求中必须携带请求参数 name 与 age
-   `@RequestMapping(value="/test.do", params={"!name", "age"})` 要求请求中必须携带请求参数 age，但必须不能携带参数 name
-   `@RequestMapping(value="/test.do", params={"name=jack" ,"age=23"})` 要求请求中必须携带请求参数 name，且其值必须为jack；必须携带参数 age，其值必须为 23
-   `@RequestMapping(value="/test.do", params="name!=jack")` 要求请求中必须携带请求参数name，且其值必须不能为jack


## 3. path variable

```java
@Controller
class PathVariableController {

    @RequestMapping("/{name}/{age}/register")
    public ModelAndView pathVariableTest(@PathVariable("name") String userName, @PathVariable int age) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("username", userName);
        mv.addObject("age", age);
        mv.setViewName("result");
        return mv;
    }
}
```

Note:
-   Use `@PathVariable` to define path variable. If the name is same with your method param name, then you don't need to point the name.


## 4. bind object

```java (bean)
public class School {

    private String name;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

public class Student {

    private String name;
    private int age;
    private School school;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
```
```java (controller)
@Controller
class StudentController {

    @RequestMapping("/studentInfo")
    public ModelAndView getStudentInfo(Student student) {
        ModelAndView mv = new ModelAndView();

        mv.addObject(student);
        mv.setViewName("studentInfo");
        return mv;
    }
}
```
```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/studentInfo.do" method="post">
        <div>
            <label for="name">name: </label>
            <input type="text" id="name" name="name">
        </div>

        <div>
            <label for="password">password: </label>
            <input type="text" id="password" name="password">
        </div>

        <div>
            <label for="age">age: </label>
            <input type="text" id="age" name="age">
        </div>

        <div>
            <label for="schoolName">schoolName:</label>
            <input type="text" id="schoolName" name="school.name">
        </div>

        <div>
            <label for="schoolAddress">schoolAddress:</label>
            <input type="text" id="schoolAddress" name="school.address">
        </div>

        <button type="submit">Submit</button>
    </form>
</body>
</html>
```

Note:

-   We can bind an object and pass it to controller. In jsp, note the **input name property**, we should bind it with the example style, it should follow the bean defined. (**note how to define the nested object**)
-   You can have more input than the original bean object. And you can define additional params if it's not contains to your object.
