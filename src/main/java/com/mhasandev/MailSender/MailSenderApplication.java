package com.mhasandev.MailSender;

import com.mhasandev.MailSender.services.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class MailSenderApplication {
	@Autowired
	private EmailSender emailSender;

	public static void main(String[] args) {
		SpringApplication.run(MailSenderApplication.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail(){
			emailSender.sendMail("mhshafin220@gmail.com",
					"This is a Test for my developing mail sending service",
					"test");
		}
}
