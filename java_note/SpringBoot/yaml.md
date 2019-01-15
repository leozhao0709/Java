# Yaml

## 0. pre-request

If you want to use yaml configure file in springboot, then you need to create a `application.yml` file.

## 1. dependency

If we want to read some properties from yaml file, we need to import this dependency:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-configuration-processor</artifactId>
    <optional>true</optional>
</dependency>
```

## 2. create a config class to bind properties

create a config class to recieve the yaml file properties.

```java
@Component
@ConfigurationProperties(prefix = "person")
class Person {

    private String name;
    private int age;
    private boolean isBoss;
    private LocalDate birthDay;

    private Map<String, Object> map;
    private List<Object> list;
    private Dog dog;

    // 省略getter and setter
}
```

Note:

-   using `@Component` and `@ConfigurationProperties` annotations
-   **You must provide setter and getter**

## 3. define properties in your yaml file

```yaml
person:
  name: ${DB_USER}
  age: 27
  boss: false
  birth-day: 1991/1/1
  map: {k1: v1, k2: v2}
  list: [lisi, zhangsan]
  dog:
    name: dog
    age: 12
```

Note:

-   For a `yaml` file, it must like this style: `key: value`. Be careful that there is one space between key and value.
-   For a string value, you don't need to provide quote mark unless you need to convert some special character like `\n`. When you need to convert the character, then you must use **single quote**. Double quote won't convert any character, but single quote do.
-   If you want to receive intellisense in intellij, then build your class before you write yaml file.
-   In springboot, if you want to get a environment variable, you can simply use `${variable}` to get. You can also use `${variable}` to get what you already defined in your yaml file.
