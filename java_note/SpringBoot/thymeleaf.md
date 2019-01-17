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
    
