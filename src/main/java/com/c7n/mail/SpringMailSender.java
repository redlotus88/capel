package com.c7n.mail;

import com.c7n.Application;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Spring Mail Sender 使用Java程序发送邮件
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
@NoArgsConstructor
public class SpringMailSender {

    /**
     * mail sender的账号配置在apollo中进行配置
     * spring.mail.host
     * spring.mail.username
     * spring.mail.password
     * spring.mail.default-encoding
     * spring.mail.port
     */
    @Autowired
    private JavaMailSender javaMailSender;

    @Test
    public void testSendMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("rdltspg77@163.com");
        message.setTo("wangjialong77@163.com");
        message.setSubject("Send Mail By Spring Mail Sender.");
        message.setText("This is a mail send by Capel Project - Spring Sender Mail automatically.");

        try {
            javaMailSender.send(message);
            log.info("test send mail success");
        } catch (Exception e) {
            log.error("Send mail failure, {}", e.getMessage());
        }
    }



}
