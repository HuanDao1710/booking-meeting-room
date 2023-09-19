package com.falcongames.service;

import java.util.List;
import javax.servlet.http.Part;
import com.falcongames.model.UserModel;

public interface IFileService {
	
	List<UserModel> importUsers(Part filePart);

}
