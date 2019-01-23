# Validator

## 1. dependency

```xml
<dependency>
   <groupId>org.hibernate</groupId>
   <artifactId>hibernate-validator</artifactId>
   <version>6.0.9.Final</version>
</dependency>
```

## 2. setup SpringMVC.xml

add this to `SpringMVC.xml`

```xml
<!--验证器-->
<bean id="validator" class="org.springframework.validation.beanvalidation.LocalValidatorFactoryBean">
    <property name="providerClass" value="org.hibernate.validator.HibernateValidator"/>
</bean>

<!--注册注解驱动-->
<mvc:annotation-driven validator="validator"/>
```

## 3. define your bean and add validator

```java
public class User {

    @NotEmpty(message = "姓名不能为空")
    @Size(min = 4,max = 20,message = "姓名长度必须在{min}-{max}之间")
    private String name;

    @Min(value = 0, message = "年龄不能小于{value}")
    @Max(value = 120,message = "年龄不能大于{value}")
    private int age;

    @Pattern(regexp = "^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$", message = "手机号码不正确")
    private String phone;

    /*
        省略setter和getter
     */
}
```

## 4. define controller

```java
@RequestMapping("/register")
    public ModelAndView register(@Validated User user, BindingResult bindingResult) {
        ModelAndView mv = new ModelAndView();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        if (allErrors.size() > 0) {
            FieldError nameError = bindingResult.getFieldError("name");
            FieldError ageError = bindingResult.getFieldError("age");
            FieldError phoneError = bindingResult.getFieldError("phone");

            if (nameError != null) {
                mv.addObject("nameError", nameError.getDefaultMessage());
            }
            if (ageError != null) {
                mv.addObject("ageError", ageError.getDefaultMessage());
            }
            if (phoneError != null) {
                mv.addObject("phoneError", phoneError.getDefaultMessage());
            }
        }
        mv.setViewName("user");
        return mv;
    }
```

Note:

-   Here we are using `@Validated` and `BindingResult`

## 5. Hibernate Validator

-   `@AssertFalse` 验证注解的元素值是 false
-   `@AssertTrue` 验证注解的元素值是 true
-   `@DecimalMax`（value=x） 验证注解的元素值小于等于指定的十进制value 值
-   `@DecimalMin`（value=x） 验证注解的元素值大于等于指定的十进制value 值
-   `@Digits(integer=整数位数, fraction=小数位数)` 验证注解的元素值的整数位数和小数位数上限
-   `@Future` 验证注解的元素值（日期类型）比当前时间晚
-   `@Max（value=x）` 验证注解的元素值小于等于指定的 value值
-   `@Min（value=x）` 验证注解的元素值大于等于指定的 value值
-   `@NotNull` 验证注解的元素值不是 null
-   `@Null` 验证注解的元素值是 null
-   `@Past` 验证注解的元素值（日期类型）比当前时间早
-   `@Pattern(regex=正则表达式)` 验证注解的元素值不指定的正则表达式匹配
-   `@Size(min=最小值, max=最大值)` 验证注解的元素值的在 min 和 max （包含）指定区间之内，如字符长度、集合大小
-   `@Valid` 该注解主要用于字段为一个包含其他对象的集合或map或数组的字段，或该字段直接为一个其他对象的引用，这样在检查当前对象的同时也会检查该字段所引用的对象。
-   `@NotEmpty` 验证注解的元素值不为 null 且不为空（字符串长度不为 0、集合大小不为 0）
-   `@Range(min=最小值, max=最大值)`验证注解的元素值在最小值和最大值之间
-   `@NotBlank` 验证注解的元素值不为空（不为 null、去除首位空格后长度为 0），不同于@NotEmpty， @NotBlank 只应用于字符串且在比较时会去除字符串的空格
-   `@Length(min=下限, max=上限)` 验证注解的元素值长度在 min 和 max 区间内
-   `@Email` 验证注解的元素值是 Email，也可以通过正则表达式和 flag 指定自定义的 email 格式

