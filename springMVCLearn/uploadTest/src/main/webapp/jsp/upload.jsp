<%--
  Created by IntelliJ IDEA.
  User: lzhao
  Date: 2018-12-28
  Time: 20:29
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/upload.do" method="post" enctype="multipart/form-data">
    <div>
        <input type="file" name="photo">
    </div>
    <button type="submit">Uploads</button>
</form>
</body>
</html>
