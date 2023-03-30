package gana.basic.in;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Authenticate
 */
@WebServlet("/Authenticate")
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	
	{
		PrintWriter out = response.getWriter();
		
		String userName = 
				request.getParameter("userName");
		String password =
				request.getParameter("password");
		if((userName!=null &&
				userName.equals("GirishDB")) && (password!=null &&
				password.equals("cdac")))
			out.println("You have been authenticated");
		else
			out.println("Authentication Failure");
		
	}

}
