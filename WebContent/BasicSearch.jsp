<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ page import="DAO.Control"%>
<%@ page import="Data.Item"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link rel="stylesheet" type="text/css" href="layout.css"/>
<title>Basic Search Page</title>
</head>
<body>

<%
session.setAttribute("SearchType", "BasicSearch");

String current_user = (String) request.getSession().getAttribute("current_user");
request.getSession().setAttribute("current_user", current_user);

Control use = new Control();
ArrayList<Item> randomList = use.getrandom();

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

	<center>
	<div class="mainContent""/import/adams/2/z5011158/Templates/ControlServlet.java">
		<div class="middle">
	    <h2>Basic Search</h2>
		Search by:
		<br> <br>
		<form action='forward' method='POST'>
		<table>
		<tr>
			<td align="left">Title : </td> <td align="left"><input type="text" name="title" /></td>
		</tr>
		<tr>
			<td align="left">Author : </td> <td align="left"><input type="text" name="author" /></td>
		</tr>
		<tr>
			<td align="left">Price(Less Than) : </td> <td align="left"><input type="text" name="price" /></td>
		</tr>
		<tr>
			<td align="left">Seller : </td> <td align="left"><input type="text" name="seller" /></td>
		</tr>
		</table>
		<p></p>
		<input type='submit' value='Search' class="button">
		</form>
		<br>
		<table>
		<tr>
		<form action="AdvancedSearch.jsp" method="post">
		<td align="left"><input type="submit" value="Advanced Search" class="button"></td>
		</form>
		
		<form action="cart.jsp" method="post">
		<td align="left"><input type="submit" value="Shopping Cart" class="button"></td>
		</form>
		</tr>
		</table>
		<br> <br>
		<table>
			<%for (int i = 0; i < randomList.size(); ++i) {%>
			<tr>
				<td><%=i+1%> Title: [<%=randomList.get(i).getTitle() %>]
				</td>
				<td>Author: <%=randomList.get(i).getAuthor()%></td>
			</tr>
			<%} %>
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