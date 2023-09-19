package com.falcongames.controller.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/api/web-reset-password")
public class ResetPasswordController  extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/reset-password.jsp").forward(request, response);
		
    }
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String token = req.getParameter("token");
		String newPassword = req.getParameter("newPassword");
		
		System.out.println(token);
		System.out.println(newPassword);
	}

}
