# Upload

## 1. version 3.0 upload

Servlet3.0 提供了专门的文件上传 API。 HttpServletRequest 的 getPart()方法可以完成单个文件上传，而 getParts()方法可以完成多个文件上传。注意，这两个方法是从 Servlet3.0 开始定义的。

-   `getPart`
方法：Part getPart(String name) throws IOException, ServletException
作用：获取 Multipart 请求中指定名称的"部分"。一般这里的参数是上传表单中的"file"表单项的 name 值。

-   `getParts`
方法：java.util.Collection getParts()throws IOException, ServletException
作用：获取 Multipart 请求中的所有"部分"。多文件上传时使用该方法。


Servlet3.0在javax.servlet.http包中新增了Part接口，该接口中常用的方法有：

-   `write`
方法：void write(String fileName) throws IOException
作用：将上传文件数据写入到指定的文件中。

另外在Servlet3.1中的Part接口里面新增了`getSubmittedFileName`方法用来获取上传的文件名

## 2. annotation

`@WebServlet("/upload")`
`@MultipartConfig(maxRequestSize = 1024*5)` // 表示当前servlet可以处理multipart请求

在@MultipartConfig注解中有两个属性：
`maxFileSize`：表示上传一个文件的最大值，单位是byte
`maxRequestSize`：表示一次请求中上传文件的最大值，一次可能上传多个文件，这些文件大小的之和。单位是byte

如果上传的文件超出了设置的最大值时，系统会在 `Part part = request.getPart("photo");` 抛出一个IllegalStateException的异常，我们可以通过捕获该异常从而向用户提示友好信息。

## 3. example

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" method="post">
    <input type="file" name="photo"><br>
    <button type="submit">upload</button>
</form>
</body>
</html>
```

```java
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");

    String uploadsPath = this.getServletContext().getRealPath("/uploads");
    System.out.println(uploadsPath);

    Part part = request.getPart("photo");
    String fileName = part.getSubmittedFileName();
    fileName = UUID.randomUUID() + "_" + fileName;

    LocalDate now = LocalDate.now();
    int year = now.getYear();
    int month = now.getMonthValue();
    int day = now .getDayOfMonth();

    uploadsPath = uploadsPath + File.separator + year + File.separator + month + File.separator + day;
    File parentDir = new File(uploadsPath);

    if (!parentDir.exists()) {
        parentDir.mkdirs();
    }
    System.out.println(uploadsPath);
    part.write(uploadsPath + File.separator + fileName);
}
```




