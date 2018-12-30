# Interceptor

## 1. theory

![spring mvc interceptor](./images/springMVCInterceptor.png)

## 2. usage

```java
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

## 3. configure springMVC.xml

```xml
<!--注册拦截器-->
<mvc:interceptors>
    <mvc:interceptor>
        <mvc:mapping path="/**"/>
        <bean class="package.interceptors.myInterceptor"/>
    </mvc:interceptor>
</mvc:interceptors>
```

## 4. difference with filter

**Interceptor** will only intercept the springMVC controller and **can't intercept directly jsp call**. But filter can interceptor all.