package org.fi.springbootmvc1.controllers;

import org.fi.springbootmvc1.pojo.UserInfo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class UsersController
{
	@GetMapping("/login")
	public void prepareUser(Model data)
	{
		System.out.println("Controller Fired...");
		data.addAttribute("objUser", new UserInfo());	
	}

	@PostMapping("/authenticate")
	public String
	authenticate(@ModelAttribute("objUser")UserInfo objUser)
	{
		if(objUser.getUserName().equals("Girish") && objUser.getPassword().equals("cdac"))
			return "welcome";
		else
			return "failure";
	}
}
