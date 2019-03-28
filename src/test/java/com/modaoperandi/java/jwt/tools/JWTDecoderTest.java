package com.modaoperandi.java.jwt.tools;

import org.junit.Test;
import static org.junit.Assert.*;

public class JWTDecoderTest {
	
	private static String token1 = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwczovL3Blcm1zLm1vZGEuY29tL2dyb3VwcyI6WyJBZG1pbnMiLCJCdXllcnMiXSwiaHR0cHM6Ly9wZXJtcy5tb2RhLmNvbS9yb2xlcyI6WyJBZG1pbiIsIkJ1eWVyIl0sImh0dHBzOi8vcGVybXMubW9kYS5jb20vcGVybWlzc2lvbnMiOlsicmVhZDpwYWNrZXRzIiwiY3JlYXRlOnBhY2tldHMiLCJ1cGRhdGU6cGFja2V0cyIsImRlbGV0ZTpwYWNrZXRzIl0sImlzcyI6Imh0dHBzOi8vbW9kYW9wZXJhbmRpLmF1dGgwLmNvbS8iLCJzdWIiOiJhdXRoMHw1YzdlZjNlNDNmODUxYzE4ZTNkZWQ1MWQiLCJhdWQiOiJodHRwczovL3JvdWdlLm1vZGFhcHBzLmNvbS9hcGkiLCJpYXQiOjE1NTM4MDA3NDcsImV4cCI6MTU1MzgwNzk0NywiYXpwIjoiWFdCSndmVVdPdjNoRlU0YjdoeXpqbFYzclBuNGhzWmEiLCJzY29wZSI6InJlYWQ6cGFja2V0cyBjcmVhdGU6cGFja2V0cyB1cGRhdGU6cGFja2V0cyBkZWxldGU6cGFja2V0cyJ9.ni3ea7ZXKbSitb1hO-sYEjhDh48WghB-pRM1uj764kA"; 
	private static String token2 = "";
	private static String token3 = null;
	
	@Test
	public void getScopes() throws Exception {
		JWTDecoder decoder = new JWTDecoder();
		assertEquals("read:packets create:packets update:packets delete:packets", decoder.getScopes(token1));
		assertEquals("", decoder.getScopes(token2));
		assertEquals("", decoder.getScopes(token3));
	}
	
	@Test
	public void getGroups() throws Exception {
		JWTDecoder decoder = new JWTDecoder();
		assertEquals("Admins Buyers ", decoder.getGroups(token1));
		assertEquals("", decoder.getGroups(token2));
		assertEquals("", decoder.getGroups(token3));
	}
	
	@Test
	public void getRoles() throws Exception {
		JWTDecoder decoder = new JWTDecoder();
		assertEquals("Admin Buyer ", decoder.getRoles(token1));
		assertEquals("", decoder.getRoles(token2));
		assertEquals("", decoder.getRoles(token3));
	}
	
	@Test
	public void getPermissions() throws Exception {
		JWTDecoder decoder = new JWTDecoder();
		assertEquals("read:packets create:packets update:packets delete:packets ", decoder.getPermissions(token1));
		assertEquals("", decoder.getPermissions(token2));
		assertEquals("", decoder.getPermissions(token3));
	}
}
