package com.modaoperandi.java.jwt.tools;

import javax.servlet.http.HttpServletRequest;

public class Verifier {
	
	private String accessToken;
	
	public String getAccessToken(HttpServletRequest request) {
		String header = request.getHeader("Authorization");
		System.out.println("-------------TOKEN-------------" + header + "-------------TOKEN-------------");
		this.accessToken = header != null ? header.substring(7) : ""; 
		return this.accessToken;
	}
	
	public void verifyAccessToken() {

	}
}
