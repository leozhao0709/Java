# Email

## 0. dependency

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-mail</artifactId>
</dependency>
```

## 1. config

```yml
spring:
  mail:
    username: ${MAIL_USERNAME}
    password: ${MAIL_PASSWORD}
    host: smtp.gmail.com
    properties:
      mail:
        smtp:
          ssl:
            enable: true
```

## 2. simple email

```java
@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskApplicationTests {

    @Autowired
    private JavaMailSenderImpl mailSender;

    @Test
    public void sendSimpleEmail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("test-meeting");
        message.setText("test text");
        message.setTo("zhao434@usc.edu", "leizhaotest@126.com");

        this.mailSender.send(message);
    }
}
```

## 3. email with attachment

```java
@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskApplicationTests {

    @Autowired
    private JavaMailSenderImpl mailSender;

    @Test
    public void sendEmailWithAttachment() throws MessagingException {
        MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setSubject("test-meeting");
        helper.setText("<b style='color: red'>test text<b>", true);
        helper.setTo(new String[]{"zhao434@usc.edu", "leizhaotest@126.com"});

        helper.addAttachment("1.png", new File("/Users/lzhao/Downloads/cronFormat.png"));
        helper.addAttachment("1.png", new File("/Users/lzhao/Downloads/oldWarningCheck.png"));

        this.mailSender.send(mimeMessage);
    }
}
```

Note:

-   `MimeMessageHelper.setText()` has the second parameter which can define it's a html or not. default is false.
