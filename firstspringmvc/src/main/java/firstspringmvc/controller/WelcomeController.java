package firstspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController 
{
	@GetMapping("/hello")
	public String welcome()
	{
		System.out.println("Welcome of the WelcomeController Fired...");
		return "welcome";
	}

}
