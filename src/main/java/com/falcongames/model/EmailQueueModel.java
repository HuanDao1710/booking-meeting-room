package com.falcongames.model;

import java.sql.Timestamp;

public class EmailQueueModel extends BaseModel {
	
	private Long userId;
	
	private String recipentEmail;
	
	private String subject;
	
	private String content;
	
	private String status; // đã gửi, đang gửi, chưa gửi
	
	private Timestamp sendAt;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getRecipentEmail() {
		return recipentEmail;
	}

	public void setRecipentEmail(String recipentEmail) {
		this.recipentEmail = recipentEmail;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getSendAt() {
		return sendAt;
	}

	public void setSendAt(Timestamp sendAt) {
		this.sendAt = sendAt;
	}
	
	

}
