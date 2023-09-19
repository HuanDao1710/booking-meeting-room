package com.falcongames.service.impl;

import javax.inject.Inject;

import com.falcongames.dao.IUserDAO;
import com.falcongames.model.UserModel;
import com.falcongames.service.IUserService;

public class UserService implements IUserService {

	@Inject
	private IUserDAO userDAO;

	@Override
	public UserModel save(UserModel userModel) {
		Long user_id = userDAO.save(userModel);
		return userDAO.findOne(user_id);
	}

	@Override
	public UserModel update(UserModel updateUser) {

		try {
			UserModel old = userDAO.findOne(updateUser.getId());
			updateUser.setCreateBy(old.getCreateBy());
			updateUser.setCreateDate(old.getCreateDate());
			userDAO.update(updateUser);
			return userDAO.findOne(updateUser.getId());

		} catch (Exception e) {
			return null;
		}

	}
	
	@Override
	public UserModel login(String email, String password, int status) {

		return userDAO.findByUserNameAndPassword(email, password, status);
	}

}
