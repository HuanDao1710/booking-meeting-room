package com.falcongames.mapper.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.falcongames.mapper.IRowMapper;
import com.falcongames.model.PasswordResetTokensModel;

public class PasswordResetTokensMapper implements IRowMapper<PasswordResetTokensModel>{
	
	@Override
	public PasswordResetTokensModel mapRow(ResultSet resultSet) {
		PasswordResetTokensModel model = new PasswordResetTokensModel();
		try {
			model.setId(resultSet.getLong("id"));
			model.setUserId(resultSet.getLong("user_id"));
			model.setToken(resultSet.getString("token"));
			model.setTokenExpiry(resultSet.getString("token_expiry"));
			model.setResetTokenUsed(resultSet.getInt("reset_token_used"));
			
			
			return model;

		} catch (SQLException e) {
			return null;
		}
	}

}
