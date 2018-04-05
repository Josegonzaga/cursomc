package com.eclodir.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.eclodir.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	
}
