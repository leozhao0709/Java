# Session

## 1. set session

```java
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    session.setAttribute("name", "sessionAdmin");
}
```

Note:
-   Session will automatically created by servlet itself. We only need to `setAttribute`

## 2. get session

```java
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    String name = (String) session.getAttribute("name");
    System.out.println(name);
    session.removeAttribute("name");

    //使session失效
    session.invalidate();
}
```

Note:
-   Use `getAttribute` to get session stored data.
-   Use `removeAttribute` to remove a session stored data.
-   Use `session.invalidate();` to invalidate a session.

## 3. set session invalid time

in `web.xml`, set up this:

```xml
<session-config>
    <session-timeout>60</session-timeout>
</session-config>
```

Note:
-   The unit is **minute**.
-   If you don't set this, then the default time is 30 minutes.
