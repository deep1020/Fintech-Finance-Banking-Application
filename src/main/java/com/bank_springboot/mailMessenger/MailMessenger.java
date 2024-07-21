package com.bank_springboot.mailMessenger;

import com.bank_springboot.config.MailConfig;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.UUID;

@Component
public class MailMessenger {
    private static JavaMailSender mailSender;

    public MailMessenger(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    public static void sendVerificationEmail(String toMail, String verificationToken) throws MessagingException {
        System.out.println("In MailMessenger");
        String body = "Please click the following link to verify your account: "
                + "http://127.0.0.1:8076/verify?token=" + verificationToken;
        String subject = "Verify your account";
        // Get Mail Config:
        JavaMailSender sender = MailConfig.getMailConfig();
        System.out.println("Sender: "+sender);
        // Set Mime Message:
        MimeMessage message = mailSender.createMimeMessage();
        System.out.println("MimeMessage: "+message);
        // Set Mime Message Helper:
        MimeMessageHelper htmlMessage = new MimeMessageHelper(message, true);

        // Set Mail Attributes / Properties:
        htmlMessage.setTo(toMail);
//        htmlMessage.setFrom(from);
        htmlMessage.setFrom("deep041999@gmail.com");
//        htmlMessage.setFrom("deep814187@gmail.com");
        htmlMessage.setSubject(subject);
//        htmlMessage.setSubject("Verify Account");
        htmlMessage.setText(body, true);
        // Send Message:
        sender.send(message);
        System.out.println("Email sent successfully");
    }
    // End Of HTML EMAIL MESSAGE METHOD.
    public static String generateVerificationToken() {
        return UUID.randomUUID().toString();
    }

}
