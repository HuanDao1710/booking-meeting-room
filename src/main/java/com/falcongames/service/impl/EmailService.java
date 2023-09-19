package com.falcongames.service.impl;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.falcongames.service.IEmailService;

public class EmailService implements IEmailService {
	
	@Override
	public void sendEmailToResetPassword(String toEmail, String newPassword) {
		//  cấu hình email 
        String from = "huanruaxz@gmail.com"; // Email nguồn
        String password = "gmxdlzhuoenlbtei"; // Mật khẩu ứng dụng
        //String to = "huan.dq171001@gmail.com"; // Email đích
        String subject = "Reset Password";
        String body = "<h1 style=\"color: #007BFF;\">Book Meeting Room</h1>" +
                "<p style=\"font-size: 18px;\">Your new password is: <strong> " +newPassword + "</strong></p>";

        // Cấu hình thông tin SMTP
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        // Xác thực bằng mật khẩu ứng dụng
        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
          });

        try {
        	Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
        	
        	// Thiết lập định dạng email
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(body, "text/html; charset=utf-8");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);

            // Gửi email
            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
				
	}
	
	@Override
	public void sendEmailToResetPassword2(String toEmail, String token) {
	//  cấu hình email 
        String from = "huanruaxz@gmail.com"; // Email nguồn
        String password = "gmxdlzhuoenlbtei"; // Mật khẩu ứng dụng
        
        String resetLink = "http://localhost:8080/book-meeting-room-update2/api/web-reset-password?token=" + token;
        //String to = "huan.dq171001@gmail.com"; // Email đích
        String subject = "Reset Password";
        String body = "<h1 style=\"color: #007BFF;\">Reset Password</h1>" +
                "<p style=\"font-size: 18px;\">Click the link below to reset your password:</p>" +
                "<a href=\"" + resetLink + "\">Reset Password</a>";
        // Cấu hình thông tin SMTP
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        // Xác thực bằng mật khẩu ứng dụng
        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
          });

        try {
        	Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
        	
        	// Thiết lập định dạng email
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(body, "text/html; charset=utf-8");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);

            // Gửi email
            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

	}

}
