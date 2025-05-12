package com.projects.vehicle.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	 @Autowired private JavaMailSender javaMailSender;

    public void sendEmail(String to, String subject, String body) {
    	SimpleMailMessage mailMessage
        = new SimpleMailMessage();
        mailMessage.setFrom("gurum4161@gamil.com");
        mailMessage.setTo(to);
        mailMessage.setText(body);
        mailMessage.setSubject(subject);
        
        javaMailSender.send(mailMessage);
        System.out.println("Email sent successfully!");
    }
}