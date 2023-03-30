package gana.basic.spring.ThirdSpringApp1.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FlipkartAccount implements Account
{
	
	@Autowired
		Users objUser;
		

		@Override
		public Users getUserInfo() {
			// TODO Auto-generated method stub
			return objUser;
		}

		@Override
		public void activateAccount() {
			// TODO Auto-generated method stub
			System.out.println("Account Activated");
		}

		@Override
		public float subscriptionFees() {
			return 5000;
			// TODO Auto-generated method stub
			
			}
		
		@Override
		public String toString() 
		{
			return "FlipkartAccount [objUser=" + objUser + "]";
		}

}
