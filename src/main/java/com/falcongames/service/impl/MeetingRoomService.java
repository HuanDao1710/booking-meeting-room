package com.falcongames.service.impl;

import java.util.List;
import javax.inject.Inject;
import com.falcongames.dao.IMeetingRoomDAO;
import com.falcongames.model.MeetingRoomModel;
import com.falcongames.service.IMeetingRoomService;

public class MeetingRoomService implements IMeetingRoomService{
	
	@Inject
	IMeetingRoomDAO meetingRoomDAO;
	
	
	
	
	@Override
	public List<MeetingRoomModel> findAll() {
		// TODO Auto-generated method stub
		return meetingRoomDAO.findAll();
	}

}
