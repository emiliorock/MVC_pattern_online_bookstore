package Servlet;

import java.io.*;
import java.util.*;
import DAO.ItemDAO;
import Data.Item;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public SaleServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		String current_seller = (String) request.getSession().getAttribute(
				"current_seller");

		ArrayList<String> product_list = new ArrayList();
		ItemDAO selling_list = new ItemDAO();
		ArrayList<Item> products = new ArrayList();
		products = selling_list.findSellerItem(current_seller);
		request.getSession().setAttribute("product_list", products);

		/*** Seller register a new item ***/
		if (action.equals("register_item")) {
			String title = request.getParameter("new_title");
			String author = request.getParameter("new_author");
			String type = request.getParameter("new_type");
			String date = request.getParameter("new_date");
			String price = request.getParameter("new_price");
			String seller = request.getParameter("new_seller");
			String publisher = request.getParameter("new_publisher");
			String pause = request.getParameter("new_pause");
			String p = new String();
			if (pause.equals("new_yes")) {
				p = "1";
			}
			if (pause.equals("new_no")) {
				p = "0";
			}
			// add the new item into DB
			ItemDAO itemDAO = new ItemDAO();
			itemDAO.insertOneItem(title, author, type, date, price, seller,
					publisher, p);
			System.out.println(title + "has been added to DB");
			ArrayList<Item> items = new ArrayList();
			items = ItemDAO.findSellerItem(current_seller);
			request.getSession().setAttribute("product_list", items); 
			for (int i = 0; i < items.size(); i++) {
				System.out.println(items.get(i).title + "now the pause value is " + items.get(i).getPause());
			}
			RequestDispatcher rd = request
					.getRequestDispatcher("/seller_register_item.jsp");
			rd.forward(request, response);

		}

		/*** Seller pause a list of items ***/
		if (action.equals("Pause Item")) {
			String[] pauseList = (String[]) request
					.getParameterValues("pauseItems");

			ItemDAO itemDAO = new ItemDAO();
			ArrayList<Item> results = new ArrayList();

			results = itemDAO.findSellerItem(current_seller);

			for (int i = 0; i < pauseList.length; i++) {
				for (int j = 0; j < results.size(); j++) {
					if (pauseList[i].equals(results.get(j).title)) {
						itemDAO.pauseOneItem(results.get(j).title, current_seller);
					}
				}
			}
			results = itemDAO.findSellerItem(current_seller);

			RequestDispatcher rd = request
					.getRequestDispatcher("/seller_check_item.jsp");
			rd.forward(request, response);
		}
		
		/*** Seller resume a list of items ***/
		if (action.equals("Resume Item")) {
			String[] pauseList = (String[]) request
					.getParameterValues("pauseItems");

			ItemDAO itemDAO = new ItemDAO();
			ArrayList<Item> list = new ArrayList();

			list = itemDAO.findSellerItem(current_seller);

			for (int i = 0; i < pauseList.length; i++) {
				for (int j = 0; j < list.size(); j++) {
					if (pauseList[i].equals(list.get(j).title)) {
						itemDAO.resumeOneItem(list.get(j).title, current_seller);
					}
				}
			}
			list = itemDAO.findSellerItem(current_seller);

			RequestDispatcher rd = request
					.getRequestDispatcher("/seller_check_item.jsp");
			rd.forward(request, response);
		}

	}

}