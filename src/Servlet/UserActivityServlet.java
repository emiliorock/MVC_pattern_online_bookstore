package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.derby.client.am.Connection;
import org.apache.derby.client.am.ResultSet;
import org.apache.derby.client.am.Statement;

import DAO.AdminFunc;
import Data.User;

public class UserActivityServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String name = request.getParameter("keyusername");
		AdminFunc use = new AdminFunc();
		ArrayList<User> UserList = (ArrayList<User>) request.getSession()
				.getAttribute("UserList");
		ArrayList<User> SearchUserList = (ArrayList<User>) request.getSession()
				.getAttribute("SearchUserList");
		String[] bani = (String[]) request.getParameterValues("banindex");
		String Choose = request.getParameter("Choose");

		if (Choose.equals("Ban User"))
		{
			for (String i : bani)
			{
				String num = i.substring(0, i.length() - 1);
				int index = Integer.valueOf(num).intValue();
				String BanUserName = UserList.get(index).getUsername();
				try
				{
					use.BanUser(BanUserName);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			request.getRequestDispatcher("Admin.jsp")
					.forward(request, response);
		} else if (Choose.equals("Search User"))
		{
			try
			{
				SearchUserList = use.UsernameSearch(name);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			if (!SearchUserList.isEmpty())
			{
				request.setAttribute("SearchUserList", SearchUserList);
				request.getRequestDispatcher("UserSearchResult.jsp").forward(
						request, response);
			} else
			{
				request.setAttribute("Type", "NoUser");
				request.getRequestDispatcher("NoItem.jsp").forward(request,
						response);
			}
		} else if (Choose.equals("Ban Search User"))
		{
			for (String i : bani)
			{
				String num = i.substring(0, i.length() - 1);
				int index = Integer.valueOf(num).intValue();
				String BanUserName = SearchUserList.get(index).getUsername();
				try
				{
					use.BanUser(BanUserName);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			request.getRequestDispatcher("Admin.jsp").forward(request, response);
		}
		else if (Choose.equals("Free User"))
		{
			for (String i : bani)
			{
				String num = i.substring(0, i.length() - 1);
				int index = Integer.valueOf(num).intValue();
				System.out.println(index);
				String FreeUserName = UserList.get(index).getUsername();
				try
				{
					use.FreeUser(FreeUserName);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			request.getRequestDispatcher("Admin.jsp").forward(request, response);
		}
		else if (Choose.equals("Free Search User"))
		{
			for (String i : bani)
			{
				String num = i.substring(0, i.length() - 1);
				int index = Integer.valueOf(num).intValue();
				String FreeUserName = SearchUserList.get(index).getUsername();
				try
				{
					use.FreeUser(FreeUserName);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			request.getRequestDispatcher("Admin.jsp").forward(request, response);
		}
	}
}
