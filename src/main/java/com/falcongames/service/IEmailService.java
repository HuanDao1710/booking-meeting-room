package com.falcongames.service;

public interface IEmailService {
	
	void sendEmailToResetPassword(String toEmail, String password);
	
	void sendEmailToResetPassword2(String toEmail, String token);

}
