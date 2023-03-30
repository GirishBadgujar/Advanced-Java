package gana.basic.Shopping;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Product
 */

public class Product extends HttpServlet {
	private static final long serialVersionUID = 1L;
Connection connection;
PreparedStatement psProduct;

@Override
public void destroy() 
{
	try {
		if(psProduct!=null)
			psProduct.close();
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
	
	String driverClass = 
			config.getInitParameter("driverClass");
	String url = 
			config.getInitParameter("url");
	String user =
			config.getInitParameter("dbUser");
	String password = 
			config.getInitParameter("dbPassword");
	
	Class.forName(driverClass);
	
	connection =
			DriverManager.getConnection(url,user,password);
	psProduct =  
			connection.prepareStatement("select * from products_0058 where categoryId=?");
	}
catch(Exception e) 	{
	e.printStackTrace();
}	

}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<th width='120px' style='background-color:pink'>Name</th>");
		out.println("<th width='120px' style='background-color:pink'>Description</th>");
		out.println("<th width='120px' style='background-color:pink'>Image</th>");
		out.println("<th width='130px' style='background-color:pink'>productPrice</th>");
		out.println("</tr>");
		
		try {
			
			String tmp =
						request.getParameter("categoryId");
				int categoryId =
						Integer.parseInt(tmp);
				psProduct.setInt(1, categoryId);
				
				try(ResultSet result = 
						psProduct.executeQuery())
				{
					while(result.next())
					{
						out.println("<tr>");
						out.println("<td>" + 
						result.getString("productName") + "</td>");
						out.println("<td>" + 
						result.getString("productDescription") + "</td>");
						
						out.println("<td><img src='Image/" + result.getString("productImageUrl") + 
								"' height='120px' width='120px'/></td>");
						out.println("<td>" +
								result.getString("productPrice") + "</td>");
						out.println("</tr>");
						
						
					}
					out.println("</table>");
					out.println("</body>");
					out.println("</html>");
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}


