package com.modaoperandi.java.jwt.tools;

import org.junit.Test;
import static org.junit.Assert.*;

public class JWTGetterTest {
	
	@Test
	public void getAccessToken() throws Exception {
		JWTGetter jwtGetter = new JWTGetter();
		assertNull(jwtGetter.getAccessToken(null));
	}

}
