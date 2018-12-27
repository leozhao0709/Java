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

-   If you don't give method value, then it will support both POST/GET/PUT/DELETE etc
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

## 2. params

-   `@RequestMapping(value="/test.do", params={"name", "age"})` 要求请求中必须携带请求参数 name 与 age
-   `@RequestMapping(value="/test.do", params={"!name", "age"})` 要求请求中必须携带请求参数 age，但必须不能携带参数 name
-   `@RequestMapping(value="/test.do", params={"name=jack" ,"age=23"})` 要求请求中必须携带请求参数 name，且其值必须为jack；必须携带参数 age，其值必须为 23
-   `@RequestMapping(value="/test.do", params="name!=jack")` 要求请求中必须携带请求参数name，且其值必须不能为jack