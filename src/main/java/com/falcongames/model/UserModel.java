package com.falcongames.model;



public class UserModel extends BaseModel{
	
	private String email;
	
	private String password;
	
	private int status;
	
	private String userName;
	
	private Long roleId;
	
	private RoleModel role = new RoleModel();
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public RoleModel getRole() {
		return role;
	}

	public void setRole(RoleModel role) {
		this.role = role;
	}


}
