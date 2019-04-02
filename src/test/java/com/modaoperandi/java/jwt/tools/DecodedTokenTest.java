package com.modaoperandi.java.jwt.tools;

import org.junit.Test;
import static org.junit.Assert.*;

public class DecodedTokenTest {
	
	private String token1 = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwczovL3Blcm1zLm1vZGEuY29tL2dyb3VwcyI6WyJBZG1pbnMiXSwiaHR0cHM6Ly9wZXJtcy5tb2RhLmNvbS9yb2xlcyI6WyJBZG1pbiJdLCJodHRwczovL3Blcm1zLm1vZGEuY29tL3Blcm1pc3Npb25zIjpbInJlYWQ6cGFja2V0cyIsImNyZWF0ZTpwYWNrZXRzIiwidXBkYXRlOnBhY2tldHMiLCJkZWxldGU6cGFja2V0cyJdLCJpYXQiOjE1NTM4MDA3NDcsImV4cCI6MTU1MzgwNzk0Nywic2NvcGUiOiJyZWFkOnBhY2tldHMgY3JlYXRlOnBhY2tldHMgdXBkYXRlOnBhY2tldHMgZGVsZXRlOnBhY2tldHMifQ.2zRpv1RHlYYfOY51hDmUlHyox6noxay-YjLYGDtZp_k"; 
	private String token2 = "";
	private String token3 = null;
	
	DecodedToken decodedToken1 = new DecodedToken(token1);
	DecodedToken decodedToken2 = new DecodedToken(token2);
	DecodedToken decodedToken3 = new DecodedToken(token3);
	
	@Test
	public void getToken() throws Exception {
		assertEquals(token1, decodedToken1.getToken());
		assertEquals(token2, decodedToken2.getToken());
		assertEquals(token3, decodedToken3.getToken());
	}
	
	@Test
	public void getScopes() throws Exception {
		assertEquals("read:packets create:packets update:packets delete:packets", decodedToken1.getScopes());
		assertEquals(null, decodedToken2.getScopes());
		assertEquals(null, decodedToken3.getScopes());
	}
	
	@Test
	public void getGroups() throws Exception {
		assertEquals("Admins", arrayToString(decodedToken1.getGroups()));
		assertNull(decodedToken2.getGroups());
		assertNull(decodedToken3.getGroups());
	}
	
	@Test
	public void getRoles() throws Exception {
		assertEquals("Admin", arrayToString(decodedToken1.getRoles()));
		assertNull(decodedToken2.getRoles());
		assertNull(decodedToken3.getRoles());
	}
	
	@Test
	public void getPermissions() throws Exception {
		assertEquals("read:packets create:packets update:packets delete:packets", arrayToString(decodedToken1.getPermissions()));
		assertNull(decodedToken2.getPermissions());
		assertNull(decodedToken3.getPermissions());
	}
	
	private String arrayToString(String[] array) {
		StringBuilder sb = new StringBuilder();
		for (String str : array) {
			sb.append(str).append(" ");
		}
		return sb.toString().trim();
	}
}

