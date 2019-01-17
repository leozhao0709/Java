# Interceptor in Spring boot

## 1. create interceptor

```java
@Component("MyInterceptors")
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("拦截器中的preHandle方法");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截器中的postHandle方法");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("拦截器中的afterCompletion方法");
    }
}
```

## 2. extend configuration to add this interceptor

```java
@Configuration
class MyInterceptorsConfig implements WebMvcConfigurer {

    @Resource(name = "MyInterceptors")
    private MyInterceptors myInterceptors;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptors);
    }
}
```

Note:

-   Using `@Configuration` to tell spring boot, this is an extra configuration file that need to be load. And we add our interceptors here.
-   In here, we are implements `WebMvcConfigurer`. If you are not using spring 5.0 or higher, then please **extends** `WebMvcConfigurerAdapter`.
-   You need to **restart server** to load the config.
