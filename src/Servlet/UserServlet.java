package Servlet;

import java.io.*;
import java.util.*;

import DAO.UserDAO;
import Data.Admin;
import Data.Seller;
import Data.User;
import Email.MyAuthenticator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public UserServlet() {
		super();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		/**** User Login ****/
		String action = request.getParameter("action");
		
		/*** User Login ***/
		if (action.equals("user_login")) {
			String usertype = request.getParameter("user_type");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			if (username == null || password == null) {
				request.setAttribute("error", "No username or password");
				RequestDispatcher rd = request
						.getRequestDispatcher("/login.jsp");
				rd.forward(request, response);
			}else {
				UserDAO userDAO = new UserDAO();
				ArrayList<User> users = new ArrayList();
				ArrayList<Seller> sellers = new ArrayList();
				ArrayList<Admin> admins = new ArrayList();
				
				/*** shopping users ***/
				if (usertype.equals("user")) {
					users = userDAO.findAllUser();
					int flag = 0;
					for (int i = 0; i < users.size(); i++) {
						if (username.toLowerCase().equals(
								users.get(i).getUsername())) {
							flag = 1;
							if (password.equals(users.get(i).getPassword())) {
								if (users.get(i).getBan().equals("0")) {
									// login succeed
									request.getSession().setAttribute(
											"current_user", username);
									request.getSession().setAttribute(
											"current_user", username);
									RequestDispatcher rd = request
											.getRequestDispatcher("/BasicSearch.jsp");
									rd.forward(request, response);
								}
								if (users.get(i).getBan().equals("1")) {
									request.setAttribute("error", "Ban User");
									RequestDispatcher rd = request
											.getRequestDispatcher("/login.jsp");
									rd.forward(request, response);
								}
							} else {
								// correct username, but incorrect password
								request.setAttribute("error",
										"Incorrect Password");
								RequestDispatcher rd = request
										.getRequestDispatcher("/login.jsp");
								rd.forward(request, response);
							}
						}
					}
					if (flag == 0) {
						// incorrect username
						request.setAttribute("error", "Incorrect Username");
						RequestDispatcher rd = request
								.getRequestDispatcher("/login.jsp");
						rd.forward(request, response);
					}
				}

				/*** book sellers ***/
				if (usertype.equals("seller")) {
					sellers = userDAO.findAllSeller();
					int flag = 0;
					for (int i = 0; i < sellers.size(); i++) {
						if (username.toLowerCase().equals(
								sellers.get(i).getUsername())) {
							flag = 1;
							if (password.equals(sellers.get(i).getPassword())) {
								if (sellers.get(i).ban.equals("0")) {
									// login succeed
									request.getSession().setAttribute(
											"current_seller", username);
									RequestDispatcher rd = request
											.getRequestDispatcher("/seller_check_item.jsp");
									rd.forward(request, response);
								}
								if (sellers.get(i).ban.equals("1")) {
									request.setAttribute("error", "Ban Seller");
									RequestDispatcher rd = request
											.getRequestDispatcher("/login.jsp");
									rd.forward(request, response);
								}
							} else {
								// correct username, but incorrect password
								request.setAttribute("error",
										"Incorrect Password");
								RequestDispatcher rd = request
										.getRequestDispatcher("/login.jsp");
								rd.forward(request, response);
							}
						}
					}
					if (flag == 0) {
						// incorrect username
						request.setAttribute("error", "Incorrect Username");
						RequestDispatcher rd = request
								.getRequestDispatcher("/login.jsp");
						rd.forward(request, response);
					}
				}

				/*** admins ***/
				if (usertype.equals("admin")) {
					admins = userDAO.findAllAdmin();
					int flag = 0;
					for (int i = 0; i < admins.size(); i++) {
						if (username.toLowerCase().equals(
								admins.get(i).getUsername())) {
							flag = 1;
							if (password.equals(admins.get(i).getPassword())) {
								// login succeed
								request.getSession().setAttribute(
										"current_admin", username);
								RequestDispatcher rd = request
										.getRequestDispatcher("/Admin.jsp");
								rd.forward(request, response);
							} else {
								// correct username, but incorrect password
								request.setAttribute("error",
										"Incorrect Password");
								RequestDispatcher rd = request
										.getRequestDispatcher("/login.jsp");
								rd.forward(request, response);
							}
						}
					}
					if (flag == 0) {
						// incorrect username
						request.setAttribute("error", "Incorrect Username");
						RequestDispatcher rd = request
								.getRequestDispatcher("/login.jsp");
						rd.forward(request, response);
					}
				}
			}
		}

		/*** User Sign Up ***/
		if (action.equals("user_signup")) {
			String username = request.getParameter("new_username");
			username.toLowerCase();
			String password = request.getParameter("new_password");
			String nickname = request.getParameter("new_nickname");
			String firstname = request.getParameter("new_firstname");
			String lastname = request.getParameter("new_lastname");
			String email = request.getParameter("new_email");
			String birthday = request.getParameter("new_birthday");
			String address = request.getParameter("new_address");
			String cardnumber = request.getParameter("new_cardnumber");
			String ban = "0";
			if (username == null || password == null || email == null) {
				request.setAttribute("error", "Sign up incompleted");
				RequestDispatcher rd = request
						.getRequestDispatcher("/signup.jsp");
				rd.forward(request, response);
			} else {
				UserDAO userDAO = new UserDAO();
				userDAO.insertOneUser(username, password, nickname, firstname,
						lastname, email, birthday, address, cardnumber, "1");
				MyAuthenticator sender = new MyAuthenticator();
				sender.ConfirmEmail(username, email, "user");
				System.out.println("Confirmation email sent!");
				RequestDispatcher rd = request
						.getRequestDispatcher("/sign_up_complete.jsp");
				rd.forward(request, response);
				ArrayList<User> users = new ArrayList();
				users = userDAO.findAllUser();
			}
		}

		/*** Seller Sign Up ***/
		if (action.equals("seller_signup")) {
			String username = request.getParameter("new_username");
			username.toLowerCase();
			String password = request.getParameter("new_password");
			String email = request.getParameter("new_email");
			String publisher = request.getParameter("new_publisher");
			String address = request.getParameter("new_address");
			if (username == null || password == null || email == null) {
				request.setAttribute("error", "Sign up incompleted");
				RequestDispatcher rd = request
						.getRequestDispatcher("/signup.jsp");
				rd.forward(request, response);
			} else {
				UserDAO userDAO = new UserDAO();
				userDAO.insertOneSeller(username, password, publisher, email,
						address, "1");
				MyAuthenticator sender = new MyAuthenticator();
				sender.ConfirmEmail(username, email, "seller");
				System.out.println("Confirmation email sent!");
				RequestDispatcher rd = request
						.getRequestDispatcher("/sign_up_complete.jsp");
				rd.forward(request, response);
			}
		}

		/*** User edit profile ***/
		if (action.equals("user_edit")) {
			String username = (String) request.getSession().getAttribute("current_user");
			String password = request.getParameter("edit_password");
			String nickname = request.getParameter("edit_nickname");
			String firstname = request.getParameter("edit_firstname");
			String lastname = request.getParameter("edit_lastname");
			String email = request.getParameter("edit_email");
			String birthday = request.getParameter("edit_birthday");
			String address = request.getParameter("edit_address");
			String cardnumber = request.getParameter("edit_cardnumber");
			UserDAO userDAO = new UserDAO();
			userDAO.UpateOneUser(username, password, nickname, firstname, lastname, email, birthday, address, cardnumber);
			MyAuthenticator sender = new MyAuthenticator();
			sender.ConfirmEmail(username, email, "user");
			System.out.println("Confirmation email sent!");
			RequestDispatcher rd = request
					.getRequestDispatcher("/edit_complete.jsp");
			rd.forward(request, response);
		}
		
		/*** Seller edit profile ***/
		if (action.equals("seller_edit")) {
			String username = (String) request.getSession().getAttribute("current_seller");
			String password = request.getParameter("edit_password");
			String publisher = request.getParameter("edit_publisher");
			String email = request.getParameter("edit_email");
			String address = request.getParameter("edit_address");
			UserDAO userDAO = new UserDAO();
			userDAO.UpateOneSeller(username, password, publisher, email, address);
			MyAuthenticator sender = new MyAuthenticator();
			sender.ConfirmEmail(username, email, "user");
			System.out.println("Confirmation email sent!");
			RequestDispatcher rd = request
					.getRequestDispatcher("/edit_complete.jsp");
			rd.forward(request, response);
		}
		
	}
}