<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="gana.basic.pojo.UserInfo" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <%
         Class.forName("com.mysql.cj.jdbc.Driver");
     
         Connection connection = 
          DriverManager.getConnection("jdbc:mysql://localhost/advanced_java","GirishDB","cdac");
         PreparedStatement psAuthenticate = 
        		 connection.prepareStatement("select * from user_0058 where userName=? and password=?");
         
         String userName = 
        		 request.getParameter("userName");
         String password = 
        		 request.getParameter("password");
         
         psAuthenticate.setString(1,userName);
         psAuthenticate.setString(2,password);
     
         ResultSet result = 
        		 psAuthenticate.executeQuery();
     
         if(result.next())
         {
     %>
          <h1>Welcome to the Online Shopping  
     <%=userName%></h1> 
     <%
         }
         else
         {
     %>
          <font color="red">invalid userName/password</font>
       <%
               response.sendRedirect("login.jsp");
         }
       %>
</body>
</html>