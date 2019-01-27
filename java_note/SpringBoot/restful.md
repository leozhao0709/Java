# Restful

## 1. example

```java
@RestController
class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable("id") int id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/emp/update/{id}")
    public Employee updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
        employee.setdId(id);
        return employeeService.updateEmployee(employee);
    }
}
```

Note:

-   Use `@RestController`, `@GetMapping`, `@PostMapping`, `@RequestBody` etc.
-   If you are using `@RestController`, then you don't need to piont `@ResponseBody`.