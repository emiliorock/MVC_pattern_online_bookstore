<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link rel="stylesheet" type="text/css" href="layout.css"/>
<title>Email Sent to Seller Page</title>
</head>
<body>
<%
session.setAttribute("SearchType", "BasicSearch");

String current_user = (String) request.getSession().getAttribute("current_user");
request.getSession().setAttribute("current_user", current_user);

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
			<p><h1>Shopping</h1></p>
				<p><h2><a href="http://localhost:8080/MyBookStore/cart.jsp">Shopping Cart</a></h2></p>
			<p><h1>Log In as <%=current_user%></h1></p>
				<p><h2><a href="http://localhost:8080/MyBookStore/user_profile.jsp">User Profile</a></h2></p>
				<p><h2><a href="http://localhost:8080/MyBookStore/login.jsp">Log out</a></h2></p>
		</div>
	</div>
<%
String SellerName = (String) request.getAttribute("SellerName");
%>
	<center>
	
		<div class="mainContent">
			<div class="middle">
				<h2>An Email has been sent to the seller <%=SellerName%> </h2>
				<br> <br> 
				<table>
				<tr>
				<form action="BasicSearch.jsp" method="post">
				<td align="left"><input type="submit" value="Back to Search" class="button"></td>
				</form>
				<form action="cart.jsp" method="post">
				<td align="left"><input type="submit" value="Back toCart" class="button"></td>
				</form>
				</tr>
				</table>
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