package com.falcongames.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.falcongames.model.UserModel;
import com.falcongames.service.IEmailService;
import com.falcongames.service.IUserService;
import com.falcongames.utils.HttpUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/api/admin-user")
public class UserAPI extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8580251439145681830L;
	
	
	@Inject
	private IUserService userService;
	
	@Inject
	private IEmailService emailService;
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// json to object
		UserModel userModel = HttpUtils.of(req.getReader()).toModel(UserModel.class);
		
		userModel = userService.save(userModel);
				
		ObjectMapper mapper = new ObjectMapper();
		
		mapper.writeValue(resp.getOutputStream(), userModel);
	}
	
	
	
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserModel userModel = HttpUtils.of(req.getReader()).toModel(UserModel.class);
		
		userModel = userService.update(userModel);
		
//		System.out.println(userModel);
		
		if(userModel != null) {
			emailService.sendEmailToResetPassword(userModel.getEmail(), userModel.getPassword());
		}
		
		ObjectMapper mapper = new ObjectMapper();
		
		mapper.writeValue(resp.getOutputStream(), userModel);
	}
	
	


}
