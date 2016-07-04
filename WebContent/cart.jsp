<%@ page import="Data.Item"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="layout.css"/>
<title>Log In Page</title>
</head>

<body>
<%
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
ArrayList<Item> CartItem = (ArrayList<Item>) request.getAttribute("cart");
if (CartItem == null)
{
	CartItem = (ArrayList<Item>)session.getAttribute("cart");
}
session.setAttribute("pass", "neverpass"); 

%>
	<center>
	
		<div class="mainContent">
			<div class="middle">
	
		<%if (CartItem != null && CartItem.size() !=0) {%>
		<h2>Shopping Cart</h2>
		<br> <br>
		<FORM ACTION='forwardshopping' METHOD='POST'>
			<table>
				<%for (int i = 0; i < CartItem.size(); ++i){%>
				<tr>
					<td><input type="radio" name="cartname" value=<%=i%>/></td>
					<td>Title: <%=CartItem.get(i).getTitle()%></td>
					<td>    </td>
					<td>Author: <%=CartItem.get(i).getAuthor()%></td>
					<td>    </td>
					<td>Price: <%=CartItem.get(i).getPrice()%></td>
				</tr>
				<%}%>
			</table>
			<br> <br>
			<table>
			<tr>
			<td align="left"><input type='submit' name="Choose" value='Remove from Cart' class="button"></td>
			<td align="left"><input type='submit' name="Choose" value='Buy Item' class="button"></td>
			</tr>
			</table>
		</FORM>
		
		<%}
		
		else{%>
		
		<h2>Shopping Cart is empty!</h2>
		
		<%} %>
		
		<br> <br>
		
		<FORM ACTION='BasicSearch.jsp' METHOD='POST'>
		    <% session.setAttribute("cart", CartItem); %>
			<input type='submit' value='Back to Search' class="button">
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