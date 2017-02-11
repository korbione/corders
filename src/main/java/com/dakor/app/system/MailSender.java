package com.dakor.app.system;

import org.springframework.stereotype.Service;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * .
 *
 * @author dkor
 */
@Service
public class MailSender {
	private String username;
	private String password;
	private Properties props;

	protected MailSender() {
		this.username = "coorder@ukr.net";
		this.password = "1PfrfP2_dnipro";

		props = new Properties();
		props.put("mail.smtp.host", "smtp.ukr.net");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.startssl.enable", "true");
	}

	public void send( String toEmail, String subject, String text){
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(InternetAddress.parse(username)[0]);
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
			message.setSubject(subject);
			message.setText(text);

			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
