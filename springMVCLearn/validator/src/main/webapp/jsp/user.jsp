<%--
  Created by IntelliJ IDEA.
  User: lzhao
  Date: 2018-12-28
  Time: 15:24
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<form action="/register.do" method="post">
    姓名:<input type="text" name="name">${nameError}<br>
    年龄:<input type="text" name="age">${ageError}<br>
    手机:<input type="text" name="phone">${phoneError}<br>
    <input type="submit" value="提交">
</form>
</body>
</html>
