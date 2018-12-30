# Filter

## 1. filter

```java
@WebFilter(filterName = "MyFilter", urlPatterns = "/*")
public class MyFilter implements Filter {
    public MyFilter() {
        System.out.println("filter constructor...");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("initial config");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("doFilter...");
        chain.doFilter(req, resp);
    }

    public void destroy() {
        System.out.println("destroy...");
    }
}
```

Note:

-   Filter 是单例多线程的
-   Filter 是在应用被加载时创建并初始化， 这是与 Servlet 不同的地方。 Servlet 是在该 Servlet被第一次访问时创建。 Filter 与 Servlet 的共同点是，其无参构造器与 init()方法只会执行一次
-   用户每提交一次该 Filter 可以过滤的请求，服务器就会执行一次 doFilter()方法，即doFilter()方法是可以被多次执行的
-   当应用被停止时执行 destroy()方法，Filter 被销毁，即 destroy()方法只会执行一次
-   由于 Filter 是单例多线程的，所以为了保证其线程安全性，一般情况下是不为 Filter 类定义可修改的成员变量的。因为每个线程均可修改这个成员变量，会出现线程安全问题
-   在Filter中的init方法上有一个参数叫FilterConfig，这是Filter的配置对象，通过FilterConfig对象可以获取当前 Filter 在 web.xml中的配置信息，这与ServletConfig类似。一个 Filter 对象一个 FilterConfig 对象，多个 Filter 对象会有多个 FilterConfig 对象