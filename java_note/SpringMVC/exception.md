# Excpetion

## 1. customize exception resolver

1.  Create a `MyExceptionResolver` class and jsp, note you can define your own exceptions.

```java
class MyExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("e", e);
        mv.setViewName("error/error");

        if (e instanceof MyException) {
            mv.setViewName("error/myError");
        }
        return mv;
    }
}
```
```jsp (error/error.jsp)
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
    General Error: ${e}
</body>
</html>
```


2.  **add `<bean class="package.exception.MyExceptionResolver"/>` to your `springMVC.xml` file**.
