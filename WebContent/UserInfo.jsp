<%@ page import="Data.User"%>
<%@ page import="Data.AdReActivity"%>
<%@ page import="Data.BuyActivity"%>
<%@ page import="DAO.AdminFunc"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link rel="stylesheet" type="text/css" href="layout.css" />
<title> User Activity Info</title>
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

<%
ArrayList<User> SearchUserList = (ArrayList<User>)session.getAttribute("SearchUserList");
ArrayList<User> UserList = (ArrayList<User>)session.getAttribute("UserList");
String List = (String)session.getAttribute("List");
int NodeIndex = Integer.valueOf(request.getParameter("index")).intValue();
User one = new User();
AdminFunc use = new AdminFunc();
if (List.equals("UserList"))
{
	one = UserList.get(NodeIndex);
}
else if (List.equals("SearchUserList"))
{
	one = SearchUserList.get(NodeIndex);	
}
ArrayList<BuyActivity> BuyList = use.GetBuy(one.getUsername());
ArrayList<AdReActivity> AdReList = use.GetAdRe(one.getUsername());

session.setAttribute("BuyList", BuyList);
session.setAttribute("AdReList", AdReList);
session.setAttribute("flag", "flag");
%>

<center>

<div class="mainContent">
	<div class="left_content">
			<h2>Items Bought</h2>
			<table>
				<%for (int i = 0; i < BuyList.size(); ++i) 
				{%>
				<tr>
					<td><a href=information.jsp?BuyIndex=<%=i%>>
					<%=i+1%> Title: <%=BuyList.get(i).getTitle() %></a></td>
					<td>Buy Time: <%=BuyList.get(i).getBuytime()%></td>
					<td>Price: <%=BuyList.get(i).getPrice()%></td>
					<td>Seller: <%=BuyList.get(i).getSeller()%></td>
				</tr>
				<%} %>
			</table>
			<form action="Admin.jsp" method="post">
			<input type="submit" value="Back to Admin page" class="button">
			</form>
	</div>
	
	<div class="right_content">
			<h2>Items Removed From Shopping Cart</h2>
			<table>
				<%for (int i = 0; i < AdReList.size(); ++i) 
				{%>
				<tr>
					<td><a href=information.jsp?AdReIndex=<%=i%>>
					<%=i+1%> Title: <%=AdReList.get(i).getTitle() %></a></td>
					<td>Add Time: <%=AdReList.get(i).getAdtime()%></td>
					<td>Remove Time: <%=AdReList.get(i).getRetime()%></td>
				</tr>
				<%} %>
			</table>
			<form action="Admin.jsp" method="post">
			<input type="submit" value="Back to Admin page" class="button">
			</form>
	</div>	
</div>

<div class="footer">
	<div class="footer_middle">
		This Website is written by Mengxin Huang(z5013846), Zhe Feng(z5011158)</br>
		Group Kiwi
	</div>
</div>
	
</center>	
</body>
</html>