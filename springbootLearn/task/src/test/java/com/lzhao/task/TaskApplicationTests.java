package com.lzhao.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

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

