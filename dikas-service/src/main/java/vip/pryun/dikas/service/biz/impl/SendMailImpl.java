package vip.pryun.dikas.service.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author CJ
 * @date 2019/6/3 10:52
 * @note
 */
@Service
@Configuration
public class SendMailImpl {
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.subject}")
    private String subject;

    public Boolean sendMailMessage(String url) {
        MimeMessage message = null;
        try {
            message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(username);
            helper.setTo(url);
            helper.setSubject(subject);
            helper.setText("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Title</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <h1 align=\"center\">面试邀请通知</h1>\n" +
                    "    <p style=\"align-content: center; color: blueviolet\">恭喜你，通过我们的进一步筛选，请你到我们公司来面试</p>\n" +
                    "</body>\n" +
                    "</html>", true);
            javaMailSender.send(message);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return false;
    }
}
