# Security

## 0. dependency

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-test</artifactId>
    <scope>test</scope>
</dependency>
```

If you are also use thymeleaf, please also inject this:

```xml
<dependency>
    <groupId>org.thymeleaf.extras</groupId>
    <artifactId>thymeleaf-extras-springsecurity5</artifactId>
</dependency>
```

## 1. Security config

```java
@EnableWebSecurity
class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
         http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3")
                ;
        http.formLogin()
                .usernameParameter("user")
                .passwordParameter("pwd")
                .loginPage("/userlogin")
                .loginProcessingUrl("/login")
                .failureUrl("/login?error")
                .and()
                .logout()
                .logoutSuccessUrl("/")
                ;

        http.rememberMe().rememberMeParameter("rememberMe");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        auth.inMemoryAuthentication()
                .withUser("zhangsan").password(passwordEncoder().encode("12345")).roles("VIP1", "VIP2")
                .and()
                .withUser("lisi").password(passwordEncoder().encode("12345")).roles("VIP2", "VIP3")
                ;
    }
}
```

Note:

-   In here, you may want to comment the `super` as it defines some its own requirement.
-   If you don't define login url, it will use `/login`. If you don't define login fail url, it will use `/login?error` page. If you don't define logout page, it will use `/logout` page.
-   You can customize your login page with `.loginPage("/userlogin")`. If you don't define `loginProcessingUrl("/login")`, then it will use your `/userlogin` to do the post login process. You should also define `usernameParameter("user")`, `passwordParameter("pwd")` and `rememberMeParameter("rememberMe")` to give your html input field a name.



## 2. use authentication in thymeleaf

-   header:

    ```html
    <html lang="en" xmlns:th="http://www.thymeleaf.org"
    xmlns:sec="http://www.thymeleaf.org/extras/spring-security">
    ```

-   `sec:authorize="isAnonymous()"`, 
    `sec:authorize="isAuthenticated()"`, 
    `sec:authentication="name"`, 
    `sec:authentication="principal.authorities"`,
    `sec:authorize="hasRole('VIP1')"`

    ```html
    <div sec:authorize="isAnonymous()" >
        <h2 align="center">游客您好，如果想查看武林秘籍 <a th:href="@{/login}">请登录</a></h2>
    </div>

    <div sec:authorize="isAuthenticated()">
        <h2>
            <span sec:authentication="name"></span>, 您好, 您的角色有:
            <span sec:authentication="principal.authorities"></span>
        </h2>
        <form th:action="@{/logout}" method="post" >
            <button th:type="submit">注销</button>
        </form>
    </div>

    <div sec:authorize="hasRole('VIP1')">
        <h3>普通武功秘籍</h3>
        <ul>
            <li><a th:href="@{/level1/1}">罗汉拳</a></li>
            <li><a th:href="@{/level1/2}">武当长拳</a></li>
            <li><a th:href="@{/level1/3}">全真剑法</a></li>
        </ul>
    </div>
    ```
