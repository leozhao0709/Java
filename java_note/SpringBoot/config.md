# Config

## 0. config load location

springboot 启动会扫描以下位置的application.properties或者application.yml文件作为Spring boot的默认配置文件

–project:./config/

–project:./

–resources:./config/

–resources:./

优先级由高到底，高优先级的配置会覆盖低优先级的配置；

SpringBoot会从这四个位置全部加载主配置文件；互补配置；



==我们还可以通过spring.config.location来改变默认的配置文件位置==

**项目打包好以后，我们可以使用命令行参数的形式，启动项目的时候来指定配置文件的新位置；指定配置文件和默认加载的这些配置文件共同起作用形成互补配置**；

`java -jar spring-boot-02-config-02-0.0.1-SNAPSHOT.jar --spring.config.location=G:/application.properties`

**if you put the an `application.properties/application.yml` file at the same folder with your jar package, then you even do not need to specify the --spring.config.location, just run `java -jar spring-boot-02-config-02-0.0.1-SNAPSHOT.jar `**

## 1. using `@ConfigurationProperties(prefix="something")` and `@Component`

We can use this `@ConfigurationProperties` annotation and bind it with a class. Then we can read the properties from yml/properties file. Plase check the `yaml.md` for this case.


## 2. using `@Value`

If we just want to use one property once in some class, then we can simply use `@Value("${propertyName}")` to get the properties defined in `application.properties` or `application.yml`.


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
