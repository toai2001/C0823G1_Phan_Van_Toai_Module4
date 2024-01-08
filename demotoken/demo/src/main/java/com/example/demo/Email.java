package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class Email {
    @Autowired
    JavaMailSender javaMailSender;

    @GetMapping("")
    public String show() {
        return "FormSendMail";
    }

    @PostMapping("/send")
    public String sendMail(@RequestParam(value = "to") String to) {
        String subject = "GỬi link";
        String content = "http://localhost:8080/result";
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        javaMailSender.send(message);
        return "result";
    }
}
