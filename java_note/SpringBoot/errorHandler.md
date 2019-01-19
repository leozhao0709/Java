# Error handler

## 1. return json format

```java
@ControllerAdvice
class UserNotFindExceptionHandler {

    @ResponseBody
    @ExceptionHandler(UserNotFindException.class)
    public Map<String, Object> userNotFindException(Exception e) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", "userNotFind");
        map.put("message", e.getMessage());
        return map;
    }
}
```

Note:
-   We can define our own exception and then we just catch exception here and return what we want to return.
-   Using `@ControllerAdvice` and `@ExceptionHandler` annotation.
-   **If we define return json format, then it won't return error page.**


## 2. return an error html page

-   If we want to return an error page in springboot, we just need to create an **`error` folder**, then **put it under template folder**. Then we need to create some like `error/404.html`, `error/4xx.html` or `error/5xx.html` page. Then when any error occurs, it will find the page according to the error status code. 

-   In error page, we can use some variable
    -   `${timestamp}`
    -   `${status}`
    -   `${error}`
    -   `${message}`

    ```html
    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
        <h1>5xx</h1>
        <h2>timestamp: [[${timestamp}]]</h2>
        <h2>status: [[${status}]]</h2>
        <h2>error: [[${error}]]</h2>
        <h2>message: [[${message}]]</h2>
    </main>
    ```