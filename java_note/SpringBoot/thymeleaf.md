# Thymeleaf

## 0. disable cache in dev env

```yml
spring:
  thymeleaf:
    cache: false
```

## 1. setup

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

## 2. [doc](https://www.thymeleaf.org/documentation.html)

-   只要我们把HTML页面放在`classpath:/templates/`，thymeleaf就能自动渲染

-   import thymeleaf namespace
    ```html
    <html lang="en" xmlns:th="http://www.thymeleaf.org">
    ```
-   ![](images/2018-02-04_123955.png)

-   Simple expressions:
    -   Variable Expressions: `${...}`
    -   Selection Variable Expressions: `*{...}`
    -   Message Expressions: `#{...}`
    -   Link URL Expressions: `@{...}`
    -   Fragment Expressions: `~{...}`
-   Literals
    -   Text literals: 'one text', 'Another one!',…
    -   Number literals: 0, 34, 3.0, 12.3,…
    -   Boolean literals: true, false
    -   Null literal: null
    -   Literal tokens: one, sometext, main,…
-   Text operations:
    -   String concatenation: +
    -   Literal substitutions: |The name is ${name}|
-   Arithmetic operations:
    -   Binary operators: +, -, *, /, %
    -   Minus sign (unary operator): -
-   Boolean operations:
    -   Binary operators: and, or
    -   Boolean negation (unary operator): !, not
-   Comparisons and equality:
    -   Comparators: >, <, >=, <= (gt, lt, ge, le)
    -   Equality operators: ==, != (eq, ne)
-   Conditional operators:
    -   If-then: (if) ? (then)
    -   If-then-else: (if) ? (then) : (else)
    -   Default: (value) ?: (defaultvalue)
-   Special tokens:
    -   No-Operation: _

-   For binding variable, there's another way: [[${variable}]] (转义) or [(${variable})] (不转义). **These are useful when you binding checkbox input or just plain html variable**.


## 3. insert/replace/include fragment

create fragment:

```html (sidebar.html)
<nav class="col-md-2 d-none d-md-block bg-light sidebar" th:fragment="sidebar">
    <div class="sidebar-sticky">
        <ul class="nav flex-column">
            <li class="nav-item">
                <a class="nav-link active"
                   th:class="${activeUri} == 'dashboard' ? 'nav-link active': 'nav-link'"
                   th:href="@{/dashboard}"
                   href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                    Dashboard <span class="sr-only">(current)</span>
                </a>
            </li>
        </ul>
    </div>
</nav>
```

insert/replace/inculde fragment:

```html
<div th:replace="common/sidebar::sidebar(activeUri='emps')"></div>
```
    
Note:

-   We can pass `variable` to a fragment when calling the fragment.

## 4. th-each

```html
<tbody>
    <tr th:each="emp:${emps}">
        <td th:text="${emp.id}"></td>
        <td th:text="${emp.lastName}"></td>
        <td th:text="${emp.email}"></td>
        <td th:text="${emp.gender} == 0 ? '女': '男'"></td>
        <td th:text="${emp.department.departmentName}"></td>
        <td th:text="${#dates.format(emp.birth, 'yyyy-MM-dd')}"></td>
        <td>
            <button class="btn btn-sm btn-primary">edit</button>
            <button class="btn btn-sm btn-danger">delete</button>
        </td>
    </tr>
</tbody>
```

## 5. date format

```html
<td th:text="${#dates.format(emp.birth, 'yyyy-MM-dd')}"></td>
```

## 6. url with variable

```html
<form th:method="post" th:action="@{/emp/edit/} + ${employee.id}">
</form>
```

Note:

-   Use `+` if you have 2 different type in thymeleaf.