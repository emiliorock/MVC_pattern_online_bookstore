package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
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
import Email.MyAuthenticator;

public class ShoppingServlet extends HttpServlet
{
	ArrayList<Item> CartItem = new ArrayList<Item>();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		Item node = (Item) request.getSession().getAttribute("node");
		String Username = (String) request.getSession().getAttribute(
				"current_user");
		ArrayList<Item> SearchItem = (ArrayList<Item>) request.getSession()
				.getAttribute("SearchItem");

		String[] indexi = (String[]) request.getParameterValues("index");

		String pass = (String) request.getSession().getAttribute("pass");
		Control use = new Control();
		String Choose = request.getParameter("Choose");
		String i = request.getParameter("cartname");
		Timestamp time = new Timestamp(System.currentTimeMillis());

		if (Choose == null || Choose.equals("Remove from Cart"))
		{
			if (pass.equals("unpass"))
			{
				for (String indexiUse : indexi)
				{
					String num = indexiUse.substring(0, indexiUse.length() - 1);
					int index = Integer.valueOf(num).intValue();
					Item node1 = SearchItem.get(index);
					int flag = 0;
					for (int j = 0; j < CartItem.size(); ++j)
					{
						if (node1.getTitle().equals(CartItem.get(j).getTitle()))
						{
							flag = 1;
							break;
						}
					}
					if (flag == 1)
					{
						continue;
					} else if (flag == 0)
					{
						CartItem.add(node1);
						try
						{
							use.AddToTBCart(node1, Username, time.toString());
						} catch (Exception e)
						{
							e.printStackTrace();
						}
					}
				}
			} else if (pass.equals("pass"))
			{
				int flag = 0;
				for (int j = 0; j < CartItem.size(); ++j)
				{
					if (node.getTitle().equals(CartItem.get(j).getTitle()))
					{
						flag = 1;
						break;
					}
				}
				if (flag == 0)
				{
					CartItem.add(node);
					try
					{
						use.AddToTBCart(node, Username, time.toString());
					} catch (Exception e)
					{
						e.printStackTrace();
					}
				}
			} else if (pass.equals("neverpass"))
			{
				String num = i.substring(0, i.length() - 1);
				int index = Integer.valueOf(num).intValue();
				try
				{
					use.AddToTBAdRe(CartItem.get(index), Username,
							time.toString());
					use.RmFromTBCart(CartItem.get(index), Username);
					CartItem.remove(index);
				} catch (Exception e)
				{
					e.printStackTrace();
				}

			}

			if (!CartItem.isEmpty())
			{
				request.setAttribute("cart", CartItem);
				request.getRequestDispatcher("cart.jsp").forward(request,
						response);
			} else
			{
				request.getRequestDispatcher("nocart.jsp").forward(request,
						response);
			}

		} else if (Choose.equals("Buy Item"))
		{
			MyAuthenticator email = new MyAuthenticator();
			String num = i.substring(0, i.length() - 1);
			int index = Integer.valueOf(num).intValue();
			String SellerName = CartItem.get(index).getSeller();
			try
			{
				use.AddToTBBuy(CartItem.get(index), Username, time.toString());
			} catch (Exception e1)
			{
				e1.printStackTrace();
			}
			try
			{
				email.SendEmail(use.GetSellerEmail(SellerName), "The Item "
						+ CartItem.get(index).getTitle() + " has been sold!");
			} catch (Exception e)
			{
				e.printStackTrace();
			}

			request.setAttribute("SellerName", SellerName);
			request.getRequestDispatcher("Email.jsp")
					.forward(request, response);
		}

	}
}