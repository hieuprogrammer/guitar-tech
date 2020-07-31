package io.hieu.guitartech.util.email.controller;

import io.hieu.guitartech.util.email.EmailConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(name = "Email Controller", path = { "/api/v2/email", "/api/v2/email.html" })
@Controller
public class EmailController {
    public JavaMailSender javaMailSender;

    @Autowired
    public EmailController(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @ResponseBody
    @GetMapping(path = { "/send-email" })
    public String sendEmail() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(EmailConstants.RECEIVER_EMAIL);
        simpleMailMessage.setSubject("Spring Email");
        simpleMailMessage.setText("Hello, world! 😃 This is Spring Email! 😃");

        this.javaMailSender.send(simpleMailMessage);

        return "Email sent!";
    }
}