# Example

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
