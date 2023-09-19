package com.falcongames.dao;

import java.util.List;

import com.falcongames.model.PasswordResetTokensModel;

public interface IPasswordResetTokensDAO extends IGenericDAO<PasswordResetTokensModel> {
	
	List<PasswordResetTokensModel> findAll();
	
	Long save(PasswordResetTokensModel model);
	
	PasswordResetTokensModel findValid(Long userId, String token, String tokenExpiry, String resetTokenUsed);

}
