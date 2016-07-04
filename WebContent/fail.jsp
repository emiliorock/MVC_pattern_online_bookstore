
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="layout.css"/>
<title>Fail</title>
</head>

<body>

<%
	request.getSession().setAttribute("current_user", "UnKnown");
	request.getSession().setAttribute("current_seller", "UnKnown");
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
	
		<h2>Sorry, no matching datasets found!</h2>
		
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
