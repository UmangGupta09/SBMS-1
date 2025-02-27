package in.ashokit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import in.ashokit.entity.UserCredential;
import in.ashokit.repo.UserCredentialCustomRepository;


@Service
public class AuthService {

	@Autowired
	private UserCredentialCustomRepository repository;
	
	@Autowired
    private PasswordEncoder pwdEncoder;
	
	@Autowired
	private JwtService jwtService;
	
	 public String saveUser(UserCredential credential) {
	        credential.setPassword(pwdEncoder.encode(credential.getPassword()));
	        repository.save(credential);
	        return "user added to the system";
	    }
	 
	 public String generateToken(String username) {
	        return jwtService.generateToken(username);
	    }

	    public void validateToken(String token) {
	        jwtService.validateToken(token);
	    }
}
