<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link rel="stylesheet" type="text/css" href="layout.css"/>
<title>NoItem</title>
</head>
<body>
<%
String Type = (String)request.getAttribute("Type");
%>

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
	<%if (Type.equals("NoRemoveItem")) {%>
		<h2>No Item!</h2>
	<%}else if (Type.equals("NoRemoveSearchItem")) {%>
		<h2>No Search Result!</h2>
	<%}else if (Type.equals("NoUser")) {%>
		<h2>No User Found!</h2>
	<%} %>
		<br> <br>
		<FORM ACTION='Admin.jsp' METHOD='POST'>
		<input type='submit' value='Back to AminPage'>
		</FORM>
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