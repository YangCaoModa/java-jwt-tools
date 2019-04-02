# java-jwt-tools

This library is used to get access tokens(JWT) from your front end requests, decode JWTs, and get user's Scopes, Groups, Roles, and Permissions information.

To install the library, please add dependencies to your build file:

	repositories { 
        maven { url 'https://jitpack.io' }
    }

    dependencies {
        compile 'com.github.YangCaoModa:java-jwt-tools:v0.1.4'
    }


To use it, just need to import one package in your controllers:

	import com.modaoperandi.java.jwt.tools.DecodedToken;

Here is an example:

	@Autowired
	private HttpServletRequest request;
  
            // Included codes below in your methods:
  
		DecodedToken decodedToken = new DecodedToken(request);
		String authToken = decodedToken.getToken();
		String scopes = decodedToken.getScopes();
		String[] groups = decodedToken.getGroups();
		String[] roles = decodedToken.getRoles();
		String[] permissions = decodedToken.getPermissions();
		
		decodedToken.printUserInfo();     // print out Scopes, Groups, Roles, and Permissions
	        decodedToken.printToken();        // print out authToken
		decodedToken.printScopes();       // print out Scopes
		decodedToken.printGroups();       // print out Groups
		decodedToken.printRoles();        // print out Roles
		decodedToken.printPermissions();  // print out Permissions
