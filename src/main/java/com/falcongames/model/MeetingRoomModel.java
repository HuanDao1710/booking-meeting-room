package com.falcongames.model;

public class MeetingRoomModel extends BaseModel {
	private String roomName;
	
	private int capacity;

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	

}
