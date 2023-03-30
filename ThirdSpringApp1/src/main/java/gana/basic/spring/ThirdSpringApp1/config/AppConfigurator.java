package gana.basic.spring.ThirdSpringApp1.config;

import gana.basic.spring.ThirdSpringApp1.beans.Account;
import gana.basic.spring.ThirdSpringApp1.beans.AmazoneAccount;
import gana.basic.spring.ThirdSpringApp1.beans.Category;
import gana.basic.spring.ThirdSpringApp1.beans.FlipkartAccount;
import gana.basic.spring.ThirdSpringApp1.beans.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfigurator 
{
	@Autowired
	Environment environment;
	
	
	@Bean(initMethod = "initUser", destroyMethod = "destroy")
	
	public Users objUsers() 
	{
		String password = 
				environment.getProperty("user.password");
		Users objUsers = new Users();
		objUsers.setUserName(environment.getProperty("user.username"));
        objUsers.setPassword(password);
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
