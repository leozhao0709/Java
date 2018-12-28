# Path Variable

## 1. path variable

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