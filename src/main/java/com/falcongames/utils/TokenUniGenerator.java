package com.falcongames.utils;

import java.util.UUID;

public class TokenUniGenerator {
	
	public static String generateToken() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	

}
