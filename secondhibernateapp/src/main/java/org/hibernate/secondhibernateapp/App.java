package org.hibernate.secondhibernateapp;

import java.util.Scanner;
import org.hibernate.secondhibernateapp.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.Query;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      
    	Configuration hibernateConfig = new 
    			Configuration();
      hibernateConfig.configure("Basic.cfg.xml");
      
      try(SessionFactory hibernateFactory = 
    		  hibernateConfig.buildSessionFactory(); 
    		  Session hibernateSession = 
    				  hibernateFactory.openSession();
    		  Scanner scanner = new Scanner(System.in)
    				  {
    			  Query<Object[]> query = 
    					  hibernateSession.createQuery("select objUser.userName, objUser.password from Users objUser");
    			  List<Object[]> list = query.list();
    			  
    			  for(Object [] data: list) {
    				  System.out.println(data[0]);
    				  System.out.println(data[1]);
    			  }
    				  
    		  )
      {
    	  storeRecord(hibernateSession);
    	  //loadRecord(hibernateSession);
      }
    }
     private static void loadRecord(Session 
    		 hibernateSession) {
    	 Users objUser 
    	 =(Users)hibernateSession.load(Users.class, "cdac");
    	 System.out.println(objUser.getUserName());
    	 System.out.println(objUser.getPassword());
    	 System.out.println(objUser.getName());
    	 System.out.println(objUser.getEmail());
     }
     private static void storeRecord(Session 
    		 hibernateSession) {
    	 Scanner scanner = new Scanner(System.in);
    	 
    	 System.out.println("Enter the username");
    	 String users = scanner.next();
    	 
    	 System.out.println("Enter the password");
    	 String password = scanner.next();
    	 
    	 System.out.println("Enter the name");
    	 String name = scanner.next();
    	 
    	 System.out.println("Enter the email");
    	 String email = scanner.next();
    	 
    	 Users objUser = new 
    			 Users(users,password,name,email);
    	 
    	 Transaction tx = 
    			 hibernateSession.beginTransaction();
    	 
    	 hibernateSession.save(objUser);
    	 
    	 tx.commit();
    	 System.out.println("Record Saved...!");
     }
}

