<%@ page import="java.util.*"%>
<%@ page import="DAO.UserDAO"%>
<%@ page import="Data.Seller"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
<title>Seller Profile Page</title>
</head>

<body>
<%
	String current_seller = (String) request.getSession().getAttribute("current_seller");
	request.getSession().setAttribute("current_seller", current_seller);
	UserDAO uDAO = new UserDAO(); 
	Seller s = uDAO.findOneSeller(current_seller);
%>

	<div class="nav">
		<div class="sidebar">
			<h1>User</h1>
				<p><h2><a href="http://localhost:8080/MyBookStore/login.jsp">Login</a></h2></p>
				<p><h2><a href="http://localhost:8080/MyBookStore/user_signup.jsp">Sign Up</a></h2></p>
			<p><h1>Item</h1></p>
				<p><h2><a href="http://localhost:8080/MyBookStore/seller_register_item.jsp">Register new item</a></h2></p>
				<p><h2><a href="http://localhost:8080/MyBookStore/seller_check_item.jsp">Check existing item</a></h2></p>
			<p><h1>Log In as <%=current_seller%></h1></p>
				<p><h2><a href="http://localhost:8080/MyBookStore/seller_profile.jsp">Profile</a></h2></p>
				<p><h2><a href="http://localhost:8080/MyBookStore/login.jsp">Log Out</a></h2></p>
		</div>
	</div>

	<center>
		<div class="mainContent">
			<div class="middle">
			
				<H2>My Profile</H2>
				
				<form action="edit" method="post">
	<table>
	<tr>
		<td align="left"><p>Username(Cannot be changed):</p></td>
		<td align="left"><%=current_seller%></td>
	</tr>
	<tr>
		<td align="left"><p>Password(*):</p></td>
		<td align="left"><input type="password" name="edit_password" value="<%=s.getPassword()%>"></td>
	</tr>
	<tr>
		<td align="left"><p>E-mail Address(*):</p></td>
		<td align="left"><input type="text" name="edit_email" value="<%=s.getEmail()%>"></td>
	</tr>
	<tr>
		<td align="left"><p>Publisher:</p></td>
		<td align="left"><input type="text" name="edit_publisher" value="<%=s.getPublisher()%>"></td>
	</tr>
	<tr>		
		<td align="left"><p>Full Address:</p></td>
		<td align="left"><input type="text" name="edit_address" value="<%=s.getAddress()%>"></td>
	</tr>	
	</table>
	<p></p>
	<input type="submit" value="DONE" class="button">
	<input type="hidden" name="action" value="seller_edit">
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