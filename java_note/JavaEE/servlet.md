# Servlet

## 0. dependency

```xml
<!-- https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>4.0.1</version>
    <scope>provided</scope>
</dependency>
```

## 1. life cycle

`Constructor(no param)` -> `init()` -> `service()` -> `destory()`

Note:

-   `Constructor()` and `init()` will be only called once even there's multiple url call.
-   `service()` will be called several times, so **you should always write your logic in service**.
-   `destory()` will only be called when tomcat **normally stop**, note normally stop, not terminate or app crash.

