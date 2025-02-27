package in.ashokit.Config;


import org.springframework.security.config.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity

public class AppSecurityConfigurer {

	
	@Bean
	public InMemoryUserDetailsManager inMemoryUsers() {
		
		UserDetails u1 = User.withDefaultPasswordEncoder()
							 .username("ashokit")
							 .password("ashokit@123")
							 .authorities("ROLE_ADMIN")
							 .build();
		
		UserDetails u2 = User.withDefaultPasswordEncoder()
							 .username("raju")
							 .password("raju@123")
							 .authorities("ROLE_USER")
							 .build();
		
		UserDetails u3 = User.withDefaultPasswordEncoder()
							 .username("john")
							 .password("john@123")
							 .authorities("ROLE_USER")
							 .build();
		
		return new InMemoryUserDetailsManager(u1, u2, u3);
	}
	
	@Bean
	public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception {
		
			http.authorizeHttpRequests((req) -> req
					.requestMatchers("/home","/contact").permitAll()
					
				)
			.authorizeHttpRequests((req) -> req
					.requestMatchers("/balance","/statement").hasRole("USER")
					
				)
			.authorizeHttpRequests((req) -> req
					.requestMatchers("/loan").hasRole("ADMIN")
					
				)
			.authorizeHttpRequests((req) -> req
					.anyRequest().authenticated()
					
				)
			.httpBasic(Customizer.withDefaults())
				 .formLogin(Customizer.withDefaults());			
			
			return http.build();
	}
	
}
