# Spring MVC

## 1. add controller

```java
@Controller
class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String employeeList(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    @GetMapping("/emp/add")
    public String toAddEmployeePage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/add";
    }

    @PostMapping("/emp/add")
    public String addEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/edit/{id}")
    public String toEditEmployeePage(@PathVariable("id") int employeeId, Model model) {
        Employee employee = employeeDao.get(employeeId);
        model.addAttribute("employee", employee);

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/edit";
    }

    @PostMapping("/emp/edit/{id}")
    public String editEmployee(Employee employee) {
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int employeeId) {
        employeeDao.delete(employeeId);
        return "redirect:/emps";
    }
}
```

Note:

-   Here we are using `thymeleaf`, so returned `emp/list` will point to `emp/list.html`.
-   Using `Model` to add anything you want to show in the template.
-   You can recieve `object` directly if you are submitting a form.
