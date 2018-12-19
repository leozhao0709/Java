# Servlet Context

## 1. Servlet Context

```java
// in first servlet
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ServletContext context = this.getServletContext();
    context.setAttribute("username", "root");
    context.setAttribute("password", "1234");
}

// in another servlet
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ServletContext context = this.getServletContext();
    String username = (String) context.getAttribute("username");
    String password = (String) context.getAttribute("password");
    System.out.println(username + ": " + password);
}
```

Note:

-   `ServletContext` is shared in your whole app.
-   We can set or get Attribute in servlet.
-   We can also define some initial attribute using `web.xml`.