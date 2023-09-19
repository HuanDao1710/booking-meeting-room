package com.falcongames.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.falcongames.constant.SystemConstant;
import com.falcongames.model.UserModel;
import com.falcongames.service.IUserService;
import com.falcongames.utils.HttpUtils;
import com.falcongames.utils.JWTToken;

@WebServlet(value = "/api/web-login")
public class HomeController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4143292401814647950L;



	@Inject
	private IUserService userService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//if (action != null && action.equals("login")) {
			UserModel model = HttpUtils.of(req.getReader()).toModel(UserModel.class);
			

			model = userService.login(model.getEmail(), model.getPassword(), 1);
			
			System.out.println("model : " + model);

			//SessionUtils.getInstance().putValues(req, "USERMODEL", model);

			if (model != null) {
				byte[] secretKeyBytes = SystemConstant.SECRET_KEY.getBytes();
				String jwtToken = JWTToken.createJWT(model.getEmail(), model.getRole().getCode(), secretKeyBytes);
				System.out.println("jwt token :" + jwtToken);
	            resp.addHeader("Authorization", jwtToken);
	            System.out.println("đã gửi token thành công");
	            resp.setStatus(HttpServletResponse.SC_OK);
				
			} else {
				System.out.println("Incorrect account or password!");
			}

		//}
	}

}
