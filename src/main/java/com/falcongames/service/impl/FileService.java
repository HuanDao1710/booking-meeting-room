package com.falcongames.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.Part;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.falcongames.model.UserModel;
import com.falcongames.service.IFileService;
import com.falcongames.service.IUserService;


public class FileService implements IFileService{
	
	
	@Inject
	private IUserService userService;
	


	
	@Override
	public List<UserModel> importUsers(Part filePart) {
		List<UserModel> listUsers = new ArrayList<>();
		
		try {
			
			InputStream fileInputStream = filePart.getInputStream();
			
			Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);
            
            UserModel userModel = new UserModel();
            
            for(Row row: sheet) {
            	
            	userModel.setUserName(row.getCell(0).getStringCellValue());
            	userModel.setEmail(row.getCell(1).getStringCellValue());
            	userModel.setPassword(row.getCell(2).getStringCellValue());
            	userModel.setRoleId(Double.valueOf((row.getCell(3).getNumericCellValue())).longValue());
            	userModel.setStatus((int)row.getCell(4).getNumericCellValue());
            	
            	
            	listUsers.add(userModel);
            	
            	userService.save(userModel);
            	
            }
            
            workbook.close();
            
            
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}
		
		return listUsers;
		
	}

}
