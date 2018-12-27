<%--
  Created by IntelliJ IDEA.
  User: lzhao
  Date: 2018-12-26
  Time: 21:04
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/studentInfo.do" method="post">
    <div>
        <label for="name">name: </label>
        <input type="text" id="name" name="name">
    </div>

    <div>
        <label for="password">password: </label>
        <input type="text" id="password" name="password">
    </div>

    <div>
        <label for="age">age: </label>
        <input type="text" id="age" name="age">
    </div>

    <div>
        <label for="schoolName">schoolName:</label>
        <input type="text" id="schoolName" name="school.name">
    </div>

    <div>
        <label for="schoolAddress">schoolAddress:</label>
        <input type="text" id="schoolAddress" name="school.address">
    </div>

    <button type="submit">Submit</button>
</form>
</body>
</html>
