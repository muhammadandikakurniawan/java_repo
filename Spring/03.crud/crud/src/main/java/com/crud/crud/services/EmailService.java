package com.crud.crud.services;
import javax.mail.*;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender sender;
	public void sendEmail(String rec, String body, String sub) throws MailException {
 
        // Enable the multipart flag!
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("muhammadandikakurniawan24@gmail.com");
        mailMessage.setFrom("awan.fdn@gmail.com");
        mailMessage.setText("hai");
        mailMessage.setSubject("awan fdn");
        
        this.sender.send(mailMessage);
    }		
}
