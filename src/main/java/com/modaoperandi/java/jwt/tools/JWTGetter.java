package com.modaoperandi.java.jwt.tools;

import javax.servlet.http.HttpServletRequest;

public class JWTGetter {
	
	private String accessToken;
	
	public void helper(HttpServletRequest request) {
		try {
			String header = request.getHeader("Authorization");
			System.out.println("-------------ACCESS TOKEN-------------");
			System.out.println(header);
			System.out.println("-------------ACCESS TOKEN-------------");
			this.accessToken = header != null ? header.substring(7) : ""; 
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public String getAccessToken(HttpServletRequest request) {
		helper(request);
		return this.accessToken;
	}
}
