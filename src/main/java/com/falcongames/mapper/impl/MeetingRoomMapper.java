package com.falcongames.mapper.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.falcongames.mapper.IRowMapper;
import com.falcongames.model.MeetingRoomModel;

public class MeetingRoomMapper implements IRowMapper<MeetingRoomModel> {

	@Override
	public MeetingRoomModel mapRow(ResultSet resultSet) {
		MeetingRoomModel model = new MeetingRoomModel();
		try {
			model.setId(resultSet.getLong("id"));
			model.setRoomName(resultSet.getString("room_name"));
			model.setCapacity(resultSet.getInt("capacity"));
			
			return model;

		} catch (SQLException e) {
			return null;
		}
		
	}

}
