package com.mhasandev.MailSender.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSender {
    //Instantiating the java mail object
    @Autowired
    JavaMailSender mailSender;

    public void sendMail(String toEmail,
                         String body,
                         String subject){

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        message.setFrom("mhshafin220@gmail.com");
        mailSender.send(message);
        System.out.printf("Mail sent....!");
    }
}
