package com.falcongames.dao.impl;

import java.util.List;

import com.falcongames.dao.IMeetingRoomDAO;
import com.falcongames.mapper.impl.MeetingRoomMapper;
import com.falcongames.model.MeetingRoomModel;


public class MeetingRoomDAO extends BaseDAO<MeetingRoomModel> implements IMeetingRoomDAO {
	
	@Override
	public List<MeetingRoomModel> findAll() {
		
		String sql = "SELECT * FROM meeting_room";
		
		return query(sql, new MeetingRoomMapper());		
	}

}
