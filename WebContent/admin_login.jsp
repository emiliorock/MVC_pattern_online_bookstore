<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	Date date = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy/MM/dd HH:mm:ss");
	String time = dateFormat.format(date);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="layout.css"/>
<title>Admin Log In Page</title>
</head>

<body>

<%
	request.getSession().setAttribute("current_admin", "UnKnown");
	request.getSession().setAttribute("current_admin", "UnKnown");
%>

	<div class="nav">
		<div class="sidebar">
			<h1>User</h1>
				<p><h2><a href="http://localhost:8080/MyBookStore/login.jsp">Login</a></h2></p>
				<p><h2><a href="http://localhost:8080/MyBookStore/user_signup.jsp">User Sign Up</a></h2></p>
				<p><h2><a href="http://localhost:8080/MyBookStore/seller_signup.jsp">Seller Sign Up</a></h2></p>
			<p><h1>Search</h1></p>
				<p><h2><a href="http://localhost:8080/MyBookStore/BasicSearch.jsp">Basic Search</a></h2></p>
				<p><h2><a href="http://localhost:8080/MyBookStore/AdvancedSearch.jsp">Advanced Search</a></h2></p>
		</div>
	</div>

	<center>
		<div class="mainContent">
			<div class="middle">
			
				<H2>Admin Login Page</H2>
						
				<form action="login" method="post">
					
					<table>
					<input type="hidden" name="user_type" value="admin">
					<tr>
					<td align="left"><p>Username: </p></td>
					<td align="left"><input type="text" name="username"> </td>
					</tr>
					<p></p>
					<tr>
					<td align="left"><p>Password: </p></td> 
					<td align="left"><input type="password" name="password"></td>
					</tr>
					</table>
					<p>
					<input type="submit" value="LOG IN" class="button">
					<input type="hidden" name="action" value="user_login">
					</p>
					
				</form>
			<p></p>
			
			</div>
		</div>

<div class="footer">
	<div class="footer_middle">
		This Website is developed by Mengxin Huang(z5013846), Zhe Feng(z5011158)</br>
		Group Kiwi
	</div>
</div>

</center>
</body>
</html>