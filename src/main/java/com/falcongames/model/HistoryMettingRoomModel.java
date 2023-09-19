package com.falcongames.model;

public class HistoryMettingRoomModel extends BaseModel{
	
	private Long meetingId;
	private Long newRoomId;
	private Long oldRoomId;
	
	
	
	public Long getMeetingId() {
		return meetingId;
	}
	public void setMeetingId(Long meetingId) {
		this.meetingId = meetingId;
	}
	public Long getNewRoomId() {
		return newRoomId;
	}
	public void setNewRoomId(Long newRoomId) {
		this.newRoomId = newRoomId;
	}
	public Long getOldRoomId() {
		return oldRoomId;
	}
	public void setOldRoomId(Long oldRoomId) {
		this.oldRoomId = oldRoomId;
	}

	

}
