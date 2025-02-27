package in.ashokit.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Customer;
import in.ashokit.repo.CustomerRepository;

@Service
public class CustomerService implements UserDetailsService {

	@Autowired
	CustomerRepository customerRepo;
	
	@Override
	public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
		Customer customer=customerRepo.findByEmail(emailId);
		User user= new User(customer.getName(), customer.getPwd(), Collections.emptyList());
		return user;
	}

}
