package com.modaoperandi.java.jwt.tools;

import javax.servlet.http.HttpServletRequest;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class DecodedToken {

	private static final String namespace = "https://perms.moda.com/";
	private String authToken; 
	private String scopes;
//	private String groups;
//	private String roles;
//  private String permissions;
	private String[] groups;
	private String[] roles;
    private String[] permissions;
    
    public DecodedToken() {
    	this.authToken = null;
    	this.scopes = null;
    	this.groups = null;
    	this.roles = null;
    	this.permissions = null;
    }
    
    public DecodedToken(HttpServletRequest request) {
    	helper(request);
    	decodeClaims(this.authToken);
    }
    
    public DecodedToken(String token) {
    	this.authToken = token;
    	decodeClaims(token);
    }
    
	public String getToken() {
		return this.authToken;
	}
	
	public String getScopes() {
		return this.scopes;
	}
	
	public String[] getGroups() {
		return this.groups;
	}
	
	public String[] getRoles() {
		return this.roles;
	}

	public String[] getPermissions() {
		return this.permissions;
	}
	
	public void printToken() {
		System.out.println("-------------ACCESS TOKEN-------------");
		System.out.println(this.authToken);
		System.out.println("-------------ACCESS TOKEN-------------");
	}
	
	public void printScopes() {
		System.out.println("Scopes: " + this.scopes);
	}
	
	public void printGroups() {
	    StringBuilder sb = new StringBuilder();
	    for (String str : this.groups) {
	    	sb.append(str).append(" ");
	    }
	    System.out.println("Groups: " + sb.toString());
	}
	
	public void printRoles() {
		StringBuilder sb = new StringBuilder();
	    for (String str : this.roles) {
	    	sb.append(str).append(" ");
	    }
	    System.out.println("Roles: " + sb.toString());
	}
	
	public void printPermissions() {
		StringBuilder sb = new StringBuilder();
	    for (String str : this.permissions) {
	    	sb.append(str).append(" ");
	    }
	    System.out.println("Permissions: " + sb.toString());
	}
	
	public void printUserInfo() {
		try {
		    // Print out Scopes, Groups, Roles, and Permissions  			
//		    System.out.println("Scopes: " + this.scopes);
//		    System.out.println("Groups: " + this.groups);
//		    System.out.println("Roles: " + this.roles);
//		    System.out.println("Permissions: " + this.permissions);
		    printScopes();
		    printGroups();
		    printRoles();
		    printPermissions();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	private void helper(HttpServletRequest request) {
		try {
			String header = request.getHeader("Authorization");
			this.authToken = header != null ? header.substring(7) : null; 
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	private void decodeClaims(String token) {
		if (token == null) {
			System.out.println("Token is null.");
			return;
		}
		
    	try {
    	    DecodedJWT jwt = JWT.decode(token);
    	    this.scopes = jwt.getClaim("scope").asString();
    	    this.groups = jwt.getClaim(namespace + "groups").asArray(String.class);
    	    this.roles = jwt.getClaim(namespace + "roles").asArray(String.class);
    	    this.permissions = jwt.getClaim(namespace + "permissions").asArray(String.class);	    
    	} catch (JWTDecodeException exception){
    		System.out.println("Invalid token.");
    	}
	}
	
	private String arrayToString(String[] array) {
	    StringBuilder sb = new StringBuilder();
	    for (String str : array) {
	    	sb.append(str).append(" ");
	    }
	    return sb.toString().trim();
	}
}
