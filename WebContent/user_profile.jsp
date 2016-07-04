<%@ page import="java.util.*"%>
<%@ page import="DAO.UserDAO"%>
<%@ page import="Data.User"%>
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
<title>User Profile Page</title>
</head>

<body>
<%
	String current_user = (String) request.getSession().getAttribute("current_user");
	request.getSession().setAttribute("current_user", current_user);
	UserDAO uDAO = new UserDAO(); 
	User u = uDAO.findOneUser(current_user);
	System.out.println(u.getUsername());
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
				<p><h2><a href="http://localhost:8080/MyBookStore/login.jsp">Log Out</a></h2></p>
		</div>
	</div>

	<center>
		<div class="mainContent">
			<div class="middle">
			
				<H2>My Profile</H2>
<% 
	if(current_user.equals("UnKnown")) {
%>
	Sorry, You are not log in now
<% 		
	} else {
%>
	
				
				<form action="edit" method="post">
	<table>
	<tr>
		<td align="left"><p>Username(Cannot be changed):</p></td>
		<td align="left"><%=current_user%></td>
	</tr>
	<tr>
		<td align="left"><p>Password(*):</p></td>
		<td align="left"><input type="password" name="edit_password" value="<%=u.getPassword()%>"></td>
	</tr>
	<tr>
		<td align="left"><p>E-mail Address(*):</p></td>
		<td align="left"><input type="text" name="edit_email" value="<%=u.getEmail()%>"></td>
	</tr>
	<tr>
		<td align="left"><p>Nick Name:</p></td>
		<td align="left"><input type="text" name="edit_nickname" value="<%=u.getNickname()%>"></td>
	</tr>
	<tr>			
		<td align="left"><p>First Name:</p></td>
		<td align="left"><input type="text" name="edit_firstname" value="<%=u.getFirstname()%>"></td>
	</tr>
	<tr>
		<td align="left"><p>Last Name:</p></td>
		<td align="left"><input type="text" name="edit_lastname" value="<%=u.getLastname()%>"></td>
	</tr>
	<tr>		
		<td align="left"><p>Full Address:</p></td>
		<td align="left"><input type="text" name="edit_address" value="<%=u.getAddress()%>"></td>
	</tr>
	<tr>
		<td align="left"><p>Birthday:</p></td>
		<td align="left"><input type="text" name="edit_birthday"  value="<%=u.getBirthday()%>"></td>
	</tr>
	<tr>
		<td align="left"><p>Card Number:</p></td>
		<td align="left"><input type="text" name="edit_cardnumber" value="<%=u.getCardnumber()%>"></td>
	</tr>		
		</table>
	<p></p>
	<input type="submit" value="DONE" class="button">
	<input type="hidden" name="action" value="user_edit">
	</form>
				
	<% } %>
				
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