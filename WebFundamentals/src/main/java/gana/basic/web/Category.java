package gana.basic.web;

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
 * Servlet implementation class Category
 */
@WebServlet("/Category")
public class Category extends HttpServlet {
	private static final long serialVersionUID = 1L;


	Connection connection;
	PreparedStatement psCategory;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		try {
			if(psCategory!=null)
				psCategory.close();
			if(connection!=null)
				connection.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}



	@Override
	public void init(ServletConfig config) throws ServletException 
	{

		super.init(config);

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connection =
					DriverManager.getConnection("jdbc:mysql://localhost/advanced_java","GirishDB","cdac"); 
			psCategory = 
					connection.prepareStatement("select * from user_0058 category_0058");
		}catch(Exception e) {
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
		out.println("<th width='120px' style='background-color:pink'>Decription</th>");
		out.println("<th width='120px' style='background-color:pink'>Image</th>");
		out.println("</tr>");

		try(ResultSet result = 
				psCategory.executeQuery())

		{
			while(result.next())
			{
				out.println("<tr>");
				out.println("<td><a href='Product?categoryId=" +
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

	catch(SQLException e) {
		e.printStackTrace();
	}
}
}

