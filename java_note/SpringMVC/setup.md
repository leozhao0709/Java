# Setup

## 1. Maven Dependency

```xml
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>4.0.1</version>
</dependency>
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.0.4.RELEASE</version>
</dependency>
```

## 2. springMVC.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
	   http://www.springframework.org/schema/beans/spring-beans.xsd
	   http://www.springframework.org/schema/context
	   http://www.springframework.org/schema/context/spring-context.xsd
	   http://www.springframework.org/schema/mvc
	   http://www.springframework.org/schema/mvc/spring-mvc.xsd
	   http://www.springframework.org/schema/aop
	   http://www.springframework.org/schema/aop/spring-aop.xsd">

    <!-- 注册组件扫描器 -->
    <context:component-scan base-package="controllers"/>
    
    <!-- 静态资源 -->
    <mvc:annotation-driven/>
    <mvc:resources mapping="/images/**" location="/images" />
    <mvc:resources mapping="/css/**" location="/css" />

     <!-- 视图解析器 -->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/jsp/"/>
        <property name="suffix" value=".jsp"/>
    </bean>
</beans>
```

Note:

-   Please set up the correct scan package.
-   Put this file under `src/main/resources/springMVC.xml`.
-   Make sure you set up the scan package and make the static folder.

## 3. add config for web.xml

```xml
<!--字符编码过滤器-->
<filter>
    <filter-name>characterEncodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>

    <!--指定字符编码-->
    <init-param>
        <param-name>encoding</param-name>
        <param-value>utf-8</param-value>
    </init-param>

    <!--强制指定字符编码，即如果在request中指定了字符编码，那么也会为其强制指定当前设置的字符编码-->
    <init-param>
        <param-name>forceEncoding</param-name>
        <param-value>true</param-value>
    </init-param>

</filter>
<filter-mapping>
    <filter-name>characterEncodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>


<!-- 注册spring MVC中央控制器 -->
<servlet>
    <servlet-name>springMVC</servlet-name>
    <!-- spring MVC中的核心控制器 -->
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <init-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:springMVC.xml</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
</servlet>
<servlet-mapping>
    <servlet-name>springMVC</servlet-name>
    <url-pattern>*.do</url-pattern>
</servlet-mapping>
```

Note:

-   **Please use 3.0 or 4.0 web.xml**
-   Put this config to `src/main/webapp/WEB-INF/web.xml`

## 4. create your controller

```java
@Controller()
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping({"/hello.do", "/welcome.do"})
    public ModelAndView test1(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("hello", "hello springMVC");
        mv.setViewName("hello");

        return mv;
    }
}
```