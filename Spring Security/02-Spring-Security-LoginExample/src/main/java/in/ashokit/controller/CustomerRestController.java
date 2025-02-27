package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.entity.Customer;
import in.ashokit.repo.CustomerRepository;

@RestController
public class CustomerRestController {

	@Autowired
	PasswordEncoder pwdEncoder;
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	AuthenticationManager authenticateManager;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerCustomer(@RequestBody Customer customer) {
	    String encodedPwd=pwdEncoder.encode(customer.getPwd());
		customer.setPwd(encodedPwd);
		customerRepo.save(customer);
		return new ResponseEntity<>("Customer Registerd",HttpStatus.CREATED);
		
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginCheck(@RequestBody Customer customer)
	{
		UsernamePasswordAuthenticationToken userToken=new UsernamePasswordAuthenticationToken(customer.getEmail(),customer.getPwd());
		Authentication authenticate = authenticateManager.authenticate(userToken);
		if(authenticate.isAuthenticated())
		{
			return new ResponseEntity<>("Welcome to Ashok IT", HttpStatus.OK);
		}
		return new ResponseEntity<>("Invalid Credentials", HttpStatus.BAD_REQUEST);
	}
	
	
}
