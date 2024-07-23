package com.ashokit.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

	@GetMapping("/security")
	public String greetMsg()
	{
		return "Good Evening Umang Gupta with security";
	}
}
