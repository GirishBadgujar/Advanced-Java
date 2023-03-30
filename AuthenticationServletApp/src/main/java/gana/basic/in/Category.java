package gana.basic.in;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Category
 */
@WebServlet("/Category")
public class Category extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<tbale border='1'>");
		out.println("<tr>");
		out.println("<th>Name</th>");
		out.println("<th>Decription</th>");
		out.println("<th>Image</th>");
		out.println("</tr>");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		try(Connection connection = 
				DriverManager.getConnection("jdbc:mysql://localhost/advanced_java","GirishDB","cdac");
				
				PreparedStatement psAuthenticate = 
						connection.prepareStatement("select * from category_0058"))
		{
			try(ResultSet result = 
					psAuthenticate.executeQuery())
		
		{
				while(result.next())
				{
					out.println("<tr>");
					out.println("<td><a href='Products?categoryId=" +
					result.getInt("categoryId") + "'>" + 
					result.getString("categoryName") + "</a></td>");
					out.println("<td>" +  
					result.getString("categoryDescription") + "</td>");
					out.println("<td><img src='Image/" + result.getString("categoryImageUrl")+
							"' height='120px' width='120px'/></td>" );
					out.println("</tr>");
				}
				out.println("</table>");
				out.println("</body>");
				out.println("</html>");
		}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
