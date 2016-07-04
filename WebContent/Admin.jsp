<%@ page language="java" contentType="text/html; charset=US-ASCII"  pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link rel="stylesheet" type="text/css" href="layout.css"/>
<title>Admin Page</title>
</head>
<body>

<%
	String current_admin = (String) request.getSession().getAttribute("current_admin");
	request.getSession().setAttribute("current_admin", current_admin);
%>

	<div class="nav">
		<div class="sidebar">
			<h1>User</h1>
				<p><h2><a href="http://localhost:8080/MyBookStore/login.jsp">Login</a></h2></p>
				<p><h2><a href="http://localhost:8080/MyBookStore/user_signup.jsp">Sign Up</a></h2></p>
			<p><h1>Managing</h1></p>
				<p><h2><a href="http://localhost:8080/MyBookStore/UserActivity.jsp">Managing Users</a></h2></p>
				<p><h2><a href="http://localhost:8080/MyBookStore/ItemSell.jsp">Managing Items</a></h2></p>
			<p><h1>Log In as <%=current_admin%></h1></p>
				<p><h2><a href="http://localhost:8080/MyBookStore/login.jsp">Log Out</a></h2></p>
		</div>
	</div>


	<center>
	
			<div class="mainContent">
			<div class="middle">
		<h2>Admin Page</h2>
		
		<br> <br>
		<table>
		<tr>
		<FORM ACTION='ItemSell.jsp' METHOD='POST'>
			<td align="left"><input type='submit' value='Managing All Items' class="button"></td>
		</FORM>
		<FORM ACTION='UserActivity.jsp' METHOD='POST'>
			<td align="left"><input type='submit' value='Managing All Users' class="button"></td>
		</FORM>
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