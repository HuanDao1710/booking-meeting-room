package com.falcongames.mapper.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.falcongames.mapper.IRowMapper;
import com.falcongames.model.RoleModel;
import com.falcongames.model.UserModel;

public class UserMapper implements IRowMapper<UserModel>{

	@Override
	public UserModel mapRow(ResultSet resultSet) {
		
		try {
			UserModel model = new UserModel();
			
			model.setId(resultSet.getLong("id"));
			model.setUserName(resultSet.getString("user_name"));
			model.setEmail(resultSet.getString("email"));
			model.setPassword(resultSet.getString("password"));
			model.setRoleId(resultSet.getLong("role_id"));
			model.setStatus(resultSet.getInt("status"));
			
			try {
				RoleModel role = new RoleModel();
				role.setCode(resultSet.getString("code"));
				role.setName(resultSet.getString("name"));			
				model.setRole(role);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			
			return model;

		} catch (SQLException e) {
			return null;
		}
	}

}
