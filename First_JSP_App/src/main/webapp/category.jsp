<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Welcome <b><%=session.getAttribute("userName")%></b><br/>

<table border='1'>
<tr>
<th>Name</th>
<th>Description</th>
<th>Image</th>
</tr>

<%
     Connection connection = (connection)
     application.getAttribute("globalConnection");
try(PreparedStatement )


%>
</table>
</body>
</html>