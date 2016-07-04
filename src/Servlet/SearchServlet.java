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

import DAO.Control;
import Data.Item;

public class SearchServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String SearchType = (String) request.getSession().getAttribute("SearchType");		
		String pickTitle = request.getParameter("title");	
		String pickAuthor = request.getParameter("author");
		String pickPrice = request.getParameter("price");
		String pickSeller = request.getParameter("seller");		
		Control use = new Control();
		ArrayList<Item> SearchItem = new ArrayList<Item>();
		try
		{
			if (SearchType.equals("BasicSearch"))
			{
				SearchItem = use.BasicSearch(pickTitle, pickAuthor, pickPrice, pickSeller);
			}
			else if (SearchType.equals("AdvancedSearch"))
			{
				SearchItem = use.AdvancedSearch(pickTitle, pickAuthor, pickPrice, pickSeller);
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		if (!SearchItem.isEmpty())
		{
			request.setAttribute("SearchItem", SearchItem);
			request.setAttribute("title", pickTitle);
			request.setAttribute("author", pickAuthor);
			request.setAttribute("price", pickPrice);
			request.setAttribute("seller", pickSeller);
			request.getRequestDispatcher("success.jsp").forward(request,response);	
		}
		else
		{
			request.getRequestDispatcher("fail.jsp").forward(request, response);
		}
	}

}
