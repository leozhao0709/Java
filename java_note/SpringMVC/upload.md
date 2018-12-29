# Upload

## 1. Create temp and upload folders for upload

We need to create the `temp` and `uploads` folder under `src/main/webapp`. Be careful if we are using intellij, then we need to add a file to these 2 folder, otherwise, these 2 folders won't be deployed.

## 2. Add the following xml to web.xml

在web.xml中的中央控制器的servlet配置里面添加下面内容. Follow the `setup.md` file.

```xml
<!--使用servlet3.0实现文件上传-->
<multipart-config>
    <!--临时文件路径-->
    <location>/tmp</location>
    <!--单个上传文件的最大值，单位是byte-->
    <max-file-size>1048576</max-file-size>
    <!--总上传文件的最大值-->
    <max-request-size>52428800</max-request-size>
    <!--内存缓冲区的大小,当超过该值时，会写入到临时文件中，单位是byte-->
    <file-size-threshold>1024</file-size-threshold>
</multipart-config>
```

Note:

-   For mac, use `/tmp`; But for windows, please use `/temp`

## 3. add this to springMVC.xml

`<bean id="multipartResolver" class="org.springframework.web.multipart.support.StandardServletMultipartResolver"/>`

## 4. java and jsp

Please be careful that input file name should be same as your java method params name. If you want to change the name, please use `@requestParam`

```jsp
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
```

```java
@RequestMapping("/upload")
public ModelAndView uploadFile(@RequestParam(name = "photo") MultipartFile file, HttpServletRequest request) throws IOException {
    ModelAndView mv = new ModelAndView();

    if (!file.isEmpty()) {
        String path = request.getServletContext().getRealPath("/uploads");
        String originalFilename = file.getOriginalFilename();

        LocalDate localDate = LocalDate.now();
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();

        String uploadDirPath = path + File.separator + year + File.separator + month + File.separator + day ;
        File uploadDir = new File(uploadDirPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        if ("image/png".equals(file.getContentType())) {
            String uploadFileName = UUID.randomUUID() + originalFilename;
            File uploadFile = new File(uploadDirPath, uploadFileName);
            file.transferTo(uploadFile);
        } else {
            mv.addObject("msg", "Please upload a png file");
            mv.setViewName("upload-fail");
            return mv;
        }
    } else {
        mv.addObject("msg", "You need to select a file to upload");
        mv.setViewName("upload-fail");
        return mv;
    }

    mv.setViewName("upload-success");
    return mv;
}
```