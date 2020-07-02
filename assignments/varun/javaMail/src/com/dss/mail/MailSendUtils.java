package com.dss.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class MailSendUtils {
	
	public void sendMail(String reveiverMailAccount) {
		System.out.println("preparing to send email...");
		Properties properties=new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		String senderMailAccount = "xxxxxxxxxxxx@gmail.com";
		String password = "xxxxxxxxxxxx";
		
		Session session = Session.getDefaultInstance(properties,  
			    new javax.mail.Authenticator() {  
			      protected PasswordAuthentication getPasswordAuthentication() {  
			    return new PasswordAuthentication(senderMailAccount,password);  
			      }  
			    });  
		
		Message message = prepareMessage(session,senderMailAccount,reveiverMailAccount);
		try {
			Transport.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		  
	     System.out.println("message sent successfully...");  
		
	}

	private Message prepareMessage(Session session, String senderMailAccount, String reveiverMailAccount) {
		 try {  
				 Message message = new MimeMessage(session);  
			     message.setFrom(new InternetAddress(senderMailAccount));  
			     message.addRecipient(Message.RecipientType.TO,new InternetAddress(reveiverMailAccount));  
			     message.setSubject("Welcome");  
			     message.setText("Hi, Glad to welcome");  
			     return message;
		     } 
		 catch (MessagingException e) {
			 e.printStackTrace();
		 }
		 return null;
	}
	
}
