package org.fi.firstbootrest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController 
{
	@GetMapping("/welcome")
	public String welcome()
	{
		return "welcome to the First RESTFUL web Service in Spring Boot";
	}

}
