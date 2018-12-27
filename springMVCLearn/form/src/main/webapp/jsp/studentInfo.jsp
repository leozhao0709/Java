<%--
  Created by IntelliJ IDEA.
  User: lzhao
  Date: 2018-12-26
  Time: 21:09
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>StudentInfo</title>
</head>
<body>
<div>
    Student name: ${student.name}
</div>
<div>
    Student age: ${student.age}
</div>
<div>
    Student password: ${password}
</div>
<div>
    School name: ${student.school.name}
</div>
<div>
    School address: ${student.school.address}
</div>
</body>
</html>
