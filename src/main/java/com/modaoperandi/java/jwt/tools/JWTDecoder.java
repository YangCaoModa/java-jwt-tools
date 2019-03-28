package com.modaoperandi.java.jwt.tools;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTDecoder {
	
	private static final String namespace = "https://perms.moda.com/";
	private String scopes;
	private String groups;
	private String roles;
	private String permissions;
	
	public void decodeClaims(String accessToken) {
    	try {
    	    DecodedJWT jwt = JWT.decode(accessToken);
    	    this.scopes = jwt.getClaim("scope").asString();
    	    this.groups = arrayToString(jwt.getClaim(namespace + "groups").asArray(String.class));
    	    this.roles = arrayToString(jwt.getClaim(namespace + "roles").asArray(String.class));
    	    this.permissions = arrayToString(jwt.getClaim(namespace + "permissions").asArray(String.class));	    
    	} catch (JWTDecodeException exception){
    		System.out.println("Invalid token.");
    	}
	}
	
	private String arrayToString(String[] array) {
	    StringBuilder sb = new StringBuilder();
	    for (String str : array) {
	    	sb.append(str).append(" ");
	    }
	    return sb.toString();
	}
	
	private void initUserInfo() {
		this.scopes = "";
		this.groups = "";
		this.roles = "";
		this.permissions = "";
	}
	
	public void getUserInfo(String accessToken) {
		initUserInfo();
		try {
			decodeClaims(accessToken);
		    // Print out Scopes, Groups, Roles, and Permissions  
		    System.out.println("Scopes: " + this.scopes);
		    System.out.println("Groups: " + this.groups);
		    System.out.println("Roles: " + this.roles);
		    System.out.println("Permissions: " + this.permissions);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}
	
	public String getScopes(String accessToken) {
		initUserInfo();
		try {
			decodeClaims(accessToken);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println("Scopes: " + this.scopes);
		return this.scopes;
	}
	
	public String getGroups(String accessToken) {
		initUserInfo();
		try {
			decodeClaims(accessToken);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println("Groups: " + this.groups);
		return this.groups;
	}
	
	public String getRoles(String accessToken) {
		initUserInfo();
		try {
			decodeClaims(accessToken);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println("Roles: " + this.roles);
		return this.roles;
	}

	public String getPermissions(String accessToken) {
		initUserInfo();
		try {
			decodeClaims(accessToken);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println("Permissions: " + this.permissions);
		return this.permissions;
	}
}
