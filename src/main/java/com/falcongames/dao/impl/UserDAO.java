package com.falcongames.dao.impl;


import java.util.List;

import com.falcongames.dao.IUserDAO;
import com.falcongames.mapper.impl.UserMapper;
import com.falcongames.model.UserModel;


public class UserDAO extends BaseDAO<UserModel>implements IUserDAO{
	

	@Override
	public Long save(UserModel userModel) {
		String sql = "INSERT INTO user (email, password, role_id, user_name, status) VALUES (?, ? , ?, ?, ?)";
		return insert(sql, userModel.getEmail(), userModel.getPassword(), userModel.getRoleId(), userModel.getUserName(), userModel.getStatus());
	}

	@Override
	public UserModel findOne(Long id) {
		String sql = "SELECT * FROM user WHERE id = ?";
		List<UserModel> users = query(sql, new UserMapper(), id);
		return users.isEmpty() ? null :  users.get(0);
	}
	
	@Override
	public void update(UserModel userModel) { 
		String sql = "UPDATE user SET password = ? where id = ?";
		
		
		update(sql.toString(), userModel.getPassword(), userModel.getId());
	}
	

	@Override
	public UserModel findByUserNameAndPassword(String email, String password, int status) {
		String sql = "SELECT * FROM user INNER JOIN role ON user.role_id = role.id "
				+ "WHERE email = ? AND password = ? AND status = ?";
		
		List<UserModel> users = query(sql, new UserMapper(), email, password, status);
		return users.isEmpty() ? null :  users.get(0);
	}
	
	@Override
	public UserModel findByEmail(String email) {
		String sql = "SELECT * FROM user WHERE email = ?";
		
		List<UserModel> users = query(sql, new UserMapper(), email);
		return users.isEmpty() ? null :  users.get(0);
	}

	

}
