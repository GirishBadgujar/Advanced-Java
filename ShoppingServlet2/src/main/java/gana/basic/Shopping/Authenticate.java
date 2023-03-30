package gana.basic.Shopping;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Authenticate
 */
@WebServlet(loadOnStartup = 100,urlPatterns = {"/Authentication"})

public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection connection;
	PreparedStatement psAuthenticate;
  
	@Override
	public void destroy() 
	{
		try {
			if(psAuthenticate!=null)
				psAuthenticate.close();
			if(connection!=null)
				connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	
	public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
	try {
		ServletContext application =
				getServletContext();
		
		String driverClass = 
				application.getInitParameter("driverClass");
		String url = 
				application.getInitParameter("url");
		String user =
				application.getInitParameter("dbUser");
		String password = 
				application.getInitParameter("dbPassword");
		
		Class.forName(driverClass);
		
		connection =
				DriverManager.getConnection(url,user,password);
		psAuthenticate =  
				connection.prepareStatement("select * from user_0058 where userName=? and password=?");
		}
	catch(Exception e) 	{
		e.printStackTrace();
	}	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		
		String userName = 
				request.getParameter("userName");
		String password = 
				request.getParameter("password");
		try {
			
			psAuthenticate.clearParameters();
			
			psAuthenticate.setString(1, userName);
			psAuthenticate.setString(2, password);
		
			try(ResultSet result = 
					psAuthenticate.executeQuery())
			{
				if(result.next())
					response.sendRedirect("Category");
					else
						out.println("Invalid userName/ password");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
