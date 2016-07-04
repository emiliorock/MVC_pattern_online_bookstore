<%@ page import="DAO.UserDAO" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="layout.css"/>
<title>Confirmation Page</title>
</head>

<body>

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
	
	<H2>Confirmation Page</H2>

	<table>
	<tr>
	<td align="left"><p>
<%
	String str = request.getQueryString();
	String[] info = str.split("=");
	UserDAO userDAO = new UserDAO();
	if(info[3].equals("user")) {
		if(userDAO.confirmOneUser(info[1], info[2]) == true) {
%>
			Welcome our new user: <%=info[1]%>
<% 		
		}
	}
	else if(info[3].equals("seller")) {
		if(userDAO.confirmOneSeller(info[1], info[2]) == true) {
%>
			Welcome our new seller: <%=info[1]%>
<% 
		}
	}
%>
	</p>
	</td>
	</tr>
	<tr>
	<td align="left"><p>Your username: <%=info[1]%></p></td>
	</tr>
	<tr>
	<td align="left"><p>Your email: <%=info[2]%></p></td>
	</tr>
</table>

<p></p>

<form action="login.jsp" method="post">
<input type="submit" value="Log In" class="button">
</form>

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