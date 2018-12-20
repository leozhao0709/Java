# HttpServletRequest

## 1. method

-   `Map getParameterMap()` 获取包含所有请求参数及值的 Map 对象。需要注意，该 Map 的 value 为 String[]，即一个参数所对应的值为一个数组。说明一个参数可以对应多个值。
-   `Enumeration getParameterNames()` 获取请求参数 Map 的所有 key,即获取所有请求参数名。
-   `String[] getParameterValues(String name)` 根据指定的请求参数名称，获取其对应的所有值。这个方法一般用于获取复选框(checkbox)数据。
-   `String getParameter(String name)` 根据指定的请求参数名称，获取其对应的值。若该参数名称对应的是多个值，则该方法获取到的是第一个值。这个方法是最常用的方法。

-   `getRequestURL` 方法返回客户端发出请求时的完整URL。
-   `getRequestURI` 方法返回请求行中的资源名部分。
-   `getQueryString` 方法返回请求行中的参数部分。
-   `getRemoteAddr` 方法返回发出请求的客户机的IP地址
-   `getRemoteHost` 方法返回发出请求的客户机的完整主机名
-   `getRemotePort` 方法返回客户机所使用的网络端口号
-   `getLocalAddr` 方法返回WEB服务器的IP地址。
-   `getLocalName` 方法返回WEB服务器的主机名
-   `getMethod` 得到客户机请求方式

```java
request.setCharacterEncoding("utf-8");
        
String userName = request.getParameter("username");
String password = request.getParameter("password");

String[] hobbies = request.getParameterValues("hobby");

System.out.println("userName: " + userName);
System.out.println("password: " + password);
System.out.println("hobbies: " + Arrays.toString(hobbies));
```

Note:

-   Use `request.setCharacterEncoding("utf-8");` to set post method encoding
-   For get method encoding, please check [JavaEE encoding](http://www.monkey1024.com/javaweb/918)
