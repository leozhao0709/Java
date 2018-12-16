# Servlet

## 0. dependency

```xml
<!-- https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>4.0.1</version>
    <scope>provided</scope>
</dependency>
```

## 1. life cycle

`Constructor(no param)` -> `init()` -> `service()` -> `destory()`

Note:

-   `Constructor()` and `init()` will be only called once even there's multiple url call.
-   `service()` will be called several times, so **you should always write your logic in service**.
-   `destory()` will only be called when tomcat **normally stop**, note normally stop, not terminate or app crash.
-   Servlet is a **multiThread Singleton** variable. So please note here maybe Thread safety issue if you have shared something/memberParams to modify at same time.

## 2. annotation

-   `urlPatterns`, String[], 相当于url-pattern的值
-   `value`, String[], 与 urlPatterns 意义相同，不能与 urlPatterns 属性同时使用
-   `name`, String, 相当于servlet-name的值
-   `loadOnStartup`, int, 相当于loadOnStartup，默认值为-1. 用于启动tomcat时, 直接启动servlet.
-   `initParams`, WebInitParam[], 相当于init-param标签。其类型为另一个注解 WebInitParam 数组

```java
@WebServlet(name = "TestServlet",
        value = {"/test"},
        initParams = {
                @WebInitParam(name = "teacher", value = "Lei"),
                @WebInitParam(name = "course", value = "java")
        })
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig config = this.getServletConfig();

        String servletName = config.getServletName();
        System.out.println("ServletName: " + servletName); // ServletName: TestServlet

        Enumeration<String> initParameterNames = config.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String name = initParameterNames.nextElement();
            String value = config.getInitParameter(name);
            System.out.println(name + ": " + value); // teacher: Lei, course: java
        }
    }
}
```

## 3. Servlet Context

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
