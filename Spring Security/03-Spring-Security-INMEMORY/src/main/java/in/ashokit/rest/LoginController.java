package in.ashokit.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@GetMapping("/home")
	public String  home()
	{
		String msg="Welcome to Ashok IT bank";
		return msg;
	}
	
	@GetMapping("/balance")
	public String getBalance()
	{
		String msg="Your current balance is 4578 INR";
		return msg;
	}
	
	@GetMapping("/statement")
	public String getStatement()
	{
		String msg="Your statement is generated and Sent to your email id";
		return msg;
	}
	
	@GetMapping("/loan")
	public String getMyLoan()
	{
		String msg="Your loan amount is due in jan 2025";
		return msg;
	}
	
	@GetMapping("/contact")
	public String getContact()
	{
		String msg="WE will contact ASAP";
		return msg;
	}
}
