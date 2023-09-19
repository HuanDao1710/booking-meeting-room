package com.falcongames.model;

public class PasswordResetTokensModel extends BaseModel {
	
	private Long userId;
	
	private String token;
	
	private String tokenExpiry;
	
	private int resetTokenUsed;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTokenExpiry() {
		return tokenExpiry;
	}

	public void setTokenExpiry(String tokenExpiry) {
		this.tokenExpiry = tokenExpiry;
	}

	public int getResetTokenUsed() {
		return resetTokenUsed;
	}

	public void setResetTokenUsed(int resetTokenUsed) {
		this.resetTokenUsed = resetTokenUsed;
	}
	
	

}
