package org.gana.spring.ThirdSpringApp;


import java.util.Scanner;

import org.gana.spring.ThirdSpringApp.beans.Account;
import org.gana.spring.ThirdSpringApp.beans.Category;
import org.gana.spring.ThirdSpringApp.beans.Users;
import org.gana.spring.ThirdSpringApp.config.AppConfigurator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Starting Spring Container");
        try(AnnotationConfigApplicationContext
        		applicationContext = new AnnotationConfigApplicationContext(AppConfigurator.class);
        		
        		Scanner scanner = new Scanner(System.in))
				/*
				 * { System.out.println("Spring Container"); String data = scanner.next();
				 * System.out.println("Getting objUser Bean");
				 * 
				 * Users obj = (Users)applicationContext.getBean("objSecondUsers");
				 * System.out.println("obj");
				 * 
				 * Category cat = (Category)applicationContext.getBean(Category.class);
				 * System.out.println("cat"); }
				 */
        {
        	Account amazoneAccount = 
        			(Account)applicationContext.getBean("objAccount");
        	System.out.println(amazoneAccount);
        	
        	Account flipkartAccount = 
        			(Account)applicationContext.getBean("objFlip");
        	System.out.println(flipkartAccount);
        }
    }
}
