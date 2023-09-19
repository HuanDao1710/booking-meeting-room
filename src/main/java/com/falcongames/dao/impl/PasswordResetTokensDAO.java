package com.falcongames.dao.impl;

import java.util.List;

import com.falcongames.dao.IPasswordResetTokensDAO;
import com.falcongames.mapper.impl.PasswordResetTokensMapper;
import com.falcongames.model.PasswordResetTokensModel;

public class PasswordResetTokensDAO extends BaseDAO<PasswordResetTokensModel> implements IPasswordResetTokensDAO{
	@Override
	public List<PasswordResetTokensModel> findAll() {
		String sql = "SELECT * FROM password_reset_tokens";
		
		return query(sql, new PasswordResetTokensMapper());		
	}
	
	@Override
	public PasswordResetTokensModel findValid(Long userId, String token, String tokenExpiry, String resetTokenUsed) {
		String sql = "SELECT* FROM password_reset_tokens WHERE user_id = ?, token = ?, token_expiry > ?, reset_token_used = ?";
		List<PasswordResetTokensModel> lis = query(sql, new PasswordResetTokensMapper(), userId, token, tokenExpiry, resetTokenUsed);
		return lis.isEmpty() ? null :  lis.get(0);
	}

	@Override
	public Long save(PasswordResetTokensModel model) {
		String sql = "INSERT INTO password_reset_tokens (user_id, token, token_expiry, reset_token_used) VALUES (?, ? , ?, ?)";
		return insert(sql, model.getUserId(), model.getToken(), model.getTokenExpiry(), model.getResetTokenUsed());
	}

}
