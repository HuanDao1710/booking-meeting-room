package com.falcongames.service;

import com.falcongames.model.UserModel;

public interface IUserService {
	
	UserModel save(UserModel userModel);
	
	UserModel update(UserModel updateUser);
	
	UserModel login(String userName, String password, int status);
	
	
	
}
