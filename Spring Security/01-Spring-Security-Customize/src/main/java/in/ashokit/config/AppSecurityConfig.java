package in.ashokit.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {

	@Bean
	public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception {
		
			http.authorizeHttpRequests((req) -> req
					.requestMatchers("/contact","/home").permitAll()
					.anyRequest().authenticated()
				).httpBasic(Customizer.withDefaults())
				 .formLogin(Customizer.withDefaults());			
			
			return http.build();
	}
}
