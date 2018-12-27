<%--
  Created by IntelliJ IDEA.
  User: lzhao
  Date: 2018-12-26
  Time: 16:57
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/params02.do" method="post">
    <div>
        <label for="username">username: </label>
        <input type="text" id="username" name="username">
    </div>
    <div>
        <label for="age">age: </label>
        <input type="text" id="age" name="age">
    </div>
    <button type="submit">Submit</button>
</form>
</body>
</html>
