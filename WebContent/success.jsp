<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page import="java.util.*"%>
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="layout.css"/>
<title>Search Result Page</title>
</head>

<%
String current_user = (String) request.getSession().getAttribute("current_user");
request.getSession().setAttribute("current_user", current_user);
%>

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
			<p><h1>Shopping</h1></p>
				<p><h2><a href="http://localhost:8080/MyBookStore/cart.jsp">Shopping Cart</a></h2></p>
			<p><h1>Log In as <%=current_user%></h1></p>
				<p><h2><a href="http://localhost:8080/MyBookStore/user_profile.jsp">User Profile</a></h2></p>
				<p><h2><a href="http://localhost:8080/MyBookStore/login.jsp">Log out</a></h2></p>
		</div>
	</div>

<%! int PAGESIZE = 10; int pageCount; int curPage = 1;%>
<%@ page import="Data.Item"%>
<%
ArrayList<Item> SearchItem = (ArrayList<Item>)request.getAttribute("SearchItem");
if (SearchItem== null)
{
	SearchItem = (ArrayList<Item>)session.getAttribute("SearchItem");
}

String title = (String)request.getAttribute("title");
if (title== null)
{
	title = (String)session.getAttribute("title");
}
String author = (String)request.getAttribute("author");
if (author== null)
{
	author = (String)session.getAttribute("author");
}
String price = (String)request.getAttribute("price");
if (price== null)
{
	price = (String)session.getAttribute("price");
}
String seller = (String)request.getAttribute("seller");
if (seller== null)
{
	seller = (String)session.getAttribute("seller");
}

int size = SearchItem.size();

pageCount = (size%PAGESIZE==0)?(size/PAGESIZE):(size/PAGESIZE+1); 
String tmp = request.getParameter("curPage");
String tmp1 = request.getParameter("pagecount");
if(tmp==null)
{  
    tmp="1";  
} 
curPage = Integer.valueOf(tmp);
if (tmp1 != null)
{
	pageCount = Integer.valueOf(tmp1);
}
session.setAttribute("SearchItem", SearchItem);
session.setAttribute("pass", "unpass");
session.setAttribute("title", title);
session.setAttribute("author", author);
session.setAttribute("price", price);
session.setAttribute("seller", seller);

%>
	<center>
		<div class="mainContent">
			<div class="middle">
	
		<FORM ACTION='forwardshopping' METHOD='POST'>
		<h2>Search Result</h2>
		You Search by
		<%if (!title.equals("")) 
		{%>
		Title <B><%=title %></B>
		<%}
		if (!author.equals("")) 
		{%>
		Author <B><%=author %></B>
		<%}
		if (!price.equals("")) 
		{%>
		Price <B><%=price %></B>
		<%}
		if (!seller.equals("")) 
		{%>
		Seller <B><%=seller %></B>
		<%}%>
		<br><br>
		<%if(pageCount > 1)
		{%>
			<%if(curPage != 1 && curPage != pageCount) 
			{%>
			<table>
				<%for (int i = (curPage-1)*10; i <= (curPage-1)*10+9; ++i) 
				{%>
				<tr>
					<td><input type="checkbox" name="index" value=<%=i%>/></td>
					<td><a href=information.jsp?getarticle=<%=i%>><%=i+1%> Title: <%=SearchItem.get(i).getTitle() %></a></td>
					<td>&nbsp Author: <%=SearchItem.get(i).getAuthor()%></td>
					<td>&nbsp Price: <%=SearchItem.get(i).getPrice()%></td>
					<td>&nbsp Seller: <%=SearchItem.get(i).getSeller()%></td>
				</tr>
				<%} %>
			</table>
			<br> <br>
			<a href =success.jsp?curPage=<%=curPage-1%>>prev</a>  
			&nbsp <%=curPage %> &nbsp
			<a href =success.jsp?curPage=<%=curPage+1%>>next</a> 
			<br><br>Total Page: <%=pageCount %>
			<%} 
			else if (curPage == 1)
			{%>
			<table>
				<%for (int i = (curPage-1)*10; i <= (curPage-1)*10+9; ++i) 
				{%>
				<tr>
					<td><input type="checkbox" name="index" value=<%=i%>/></td>
					<td><a href=information.jsp?getarticle=<%=i%>>
					<%=i+1%> Title: <%=SearchItem.get(i).getTitle() %></a></td>
					<td>&nbsp Author: <%=SearchItem.get(i).getAuthor()%></td>
					<td>&nbsp Price: <%=SearchItem.get(i).getPrice()%></td>
					<td>&nbsp Seller: <%=SearchItem.get(i).getSeller()%></td>
				</tr>
				<%} %>
			</table>
			<br> <br>
			Page:&nbsp 1 &nbsp
			<a href =success.jsp?curPage=<%=curPage+1%>>next</a> <br><br>Total Page: <%=pageCount %>
			<%} 
			else if (curPage == pageCount)
			{%>
			<table>
				<%for (int i = (curPage-1)*10; i < size; ++i)
				{%>
				<tr>
					<td><input type="checkbox" name="index" value=<%=i%>/></td>
					<td><a href=information.jsp?getarticle=<%=i%>>
					<%=i+1%> Title: <%=SearchItem.get(i).getTitle() %></a></td>
					<td>&nbsp Author: <%=SearchItem.get(i).getAuthor()%></td>
					<td>&nbsp Price: <%=SearchItem.get(i).getPrice()%></td>
					<td>&nbsp Seller: <%=SearchItem.get(i).getSeller()%></td>
				</tr>
				<%} %>
			</table>
			<br> <br>
			Page:&nbsp <%=pageCount %> &nbsp
			<a href =success.jsp?curPage=<%=curPage-1%>>prev</a> <br><br>Total Page: <%=pageCount %>
			<%}
		}
		else if (pageCount == 1)
		{%>
			<table>
				<%for (int i = 0; i < size; ++i) 
				{%>
				<tr>
					<td><input type="checkbox" name="index" value=<%=i%>/></td>
					<td><a href=information.jsp?getarticle=<%=i%>>
					<%=i+1%> Title: <%=SearchItem.get(i).getTitle() %></a></td>
					<td>&nbsp Author: <%=SearchItem.get(i).getAuthor()%></td>
					<td>&nbsp Price: <%=SearchItem.get(i).getPrice()%></td>
					<td>&nbsp Seller: <%=SearchItem.get(i).getSeller()%></td>
				</tr>
				<%} %>
			</table>
			<br> <br>
		<%} %>			
		<br> <br>
		<% if(!current_user.equals("UnKnown")) {%>
		<input type='submit' value='Add to Cart' class="button">
		<% }%>
		</FORM>
		
		<form action="BasicSearch.jsp" method="post">
		<input type="submit" value="Back to Search" class="button">
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
