package in.ashokit.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.ashokit.entity.UserCredential;
import in.ashokit.repo.UserCredentialCustomRepository;


@Service
public class MyUserDetailsService implements UserDetailsService{

   @Autowired
   private UserCredentialCustomRepository repo;
   
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserCredential userCredential = repo.findByName(username);
		
		return new User(userCredential.getName(), userCredential.getPassword(), Collections.emptyList());
	}

}
