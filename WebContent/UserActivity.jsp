<%@ page import="Data.User"%>
<%@ page import="DAO.AdminFunc"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link rel="stylesheet" type="text/css" href="layout.css" />
<title>Managing Users</title>
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
ArrayList<User> UserList = use.GetUser();

int size = UserList.size();

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
session.setAttribute("UserList", UserList);
session.setAttribute("List", "UserList");
%>
<center>

	<div class="mainContent">
		<div class="middle">
		
		<FORM ACTION='forwardactivity' METHOD='POST'>
		
		<h2>All Users</h2>
		
		<p></p>
		<table>
		<tr>
		<td align="left">Search for an user:</td>
		<td align="left"><input type="text" name="keyusername" /></td>
		<td align="left"><input type='submit' name = 'Choose'value='Search User' class="button"></td>
		</tr>
		</table>	

		<p></p>
		
		<%if(pageCount > 1)
		{%>
			<%if(curPage != 1 && curPage != pageCount) 
			{%>
			<table>
				<%for (int i = (curPage-1)*10; i <= (curPage-1)*10+9; ++i) 
				{%>
				<tr>
					<td><input type="checkbox" name="banindex" value=<%=i%>/></td>
					<td><a href=UserInfo.jsp?index=<%=i%>>
					<%=i+1%> Username: <%=UserList.get(i).getUsername() %></a></td>
					<td>Fullname: <%=UserList.get(i).getFirstname()%> <%=UserList.get(i).getLastname() %></td>
					<%if (UserList.get(i).getBan().equals("0")) 
					{%>
						<td>&nbsp  Ban: No</td>
					<%}
					else if (UserList.get(i).getBan().equals("1"))
					{%>
						<td>&nbsp  Ban: Yes</td>
					<%}%>
				</tr>
				<%} %>
			</table>
			<p></p>
			<a href =UserActivity.jsp?curPage=<%=curPage-1%>>prev</a>  
			&nbsp <%=curPage %> &nbsp
			<a href =UserActivity.jsp?curPage=<%=curPage+1%>>next</a> 
			<p></p>Total Page: <%=pageCount %>
			<%} 
			else if (curPage == 1)
			{%>
			<table>
				<%for (int i = (curPage-1)*10; i <= (curPage-1)*10+9; ++i) 
				{%>
				<tr>
					<td><input type="checkbox" name="banindex" value=<%=i%>/></td>
					<td><a href=UserInfo.jsp?index=<%=i%>>
					<%=i+1%> Username: <%=UserList.get(i).getUsername() %></a></td>
					<td>Fullname: <%=UserList.get(i).getFirstname()%> <%=UserList.get(i).getLastname() %></td>
					<%if (UserList.get(i).getBan().equals("0")) 
					{%>
						<td>&nbsp  Ban: No</td>
					<%}
					else if (UserList.get(i).getBan().equals("1"))
					{%>
						<td>&nbsp  Ban: Yes</td>
					<%}%>
				</tr>
				<%} %>
			</table>
			<p></p>
			<a href =UserActivity.jsp?curPage=<%=curPage+1%>>next</a> <br><br>Total Page: <%=pageCount %>
			<%} 
			else if (curPage == pageCount)
			{%>
			<table>
				<%for (int i = (curPage-1)*10; i < size; ++i)
				{%>
				<tr>
					<td><input type="checkbox" name="banindex" value=<%=i%>/></td>
					<td><a href=UserInfo.jsp?index=<%=i%>>
					<%=i+1%> Username: <%=UserList.get(i).getUsername() %></a></td>
					<td>Fullname: <%=UserList.get(i).getFirstname()%> <%=UserList.get(i).getLastname() %></td>
					<%if (UserList.get(i).getBan().equals("0")) 
					{%>
						<td>&nbsp  Ban: No</td>
					<%}
					else if (UserList.get(i).getBan().equals("1"))
					{%>
						<td>&nbsp  Ban: Yes</td>
					<%}%>
				</tr>
				<%} %>
			</table>
			<p></p>
			<a href =UserActivity.jsp?curPage=<%=curPage-1%>>prev</a> <br><br>Total Page: <%=pageCount %>
			<%}
		}
		else if (pageCount == 1)
		{%>
			<table>
				<%for (int i = 0; i < size; ++i) 
				{%>
				<tr>
					<td><input type="checkbox" name="banindex" value=<%=i%>/></td>
					<td><a href=UserInfo.jsp?index=<%=i%>>
					<%=i+1%> Username: <%=UserList.get(i).getUsername() %></a></td>
					<td>Fullname: <%=UserList.get(i).getFirstname()%> <%=UserList.get(i).getLastname() %></td>
					<%if (UserList.get(i).getBan().equals("0")) 
					{%>
						<td>&nbsp  Ban: No</td>
					<%}
					else if (UserList.get(i).getBan().equals("1"))
					{%>
						<td>&nbsp  Ban: Yes</td>
					<%}%>
				</tr>
				<%} %>
			</table>
			<p></p>
		<%} %>	
		<p></p>
		<input type='submit' name='Choose' value='Ban User' class="button">
		&nbsp &nbsp <input type='submit' name='Choose' value='Free User' class="button">
		</FORM>
		<p></p>
		<form action="Admin.jsp" method="post">
		<input type="submit" value="Back To Admin page" class="button">
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