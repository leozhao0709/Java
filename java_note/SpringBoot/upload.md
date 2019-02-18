# Upload

## 1. define upload folder

```yml
upload:
  folder: /Users/lzhao/Desktop/
```

## 2. add upload folder to resource folder

```java
@Configuration
class ResourceConfig implements WebMvcConfigurer {

    @Value("${upload.folder}")
    private String uploadFolder;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations(this.uploadFolder);
    }
}
```

## 3. add upload logic

```java
@RestController
class UploadController {

    @Value("${upload.folder}")
    private String uploadFolder;

    @PostMapping("/upload")
    public Map<String, Object> upload(@RequestParam(name = "file")MultipartFile file) throws IOException {
        Map<String, Object> map = new HashMap<>();

        String path = this.uploadFolder;

        if (!file.isEmpty()) {
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
            map.put("msg", "Please upload a png file");
            return map;
        }
    } else {
        map.put("msg", "You need to select a file to upload");
        return map;
    }

        map.put("result", "success");
        return map;
    }
}
```