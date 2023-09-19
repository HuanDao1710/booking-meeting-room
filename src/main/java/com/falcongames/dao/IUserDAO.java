package com.falcongames.dao;


import com.falcongames.model.UserModel;

public interface IUserDAO {
	

	Long save(UserModel userModel);
	
	UserModel findOne(Long id);
	
	void update(UserModel userModel);
	
	UserModel findByUserNameAndPassword(String username, String password, int status);
	
	UserModel findByEmail(String email);
	
	
	
	

}
