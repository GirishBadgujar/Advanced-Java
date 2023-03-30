package gana.basic.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GetSession
 */
@WebServlet("/GetSession")
public class GetSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = 
				request.getSession(false);
		
		PrintWriter out = response.getWriter();
		
		if(session == null)
		{
			out.println("No session for this user");
			return;
		}
			out.println("Session Id :" + session.getId() + "<br/>");
			out.println("Session Last Access Time: " + new Date(session.getLastAccessedTime()) + "<br/>");
			out.println("Session Max Inactive Intervel :" + session.getMaxInactiveInterval() + "<br/>" );
            
			String user = 
					(String)session.getAttribute("userName");
			out.println("Welcome User " + user);
			
	}

}
