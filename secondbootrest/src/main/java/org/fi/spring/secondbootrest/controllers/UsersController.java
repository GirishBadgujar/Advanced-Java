package org.fi.spring.secondbootrest.controllers;

import org.fi.spring.secondbootrest.dto.UsersInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController 
{
	@PostMapping("/authenticate")
	public UsersInfo
	processAuthenticate(@RequestParam("userName")String userName,
			@RequestParam("password")String password)
	{
		if(userName.equals("Girish") && password.equals("cdac"))
			
		{
			UsersInfo objUser = new UsersInfo();
			objUser.setUserName("Girish");
			objUser.setPassword("girish");
			objUser.setName("Girish Badgujar");
			objUser.setEmail("girishbadgujarlive@gmail.com");
			
			return objUser;
		}
			
		else
			return null;
	}

}
