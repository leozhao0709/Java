# HttpServletResponse

## 1. usage

```java
response.setContentType("text/html; charset=UTF-8");
PrintWriter writer = response.getWriter();
writer.print("userName: " + userName + " register successfully! <br>");
writer.print("Thanks for registering!");
writer.close();
```

Note:

-   Remember to close `writer`.
-   Use `response.setContentType("text/html; charset=UTF-8");` to set up response encoding
