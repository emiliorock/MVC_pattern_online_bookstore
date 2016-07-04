<%@page import="java.util.*" %>
<%@page import="Data.Item" %>
<%@page import="DAO.ItemDAO" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="layout.css"/>
<title>Check Item Page</title>
</head>

<body>

<% 
	String current_seller = (String) request.getSession().getAttribute("current_seller");
	request.getSession().setAttribute("current_seller", current_seller);
%>

<body>

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

<H2>My Items</H2>

<%
	ArrayList<Item> product_list = new ArrayList();
	ItemDAO itemDAO = new ItemDAO();
	product_list = itemDAO.findSellerItem(current_seller);
	if(product_list.size() == 0) {
%>
	Sorry, you haven't register any items now
<%
	} else {
%>

<% 
	int pageNo = 1;
	int pageSize = 10;
	int total = product_list.size();
	int totalPage = total/pageSize + ((total % pageSize) > 0?1:0);
	String currPage = (String) request.getParameter("currPage"); 
	if(currPage == null) {
		currPage = "1";
	}
	if(currPage != null) {
		pageNo = Integer.valueOf(currPage);
	}
	if(product_list == null) {
%>
	No items
<%
	}
	else {	
%>

	<form action="seller_check_item" method="post">
	<table>
	<% 
		int end = Math.min(product_list.size(), (pageNo * 10 -1));
		if(pageNo == totalPage) {
			end = product_list.size() - 1;
		}
		for(int i = (pageNo - 1) * 10; i <= end;i++) {
			String title = product_list.get(i).title;
			String author = product_list.get(i).author;
			String type = product_list.get(i).type;
			String publisher = product_list.get(i).publisher;
			String price = product_list.get(i).price;
			String pause = product_list.get(i).pause;
			System.out.println(pause);
			String str = "";
			if(pause == null) {
				str = "error";
			}
			if(pause.equals("1")) {
				str = "Yes";
			}
			if(pause.equals("0")) {
				str = "No";
			}
	%>
	<tr>
	<td align="left"><p><input type="checkbox" name="pauseItems" value="<%=title%>"></p></td>
	<td align="left"><p>Title:<%=title%></p></td>
	<td align="left"><p>Author:<%=author%></p></td>
	<td align="left"><p>Price:<%=price%></p></td>
	<td align="left"><p>Pause:<%=str%></p></td>
	</tr>
<% } %>
</table>
<table>
<tr>
	<td align="left"><input type="submit" name="action" value="Pause Item" class="button"></td>
	<td align="left"><input type="submit" name="action" value="Resume Item" class="button"></td>
</tr>
</table>
</form>

<% } %>

<%
	if(pageNo != 1 && product_list.size() != 0) {
%>
	<a href="http://localhost:8080/MyBookStore/seller_check_item.jsp?currPage=<%=pageNo - 1%>">Previous Page</a>
<%		
	}
%>
	Page: <%=currPage%>
<%
	if(pageNo != totalPage && product_list.size() != 0) {
%>
	<a href="http://localhost:8080/MyBookStore/seller_check_item.jsp?currPage=<%=pageNo + 1%>">Next Page</a>
<%		
	}
%>

<p></p>
<form action="seller_register_item.jsp" method="post">
<input type="submit" value="Register new item" class="button">
</form>

<%
	}
%>

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