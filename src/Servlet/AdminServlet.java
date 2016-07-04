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
import Data.Item;

public class AdminServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String Choose = request.getParameter("Choose");
		String i = request.getParameter("index");
		ArrayList<Item> SellItem = (ArrayList<Item>) request.getSession().getAttribute("SellItem");
		ArrayList<Item> RemoveSearchItem = (ArrayList<Item>) request.getSession().getAttribute("RemoveSearchItem");
		String Remove = request.getParameter("remove");
		AdminFunc use = new AdminFunc();

		if (Choose.equals("Remove Item"))
		{
			String num = i.substring(0, i.length() - 1);
			int index = Integer.valueOf(num).intValue();
			String NodeTitle = SellItem.get(index).getTitle();
			SellItem.remove(index);
			try
			{
				use.RmFromTBItem(NodeTitle);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			if (!SellItem.isEmpty())
			{
				request.getRequestDispatcher("ItemSell.jsp").forward(request,response);
			} 
			else
			{
				request.setAttribute("Type", "NoRemoveItem");
				request.getRequestDispatcher("NoItem.jsp").forward(request,	response);
			}
		}
		else if (Choose.equals("Search Item"))
		{
			try
			{
				RemoveSearchItem = use.RemoveSearch(Remove);
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
			if (!RemoveSearchItem.isEmpty())
			{
				request.setAttribute("RemoveSearchItem", RemoveSearchItem);
				request.getRequestDispatcher("RemoveSearchResult.jsp").forward(request,response);
			} 
			else
			{
				request.setAttribute("Type", "NoRemoveSearchItem");
				request.getRequestDispatcher("NoItem.jsp").forward(request,	response);
			}
		}
		else if (Choose.equals("Remove Item Searched"))
		{
			String num = i.substring(0, i.length() - 1);
			int index = Integer.valueOf(num).intValue();
			String NodeTitle = RemoveSearchItem.get(index).getTitle();
			RemoveSearchItem.remove(index);
			try
			{
				use.RmFromTBItem(NodeTitle);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			request.getRequestDispatcher("ItemSell.jsp").forward(request,response);
		}
	}
}
