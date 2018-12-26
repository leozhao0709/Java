# Listener

## 1. [Servlet Listener](http://www.monkey1024.com/javaweb/986)

在servlet中一共有8个监听器，按照监听器的作用分类如下：

-   监听web对象创建与销毁的监听器
    -   ServletContextListener
    -   HttpSessionListener
    -   ServletRequestListener
-   监听web对象属性变化的监听器
    -   ServletContextAttributeListener
    -   HttpSessionAttributeListener
    -   ServletRequestAttributeListener
-   监听session绑定javaBean操作的监听器
    -   HttpSessionBindingListener
    -   HttpSessionActivationListener

## 2. example

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    当前在线用户: ${ipCount} <br>
    <a href="${pageContext.request.contextPath}/logout">退出</a>
</body>
</html>
```

```java
@WebListener()
public class ServletListener implements ServletContextListener,
        HttpSessionListener, ServletRequestListener {

    private Map<String, List<HttpSession>> ipMap;

    // Public constructor is required by servlet spec
    public ServletListener() {
    }

    public void contextInitialized(ServletContextEvent sce) {
        this.ipMap = new HashMap<>();
    }

    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        String ip = request.getRemoteAddr();

        if (!this.ipMap.containsKey(ip)) {
            this.ipMap.put(ip, new ArrayList<>());
        }

        HttpSession session = request.getSession();
        if (!this.ipMap.get(ip).contains(session)) {
            this.ipMap.get(ip).add(session);
            session.setAttribute("ip", ip);
        }

        System.out.println(this.ipMap);
        sre.getServletContext().setAttribute("ipCount", this.ipMap.size());
    }
    

    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        String ip = (String) session.getAttribute("ip");

        List<HttpSession> sessionList = this.ipMap.get(ip);
        sessionList.remove(session);

        if (sessionList.size() == 0) {
            this.ipMap.remove(ip);
        }

        session.getServletContext().setAttribute("ipCount", this.ipMap.size());
    }
}
```