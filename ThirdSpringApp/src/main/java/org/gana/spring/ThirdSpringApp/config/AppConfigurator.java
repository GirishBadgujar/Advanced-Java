package org.gana.spring.ThirdSpringApp.config;

import org.gana.spring.ThirdSpringApp.beans.Account;
import org.gana.spring.ThirdSpringApp.beans.AmazoneAccount;
import org.gana.spring.ThirdSpringApp.beans.Category;
import org.gana.spring.ThirdSpringApp.beans.FlipkartAccount;
import org.gana.spring.ThirdSpringApp.beans.Users;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfigurator 
{
	/*
	 * @Bean public Users objUsers() { return new Users(); }
	 * 
	 * @Bean public Users objSecondUsers() { return new Users(); }
	 */

	
	@Bean
	@Scope("prototype")
	public Users objUsers() 
	{
		Users objUsers = new Users();
		objUsers.setUserName("Girish");
		objUsers.setPassword("girish");
		return objUsers;
	}
	
	@Bean
	public Account objFlip() 
	{
		
		return new FlipkartAccount();
	}
	
	@Bean
	public Account objAccount()
	{
		return new AmazoneAccount();
	}
	
	@Bean
	public Category objCategory()
	{
		return new Category();
	}
}
