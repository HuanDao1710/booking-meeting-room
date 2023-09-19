package com.falcongames.utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtils {
	
	private String value;
	
	private HttpUtils(String value) {
		this.value = value;
		
	}
	
	public <T> T toModel(Class<T> tClass) throws JsonParseException, JsonMappingException, IOException {
		return new ObjectMapper().readValue(value, tClass);		
	}
	
	public static HttpUtils of (BufferedReader reader) {
		StringBuilder sb = new StringBuilder();
		
		String line;
		
		try {
			while((line = reader.readLine()) != null) {
				sb.append(line);
				
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		return new HttpUtils(sb.toString());
	}



}
