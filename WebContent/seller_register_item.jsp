<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="layout.css"/>
<title>Register Item Page</title>
</head>

<body>

<% String current_seller = (String) request.getSession().getAttribute("current_seller"); %>
<% request.getSession().setAttribute("current_seller", current_seller); %>

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

	<H2>Register New Item</H2>

		<form action="seller_register_item" method="post">
		<table>
		<tr>
			<td align="left"><p>Title:</p></td>
			<td align="left"><p><input type="text" name="new_title"></p></td>
		</tr>
		<tr>
			<td align="left"><p>Author:</p></td>
			<td align="left"><p><input type="text" name="new_author"></p></td>
		</tr>
		<tr>
			<td align="left"><p>Publication Type:</p></td>
			<td align="left"><p><input type="text" name="new_type"></p></td>
		</tr>
		<tr>
			<td align="left"><p>Publication Date:</p></td>
			<td align="left"><p><input type="text" name="new_date"></p></td>
		</tr>
		<tr>			
			<td align="left"><p>Price:</p></td>
			<td align="left"><p><input type="text" name="new_price"></p></td>
		</tr>
		<tr>
			<td align="left"><p>Seller:</p></td>
			<td align="left"><p><input type="text" name="new_seller"></p></td>
		</tr>
		<tr>
			<td align="left"><p>Publisher:</p></td>
			<td align="left"><p><input type="text" name="new_publisher"></p></td>
		</tr>
		<tr>
			<td align="left"><p>Disabled Search?</p></td>
			<td align="left"><p><select name="new_pause">
				<option value="new_yes">Yes</option>
				<option value="new_no">No</option>
			</select>
			</p></td>
			</tr>
		</table>
			
	<input type="submit" value="DONE" class="button">
	<input type="hidden" name="action" value="register_item">
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