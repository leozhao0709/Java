# Spring MVC

## 1. add controller

```java
@Controller
class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/emps")
    public String employeeList(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        return "emp/list";
    }
}
```

Note:

-   Here we are using `thymeleaf`, so returned `emp/list` will point to `emp/list.html`.
-   Using `Model` to add anything you want to show in the template.
