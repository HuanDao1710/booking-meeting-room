package com.falcongames.utils;

import javax.servlet.http.HttpServletRequest;

public class SessionUtils {
	
	private SessionUtils() {
		
	}
	
	private static SessionUtils sessionUtils = null;
	
	public static SessionUtils getInstance() {
		if(!(sessionUtils instanceof SessionUtils)) {
			sessionUtils = new SessionUtils();
		}
		
		return sessionUtils;
	}
	
	public void putValues(HttpServletRequest request, String key, Object value) {
		request.getSession().setAttribute(key, value);
		
	}
	
	public Object getValues(HttpServletRequest request, String key) {
		return request.getSession().getAttribute(key);
		
	}
	
	public void removeValues(HttpServletRequest request, String key) {
		request.getSession().removeAttribute(key);
		
	}

}
