# Config

## 1. using `@ConfigurationProperties(prefix="something")`

We can use this `@ConfigurationProperties` annotation and bind it with a class. Then we can read the properties from yml/properties file. Plase check the `setup.md` for this case.

## 2. using `@Value`

If we just want to use one property once in some class, then we can simply use `@value(${propertyName})` to get the properties defined in `application.properties` or `application.yml`.

## 3. trick for `@PropertySource` (not recommend)

**`@PropertySource` is only useful when you are using `properties` to setup.**

You can extract your properties to different file. Then before you load you property in java, add this annotation to just load the correct properties file. example: `@PropertySource(value={classpath:person.properties})`.

**Be careful here that no space between classpath and your properties file**

## 4. config for different env

We can create different properties/yml file for different env. **The file name must be `application-dev.yml` style**. Then we can use `spring.profiles.active=dev` to active the environment.

We have 3 ways to active the env:
-   In default application.yml configuration file, we can point:
    ```yml
    spring:
        profiles:
            active: prod
    ```
-   Using command line: `java -jar spring-boot-02-config-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev；`
-   Using VM configure: `-Dspring.profiles.active=dev`
