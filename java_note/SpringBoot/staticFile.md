# Static files in springboot

## 0. load location

all the static file will go to these path to find including `index.html` and `favicon`. So put your static files in these folder.

```java
"classpath:/META-INF/resources/", 
"classpath:/resources/",
"classpath:/static/", 
"classpath:/public/" 
"/"：当前项目的根路径
```
