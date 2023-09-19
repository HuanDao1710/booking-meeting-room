package com.falcongames.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.falcongames.constant.SystemConstant;
import com.falcongames.utils.JWTToken;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;

@WebFilter(urlPatterns = { "/api/*" })
public class AuthorizationFilter implements javax.servlet.Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
		System.out.println("Filter Called!");

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("Do filter!");

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		String jwtToken = request.getHeader("Authorization");
	
		
		String uri = request.getRequestURI();
		System.out.println("uri: " + uri);
		

		try {	
			if(jwtToken != null) {

				jwtToken = jwtToken.substring(7);
		
				byte[] secretKeyBytes = SystemConstant.SECRET_KEY.getBytes();

				Claims claims = JWTToken.parseJWT(jwtToken, secretKeyBytes);
				String userId = claims.getSubject();
				String role = (String) claims.get("role");

				// Kiểm tra URI bắt đầu bằng "/admin"
				if (uri.contains("/api/admin")) {
					// Kiểm tra role của người dùng (ADMIN) và cho phép thực hiện các API "/admin"
					if ("ADMIN".equals(role)) {
						// Thực hiện xử lý cho các API bắt đầu bằng "/admin"
						request.setAttribute("userId", userId);
						request.setAttribute("role", role);
						chain.doFilter(request, response);
					} else {
						response.setStatus(HttpServletResponse.SC_FORBIDDEN);
						response.getWriter().write("Authentication error.");
					}
					return;
					
				} 

				// Kiểm tra URI bắt đầu bằng "/user"
				if (uri.contains("/api/user")) {
					// Kiểm tra role của người dùng (USER) và cho phép thực hiện các API "/user"
					if ("USER".equals(role)) {

						request.setAttribute("userId", userId);
						request.setAttribute("role", role);
						// Tiếp tục xử lý các yêu cầu khác
						chain.doFilter(request, response);
					} else {
						response.setStatus(HttpServletResponse.SC_FORBIDDEN);
						response.getWriter().write("Authentication error.");
					}
					return;
				} 
			} else if (uri.contains("/api/web")){
				// Nếu không phải "/admin" hoặc "/user", tiếp tục xử lý các yêu cầu khác
				chain.doFilter(request, response);
				
			} else {
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				response.getWriter().write("Authentication error.");
				
			}

			

		} catch (ExpiredJwtException e) {
			
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.getWriter().write("JWT Token expired.");
		} catch (Exception e) {
			
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			response.getWriter().write("Authentication error.");
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
