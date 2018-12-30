# Forward and Redirect

## 1. forward

The default `ModelAndView` return view is actually a view forward.

If you want to forward to another controller, then use something like this `mv.setViewName("forward:other.do");`

```java
@RequestMapping("/forwardMAV.do")
public ModelAndView forwardMAV()throws Exception{

    ModelAndView mv = new ModelAndView();

    //手动显式指定使用转发，此时springmvc.xml配置文件中的视图解析器将会失效
    mv.setViewName("forward:other.do");
    return mv;
}
```

## 2. redirect

Use this for redirect `mv.setViewName("redirect:/jsp/result.jsp");` you need to sepecify the jsp directory as the 视图解析器 no effect at this time.

We can also redirect to another controller `mv.setViewName("redirect:other.do");`. Note when redirect to another controller, then the value you set in first conroller will pass as url parameters.

```java
@RequestMapping("/redirectMAV.do")
public ModelAndView redirectMAV(String name){

    ModelAndView mv = new ModelAndView();

    mv.addObject("name", name);

    //使用重定向，此时springmvc.xml配置文件中的视图解析器将会失效
    mv.setViewName("redirect:/jsp/result.jsp"); // will redirect to /jsp/result.jsp?name=something
    return mv;
}
```
```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${param.name}
</body>
</html>
```

```java
 @RequestMapping("/redirectMAV.do")
public ModelAndView redirectMAV(School school,String name)throws Exception{

    ModelAndView mv = new ModelAndView();

    mv.addObject("name", name);
    mv.addObject("schoolName", school.getSchoolName());
    mv.addObject("address", school.getAddress());

    System.out.println(school.getAddress());
    //使用重定向，此时springmvc.xml配置文件中的视图解析器将会失效
    mv.setViewName("redirect:other.do"); // redirect to another controller
    return mv;
}
```

Note:

-   **Redirect will add the original added object to url parameter.**
-   You can only pass the primitive paramters.
