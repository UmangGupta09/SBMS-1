package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.binding.AuthRequest;
import in.ashokit.binding.AuthResponse;
import in.ashokit.entity.UserCredential;
import in.ashokit.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthService service;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@PostMapping("/register")
	public String addNewUser(@RequestBody UserCredential user) {
		return service.saveUser(user);
	}
	
	@PostMapping("/token")
	public AuthResponse getToken(@RequestBody AuthRequest authRequest)
	{
		AuthResponse response = new AuthResponse();
		UsernamePasswordAuthenticationToken token = 
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword());
		Authentication authenticate = authManager.authenticate(token);
		String tokenGen = null;
		if (authenticate.isAuthenticated())
		{
			tokenGen= service.generateToken(authRequest.getUsername());
			response.setToken(tokenGen);
			response.setLoginValid("yes");
		}
		else
		{
			response.setToken("");
			response.setLoginValid("no");
		}
		return response;
	}
	
	 @GetMapping("/validate")
	    public String validateToken(@RequestParam("token") String token) {
	        service.validateToken(token);
	        return "Token is valid";
	    }
}
