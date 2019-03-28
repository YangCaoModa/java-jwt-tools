# java-jwt-tools

This is a library used to get access token(JWT) from your front end, decode it, and get user's Scopes, Groups, Roles, and Permissions information.

To install the library, please add dependencies to your build file:

	repositories { 
        maven { url 'https://jitpack.io' }
    }

    dependencies {
        compile 'com.github.YangCaoModa:java-jwt-tools:v0.1.1'
    }


To use JWTDecoder and JWTGetter in your controllers, please add these packages:

	import com.modaoperandi.java.jwt.tools.JWTGetter;
	import com.modaoperandi.java.jwt.tools.JWTDecoder;

	@Autowired
	private HttpServletRequest request;
  
    JWTGetter jwtGetter = new JWTGetter();
	String accessToken = jwtGetter.getAccessToken(request);
	JWTDecoder jwtDecoder = new JWTDecoder();
	jwtDecoder.getGroups(accessToken);
	jwtDecoder.getRoles(accessToken);
	jwtDecoder.getPermissions(accessToken);
    jwtDecoder.getScopes(accessToken);
