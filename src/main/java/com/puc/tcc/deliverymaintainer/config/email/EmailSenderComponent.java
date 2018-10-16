package com.puc.tcc.deliverymaintainer.config.email;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.puc.tcc.deliverymaintainer.enums.StatusDaEntrega;

@Component
public class EmailSenderComponent {

	private JavaMailSender javaMailSender;

	@Autowired
	public EmailSenderComponent(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public EmailSenderComponent() {
		// TODO Auto-generated constructor stub
	}

	public void emailDeEntrega(String nomeDoCliente, String emailCliente, StatusDaEntrega statusDaEntrega) {
		StringBuilder titulo = new StringBuilder();

		titulo.append("Sua encomenda foi atualizada, veja mais detalhes");

		Email email = Email.builder().remetente("mailtestmatheus@gmail.com").destinatario(emailCliente)
				.titulo(titulo.toString()).nomeUsuario(nomeDoCliente).build();

		try {
			javaMailSender.send(emailToSimpleMailMessage(email, statusDaEntrega.name()));
		} catch (Exception e) {
			System.out.println("Error file email");
		}
	}

	private MimeMessage emailToSimpleMailMessage(Email email, String statusDaEntrega) throws MessagingException, IOException {

		MimeMessage message = javaMailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setSubject(email.getTitulo());
		helper.setTo(email.getDestinatario());
		helper.setFrom(email.getRemetente());

		String contentFile = readEmail("statusDeEntrega.html");
		contentFile = contentFile.replace("**usuario**", email.getNomeUsuario());
		contentFile = contentFile.replace("**status**", statusDaEntrega);

		helper.setText(contentFile, true);

		return message;
	}

	public String readEmail(String name) {
		try {
			String fileName = "email/" + name;
			ClassLoader classLoader = new EmailSenderComponent().getClass().getClassLoader();
			File file = new File(classLoader.getResource(fileName).getFile());
			return new String(Files.readAllBytes(file.toPath()));
		} catch (IOException e) {
			System.out.println("Error file email");
			return null;
		}
	}

}
