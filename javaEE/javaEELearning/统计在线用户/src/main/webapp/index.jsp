<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page import="listener.ServletListener" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>

    当前在线用户: ${ipCount} <br>
    <a href="${pageContext.request.contextPath}/logout">退出</a>
</body>
</html>
