package com.falcongames.controller.user.api;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.falcongames.model.MeetingRoomModel;
import com.falcongames.service.IMeetingRoomService;
import com.fasterxml.jackson.databind.ObjectMapper;



@WebServlet("/api/user-meetingroom")
public class MeetingRoomAPI extends HttpServlet{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1707387827658181727L;
	
	@Inject
	private IMeetingRoomService meetingRoomService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<MeetingRoomModel> meetingRoomModels = meetingRoomService.findAll();
		
		ObjectMapper mapper = new ObjectMapper();
		
		mapper.writeValue(resp.getOutputStream(), meetingRoomModels);
		
	}

}
