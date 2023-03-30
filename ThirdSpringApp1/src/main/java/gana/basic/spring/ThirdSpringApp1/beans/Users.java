package gana.basic.spring.ThirdSpringApp1.beans;


import org.springframework.stereotype.Component;

@Component
public class Users 
{
	String userName;
	String password;
	
	public Users() 
	{
	
		System.out.println("Users Constructor Fired...");
	}
	
	@PostConstruct
	public void initUser()
	{
		System.out.println("Init Method of the Bean Fired...");
		userName = userName.toUpperCase();
	}

	@PreDestroy
	public void destroy()
	{
		System.out.println("Destroy Method Fired...");
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
