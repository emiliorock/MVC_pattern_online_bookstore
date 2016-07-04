<%@ page import="Data.Item"%>
<%@ page import="Data.AdReActivity"%>
<%@ page import="Data.BuyActivity"%>
<%@ page import="DAO.AdminFunc"%>
<%@ page import="java.util.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page contentType="text/html; charset=GBK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>

<head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="layout.css"/>
	<title>Information Page</title>
</head>

<body>

	<div class="nav">
		<div class="sidebar">
			<h1>User</h1>
				<p><h2><a href="http://localhost:8080/MyBookStore/login.jsp">Login</a></h2></p>
				<p><h2><a href="http://localhost:8080/MyBookStore/user_signup.jsp">Sign Up</a></h2></p>
			<p><h1>Search</h1></p>
				<p><h2><a href="http://localhost:8080/MyBookStore/BasicSearch.jsp">Basic Search</a></h2></p>
				<p><h2><a href="http://localhost:8080/MyBookStore/AdvancedSearch.jsp">Advanced Search</a></h2></p>
			<p><h1>Shopping</h1></p>
				<p><h2><a href="http://localhost:8080/MyBookStore/cart.jsp">Shopping Cart</a></h2></p>
		</div>
	</div>


<%
String i = request.getParameter("getarticle");
String BuyIndex = request.getParameter("BuyIndex");
String AdReIndex = request.getParameter("AdReIndex");
ArrayList<Item> SearchItem = (ArrayList<Item>)session.getAttribute("SearchItem");
Item node = new Item();;

ArrayList<BuyActivity> BuyList = (ArrayList<BuyActivity>)session.getAttribute("BuyList");
ArrayList<AdReActivity> AdReList = (ArrayList<AdReActivity>)session.getAttribute("AdReList");
String flag = (String)session.getAttribute("flag");
String keyTitle = null;
AdminFunc use = new AdminFunc();
if (BuyIndex != null)
{	
	int keyindex = Integer.valueOf(BuyIndex).intValue();
	keyTitle = BuyList.get(keyindex).getTitle();
}
else if (AdReIndex != null)
{
	int keyindex = Integer.valueOf(AdReIndex).intValue();
	keyTitle = AdReList.get(keyindex).getTitle();
}

if (flag == null)
{
	int i1 = Integer.valueOf(i).intValue();
	node = SearchItem.get(i1);
}
else
{
	node = use.RemoveSearch(keyTitle).get(0);
}

session.setAttribute("node", node);
session.setAttribute("SearchItem", SearchItem);
session.setAttribute("pass", "pass");

%>
	<center>
	<div class="mainContent">
		<div class="middle">
		
		<h2>Result Page</h2>
		
		<table>
		<tr>
		<td align="left">Title: <%=node.getTitle()%></td>
		</tr>
		<tr>
		<td align="left">Author: <%=node.getAuthor()%></td>
		</tr>
		<tr>
		<td align="left">Publisher: <%=node.getPublisher()%></td>
		</tr>
		<tr> 
		<td align="left">Seller: <%=node.getSeller()%></td>
		</tr>
		<tr> 
		<td align="left">Type: <%=node.getType()%></td>
		</tr>
		<tr> 
		<td align="left">Date: <%=node.getDate()%></td>
		</tr>
		<tr> 
		<td align="left">Price: <%=node.getPrice()%></td>
		</tr>
		</table>
		
		<%if (flag == null) {%>
		<FORM ACTION='forwardshopping' METHOD='POST'>
		<input type='submit' value='Add to Cart' class="button">
		</FORM>
		
		<form action="success.jsp" method="post">
		<input type="submit" value="Back to Result Page" class="button">
		</form>
		
		<%}
		else
		{%>
		<form action="Admin.jsp" method="post">
		<input type="submit" value="Admin Page" class="button">
		</form>
		<%} %>
		
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
