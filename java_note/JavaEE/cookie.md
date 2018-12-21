# Cookie

## 1. Check cookie enable or not

```js
if(navigator.cookieEnabled == true){
    alert("支持cookie");
}else{
    alert("cookie已被禁用");
}
```

## 2. cookie小知识

-   浏览器一般只允许存放300个Cookie，每个站点最多存放20个Cookie，每个Cookie的大小限制为4KB。
-   如果创建了一个cookie，并将他发送到浏览器，默认情况下它是一个会话级别的cookie（即存储在浏览器的内存中），用户退出浏览器之后即被删除。若希望浏览器将该cookie存储在磁盘上，则需要使用maxAge，并给出一个以秒为单位的时间。将最大时效设为0则是命令浏览器删除该cookie。
-   删除cookie时，path必须一致，否则不会删除

## 3. set cookie

```java
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Cookie cookie1 = new Cookie("username", "admin");
    Cookie cookie2 = new Cookie("password", "12345");

    // cookie1.setPath(request.getContextPath() + "/aaa");
    // cookie2.setPath(request.getContextPath() + "/aaa");

    cookie1.setMaxAge(60 * 60); // 1 hour
    cookie2.setMaxAge(60 * 60 * 24); // 1 day

    response.addCookie(cookie1);
    response.addCookie(cookie2);
}
```

Note:

-   We can set a cookie for different path.
-   Use `setMaxAge(seconds)` to set the expire time. Plase note it's seconds, not milliseconds.

## 4. get cookie

```java
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Cookie[] cookies = request.getCookies();

    for (Cookie cookie: cookies) {
        String name = cookie.getName();
        String value = cookie.getValue();

        System.out.println(name + ": " + value);
    }
}
```

Note:

-   We can use `request.getCookies();` to get cookies.
