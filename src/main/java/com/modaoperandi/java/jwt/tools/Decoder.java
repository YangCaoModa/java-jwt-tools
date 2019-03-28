package com.modaoperandi.java.jwt.tools;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class Decoder {
	
	private static final String namespace = "https://perms.moda.com/";
	private static String scopes = null;
	private static String[] groups = null;
	private static String[] roles = null;
	private static String[] permissions = null;
	
	public final void decode(String accessToken) {

    	try {
    	    DecodedJWT jwt = JWT.decode(accessToken);
    	    scopes = jwt.getClaim("scope").asString();
    	    groups = jwt.getClaim(namespace + "groups").asArray(String.class);
    	    roles = jwt.getClaim(namespace + "roles").asArray(String.class);
    	    permissions = jwt.getClaim(namespace + "permissions").asArray(String.class);
    	    
    	} catch (JWTDecodeException exception){
    		System.out.println("Invalid token.");
    	}
	}
	
	public void printUserInfo() {
	    // Print out Scopes, Groups, Roles, and Permissions  
	    System.out.println("Scopes: " + scopes);
	    
	    StringBuilder sb = new StringBuilder();
	    for (String str : groups) {
	    	sb.append(str).append(" ");
	    }
	    System.out.println("Groups: " + sb.toString());
	    
	    sb = new StringBuilder();
	    for (String str : roles) {
	    	sb.append(str).append(" ");
	    }
	    System.out.println("Roles: " + sb.toString());
	    
	    sb = new StringBuilder();
	    for (String str : permissions) {
	    	sb.append(str).append(" ");
	    }
	    System.out.println("Permissions: " + sb.toString());
	}
	
	public String getScopes() {
		return scopes;
	}
	
	public String[] getGroups() {
		return groups;
	}
	
	public String[] getRoles() {
		return roles;
	}

	public String[] getPermissions() {
		return permissions;
	}
}
