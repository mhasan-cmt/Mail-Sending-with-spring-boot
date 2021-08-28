package com.mhasandev.MailSender.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

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
    public void sendMailWithAttachments(String toEmail,
                                        String body,
                                        String subject,
                                        String attachment) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper =
                new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom("mhshafin220@gmail.com");
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(body);

        //Adding the attachments
        FileSystemResource resource=
                new FileSystemResource(new File(attachment));

        mimeMessageHelper.addAttachment(resource.getFilename(),
                resource);
    //Sending the mail with attachments
        mailSender.send(mimeMessage);
        System.out.printf("Mail sent with attachments...!");

    }
}
