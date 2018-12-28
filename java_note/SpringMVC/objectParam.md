# Object Parameters

## 1. example

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