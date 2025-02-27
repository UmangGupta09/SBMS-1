package in.ashokit.config;

import java.net.http.HttpClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import in.ashokit.service.CustomerService;
import lombok.SneakyThrows;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {
	
	@Autowired
	CustomerService customerService;
	
	@Bean
	@SneakyThrows
	public SecurityFilterChain securityConfig(HttpSecurity http)
	{
		http.authorizeHttpRequests( req -> {
			req.requestMatchers("/register", "/login")
			   .permitAll()
			   .anyRequest()
			   .authenticated();			
		});
		return http.csrf().disable().build();
	}
	
	@Bean
	public PasswordEncoder pwdEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationProvider authProvider()
	{
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider(); 
		daoAuthenticationProvider.setUserDetailsService(customerService);
		daoAuthenticationProvider.setPasswordEncoder(pwdEncoder());
		return daoAuthenticationProvider;
	}
	
	@Bean
	public AuthenticationManager authManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

}
