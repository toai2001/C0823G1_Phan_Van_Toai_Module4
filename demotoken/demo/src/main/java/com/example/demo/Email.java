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
@RequestMapping
public class Email {
    @Autowired
    private JavaMailSender javaMailSender;

    @GetMapping("/send-email")
    public String showEmailForm() {
        return "email-form";
    }
    @PostMapping("/send-email")
    public String sendEmail(@RequestParam String toEmail,
                            Model model) {
        try {
            // Tạo mã xác nhận ngẫu nhiên
            String confirmationCode = UUID.randomUUID().toString();

            // Gửi email
            sendConfirmationEmail(toEmail, confirmationCode);

            // Gửi mã xác nhận về cho view để hiển thị
            model.addAttribute("confirmationCode", confirmationCode);
            return "confirmation-success";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("result", "Error sending email.");
            return "email-form";
        }
    }

    private void sendConfirmationEmail(String toEmail, String confirmationCode) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Xác nhận địa chỉ email");
        message.setText("Mã xác nhận của bạn: " + confirmationCode);

        javaMailSender.send(message);
    }
}
