package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@CrossOrigin
public class GreetRestController {

	@Value("${msg}")
	private String msgTxt;
	
	@GetMapping("/greet")
	public String getGreetMsg() {
		return msgTxt;
	}
}
