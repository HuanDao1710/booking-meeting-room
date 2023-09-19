package com.falcongames.dao;

import java.util.List;


import com.falcongames.model.MeetingRoomModel;


public interface IMeetingRoomDAO extends IGenericDAO<MeetingRoomModel>{
	
	List<MeetingRoomModel> findAll();
	

}
