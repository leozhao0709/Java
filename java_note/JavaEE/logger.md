# logger in java

## 1. logger level

-   fatal(致命的)
-   error
-   warn
-   info
-   debug
-   trace(堆栈)

## 2. log4j2 and slf4j

log4j2 is an apache opensource logger jar package.
slf4j is a rule implementation that can combine different logger jar which means slf4j is compatible with different logger and you may just want to use slf4j. 

**slf4j and log4j2 relationship is like jdbc and mysql-connector-java**

dependency:

```xml
<!--logger-->
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>1.7.25</version>
</dependency>
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-slf4j-impl</artifactId>
    <version>2.8.2</version>
</dependency>
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-web</artifactId>
    <version>2.8.2</version>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-api</artifactId>
    <version>2.8.2</version>
</dependency>
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>2.8.2</version>
</dependency>
```

Then log4j2 xml configure file `src/main/resource/log4j2.xml`:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="OFF">
    <Appenders>
        <!-- console -->
        <Console name="Console" target="SYSTEM_OUT">
            <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n" />
        </Console>
        <!-- file -->
        <File name="file" fileName="log/output.log" append="true">
            <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n" />
        </File>
        <!-- rollingFile -->
        <RollingFile name="roolingFlie" fileName="logs/app.log"
            filePattern="logs/$${date:yyyy-MM}/app-%d{MM-dd-yyyy}-%i.log.gz">
            <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n" />
            <SizeBasedTriggeringPolicy size="1kb" />
        </RollingFile>
    </Appenders>
    <Loggers>
        <Root level="info">
            <AppenderRef ref="Console" />
        </Root>
    </Loggers>
</Configuration>
```

Then in your java file:

```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class LoggerTest {

    private static Logger log = LoggerFactory.getLogger(LoggerTest.class);

    public static void main(String[] args) {
        log.debug("debug信息");
        log.info("info信息");
        log.warn("warn信息");
        log.error("error信息");
    }
}
```

Note:

-   With log4j2, no matter you use `file or rollingFile`, as long as you define that tag in configure file, then it will generate the file. If you doesn't configure to use it but defined it, it just doesn't write log to file but will create log file it self with 0kb size.
-   In you java source file, make sure you are import `slf4j` not any other logger.