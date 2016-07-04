<%@ page import="Data.Item"%>
<%@ page import="DAO.AdminFunc"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link rel="stylesheet" type="text/css" href="layout.css"/>
<title>Managing Items</title>
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

<%! int PAGESIZE = 10; int pageCount; int curPage = 1;%>
<%
AdminFunc use = new AdminFunc();
ArrayList<Item> SellItem = use.GetSellItem();
int size = SellItem.size();

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
session.setAttribute("SellItem", SellItem);
%>
	<center>
	
	<div class="mainContent">
		<div class="middle">
		
		<FORM ACTION='forwardadmin' METHOD='POST'>
		
		<h2>All Items</h2>
		
		<table>
		<tr>
		<td align="left">Search for an item:</td>
		<td align="left"><input type="text" name="remove" /></td>
		<td align="left"><input type="submit" name='Choose' value='Search Item' class="button"></td>
		</tr>
		</table>
	
		<%if(pageCount > 1)
		{%>
			<%if(curPage != 1 && curPage != pageCount) 
			{%>
			<table>
				<%for (int i = (curPage-1)*10; i <= (curPage-1)*10+9; ++i) 
				{%>
				<tr>
					<td><input type="radio" name="index" value=<%=i%>/></td>
					<td><%=i+1%> Title: <%=SellItem.get(i).getTitle() %></td>
					<td>Author: <%=SellItem.get(i).getAuthor()%></td>
					<%if (SellItem.get(i).getPause().equals("0")) 
					{%>
						<td>&nbsp  Pause: No</td>
					<%}
					else if (SellItem.get(i).getPause().equals("1"))
					{%>
						<td>&nbsp  Pause: Yes</td>
					<%}%>
				</tr>
				<%} %>
			</table>
			<br> <br>
			<a href =ItemSell.jsp?curPage=<%=curPage-1%>>prev</a>  
			&nbsp <%=curPage %> &nbsp
			<a href =ItemSell.jsp?curPage=<%=curPage+1%>>next</a> 
			<br><br>Total Page: <%=pageCount %>
			<%} 
			else if (curPage == 1)
			{%>
			<table>
				<%for (int i = (curPage-1)*10; i <= (curPage-1)*10+9; ++i) 
				{%>
				<tr>
					<td><input type="radio" name="index" value=<%=i%>/></td>
					<td><%=i+1%> Title: <%=SellItem.get(i).getTitle() %></td>
					<td>Author: <%=SellItem.get(i).getAuthor()%></td>
					<%if (SellItem.get(i).getPause().equals("0")) 
					{%>
						<td>&nbsp  Pause: No</td>
					<%}
					else if (SellItem.get(i).getPause().equals("1"))
					{%>
						<td>&nbsp  Pause: Yes</td>
					<%}%>
				</tr>
				<%} %>
			</table>
			<br> <br>
			<a href =ItemSell.jsp?curPage=<%=curPage+1%>>next</a> <br><br>Total Page: <%=pageCount %>
			<%} 
			else if (curPage == pageCount)
			{%>
			<table>
				<%for (int i = (curPage-1)*10; i < size; ++i)
				{%>
				<tr>
					<td><input type="radio" name="index" value=<%=i%>/></td>
					<td><%=i+1%> Title: <%=SellItem.get(i).getTitle() %></td>
					<td>Author: <%=SellItem.get(i).getAuthor()%></td>
					<%if (SellItem.get(i).getPause().equals("0")) 
					{%>
						<td>&nbsp  Pause: No</td>
					<%}
					else if (SellItem.get(i).getPause().equals("1"))
					{%>
						<td>&nbsp  Pause: Yes</td>
					<%}%>
				</tr>
				<%} %>
			</table>
			<br> <br>
			<a href =ItemSell.jsp?curPage=<%=curPage-1%>>prev</a> <br><br>Total Page: <%=pageCount %>
			<%}
		}
		else if (pageCount == 1)
		{%>
			<table>
				<%for (int i = 0; i < size; ++i) 
				{%>
				<tr>
					<td><input type="radio" name="index" value=<%=i%>/></td>
					<td><%=i+1%> Title: <%=SellItem.get(i).getTitle() %></a></td>
					<td>Author: <%=SellItem.get(i).getAuthor()%></td>
					<%if (SellItem.get(i).getPause().equals("0")) 
					{%>
						<td>&nbsp  Pause: No</td>
					<%}
					else if (SellItem.get(i).getPause().equals("1"))
					{%>
						<td>&nbsp  Pause: Yes</td>
					<%}%>
				</tr>
				<%} %>
			</table>
			<br> <br>
		<%} %>	
		<br><br>
		
		<table>
		<tr>
		<td align="left"><input type='submit' name='Choose' value='Remove Item' class="button"></td>
		</FORM>
		
		<form action="Admin.jsp" method="post">
		<td align="left"><input type="submit" value="Back To Admin page" class="button"></td>
		</form>
		</tr>
		</table>
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