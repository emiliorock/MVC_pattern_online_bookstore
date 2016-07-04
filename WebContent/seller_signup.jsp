<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="layout.css"/>
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
	
	<H2>SELLER SIGN UP</H2>
	
	<form action="signup" method="post">
	<table>
	<tr>
		<td align="left"><p>Username(*):</p></td>
		<td><input type="text" name="new_username"></td>
	</tr>
	<tr>
		<td align="left"><p>Password(*):</p></td>
		<td><input type="password" name="new_password"></td>
	</tr>
	<tr>
		<td align="left"><p>E-mail Address(*):</p></td>
		<td><input type="text" name="new_email"></td>
	</tr>
	<tr>
	<td align="left"><p>Publisher:</p></td>
	<td><input type="text" name="new_publisher"></td>
	</tr>			
	<tr>
		<td align="left"><p>Full Address:</p></td>
		<td><input type="text" name="new_address"></td>
	</tr>
	</table>
	<p></p>
		<input type="submit" value="DONE" class="button">
		<input type="hidden" name="action" value="seller_signup">
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