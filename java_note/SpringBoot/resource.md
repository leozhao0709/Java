# Resources files in springboot

## 0. load location

all the static file will go to these path to find including `index.html` and `favicon`. So put your static files in these folder.

```java
"classpath:/META-INF/resources/", 
"classpath:/resources/",
"classpath:/static/", 
"classpath:/public/" 
"/"：当前项目的根路径
```

## 1. add resource folder

```yml
upload:
  folder: /Users/lzhao/Desktop/
```


```java
@Configuration
class ResourceConfig implements WebMvcConfigurer {

    @Value("${upload.folder}") // get it from application.yml
    private String uploadFolder;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**")
                .addResourceLocations(this.uploadFolder);
    }
}
```

Note:

-   Please note the folder name should be end with `/`, otherwise, you may not access folder
