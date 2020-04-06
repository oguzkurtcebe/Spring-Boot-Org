package com.oguzkurtcebe.organization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.oguzkurtcebe.organization.web.HomeController;

@Service
public class MailService  {

	@Autowired
	private JavaMailSender mailSender;

	public void mailSenderFunction(String email, String key) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom("aktivasyonhesabi1234@gmail.com");
		msg.setTo(email);
		msg.setSubject("Uyeligi tamamla");
		msg.setText("uyeligi tamamlamak icin asagidaki linke tiklayiniz.\n\n" + HomeController.url + "/reg/" + key);
		mailSender.send(msg);
	}

}
