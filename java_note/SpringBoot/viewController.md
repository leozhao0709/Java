# View Controller

## 1. directly add view controller without a controller

```java
@Configuration
class MyViewControllers implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/dashboard").setViewName("dashboard");
    }
}
```

Note:

-   Using `@Configuration` to tell spring boot, this is an extra configuration file that need to be load. And we add our view controller here.
-   In here, we are implements `WebMvcConfigurer`. If you are not using spring 5.0 or higher, then please **extends** `WebMvcConfigurerAdapter`.
-   You need to **restart server** to load the config.