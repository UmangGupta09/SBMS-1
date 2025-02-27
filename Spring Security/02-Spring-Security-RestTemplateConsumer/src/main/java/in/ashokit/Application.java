package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		callAPI();
	}

	public static void callAPI()
	{
		RestTemplate restTemplate =new RestTemplate();
		String apiURL="http://localhost:8080/msg";
		
		String uname="ashokit";
		String pwd="ashokit";
		
		String cred = uname+":"+pwd;
		byte[] encodedCredentials = java.util.Base64.getEncoder().encode(cred.getBytes());
		
		String headerKey="Authorization";
		String headerValue= "Basic "+ new String(encodedCredentials);
		
		HttpHeaders headers = new HttpHeaders();
		headers.set(headerKey, headerValue);

		HttpEntity httpEntity = new HttpEntity(headers);
		ResponseEntity<String> response = restTemplate.exchange(apiURL,HttpMethod.GET, httpEntity,String.class);
		System.out.println(response.getBody());
		
	}
}
