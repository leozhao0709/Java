# Request Params

## 0. example

```java
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
```

Note:

-   You can also use `@RequestParam(name = "age", defaultValue = "18")` when you params name is different with you method params name. You can define `name`, `defaultValue` or `required` properties.
-   For `@RequestParam`, you can't use `name` and `value` at the same time as they are the same effect.

## 1. request mapping

-   `@RequestMapping(value="/test.do", params={"name", "age"})` 要求请求中必须携带请求参数 name 与 age
-   `@RequestMapping(value="/test.do", params={"!name", "age"})` 要求请求中必须携带请求参数 age，但必须不能携带参数 name
-   `@RequestMapping(value="/test.do", params={"name=jack" ,"age=23"})` 要求请求中必须携带请求参数 name，且其值必须为jack；必须携带参数 age，其值必须为 23
-   `@RequestMapping(value="/test.do", params="name!=jack")` 要求请求中必须携带请求参数name，且其值必须不能为jack