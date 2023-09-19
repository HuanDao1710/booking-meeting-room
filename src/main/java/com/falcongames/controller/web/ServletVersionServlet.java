package com.falcongames.controller.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/api/servlet-version")
public class ServletVersionServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        String servletVersion = servletContext.getMajorVersion() + "." + servletContext.getMinorVersion();
        
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println("Current Servlet Version: " + servletVersion);
    }
}
