package com.falcongames.controller.admin.api;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.falcongames.model.UserModel;
import com.falcongames.service.IFileService;
import com.fasterxml.jackson.databind.ObjectMapper;



@WebServlet("/api/admin-import-user")
@MultipartConfig
public class ListUserAPI extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	IFileService fileService;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		Part filePart = req.getPart("file");
		
		
		List<UserModel> listUser = fileService.importUsers(filePart);
		
		ObjectMapper mapper = new ObjectMapper();
		
		mapper.writeValue(resp.getOutputStream(), listUser);
        
        
	}
	
	
	
	
	

}
