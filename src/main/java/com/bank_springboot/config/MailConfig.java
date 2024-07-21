package com.bank_springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

public class MailConfig {

    @Bean
    public static JavaMailSenderImpl getMailConfig(){
        JavaMailSenderImpl emailConfig = new JavaMailSenderImpl();

        // Set Properties:
        Properties props = emailConfig.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        // Set Mail Credentials:
        emailConfig.setHost("smtp.gmail.com");
        emailConfig.setPort(587);
//        emailConfig.setUsername("no-reply@somecompany.com");
//        emailConfig.setPassword("password123");
        emailConfig.setUsername("deep041999@gmail.com");
        emailConfig.setPassword("omkrydlcovltlcay");
        // Go to google account -> security -> 2-Step Verification -> App passwords -> Write App name and create -> Automatically generate password
        return emailConfig;
    }
    // End Of Email Config Method.
}
