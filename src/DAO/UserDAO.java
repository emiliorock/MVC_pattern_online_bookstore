package DAO;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.derby.client.am.Connection;
import org.apache.derby.client.am.ResultSet;
import org.apache.derby.client.am.Statement;

import Data.Admin;
import Data.Seller;
import Data.User;

public class UserDAO {

	/*** shopping users ***/
	public ArrayList findAllUser() {
		ArrayList<User> userList = new ArrayList();
		String url = "jdbc:derby://localhost:1527/bookstore;create=true";
		String username = "user";
		String password = "123";
		Connection con = null;
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			con = (Connection) DriverManager.getConnection(url, username,
					password);
			Statement st = (Statement) con.createStatement();
			ResultSet rec = (ResultSet) st
					.executeQuery("select * FROM TBL_USER");
			while (rec.next()) {
				User user = new User();
				user.setUsername(rec.getString(1));
				user.setPassword(rec.getString(2));
				user.setNickname(rec.getString(3));
				user.setFirstname(rec.getString(4));
				user.setLastname(rec.getString(5));
				user.setEmail(rec.getString(6));
				user.setBirthday(rec.getString(7));
				user.setAddress(rec.getString(8));
				user.setCardnumber(rec.getString(9));
				user.setBan(rec.getString(10));
				userList.add(user);
			}
			rec.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}
	
	public User findOneUser(String user) {
		System.out.println(user);
		String url = "jdbc:derby://localhost:1527/bookstore;create=true";
		String username = "user";
		String password = "123";
		Connection con = null;
		User auser = new User();
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			con = (Connection) DriverManager.getConnection(url, username,
					password);
			Statement st = (Statement) con.createStatement();
			ResultSet rec = (ResultSet) st
					.executeQuery("select * FROM TBL_USER WHERE Username = '" + user + "'");
			while (rec.next()) {
				auser.setUsername(rec.getString(1));
				auser.setPassword(rec.getString(2));
				auser.setNickname(rec.getString(3));
				auser.setFirstname(rec.getString(4));
				auser.setLastname(rec.getString(5));
				auser.setEmail(rec.getString(6));
				auser.setBirthday(rec.getString(7));
				auser.setAddress(rec.getString(8));
				auser.setCardnumber(rec.getString(9));
				auser.setBan(rec.getString(10));
			}
			rec.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("1" + auser.getUsername());
		return auser;
	}
	
	
	public Seller findOneSeller(String user) {
		System.out.println(user);
		String url = "jdbc:derby://localhost:1527/bookstore;create=true";
		String username = "user";
		String password = "123";
		Connection con = null;
		Seller auser = new Seller();
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			con = (Connection) DriverManager.getConnection(url, username,
					password);
			Statement st = (Statement) con.createStatement();
			ResultSet rec = (ResultSet) st
					.executeQuery("select * FROM TBL_SELLER WHERE Username = '" + user + "'");
			while (rec.next()) {
				auser.setUsername(rec.getString(1));
				auser.setPassword(rec.getString(2));
				auser.setPublisher(rec.getString(3));
				auser.setEmail(rec.getString(4));
				auser.setAddress(rec.getString(5));
				auser.setBan(rec.getString(6));
			}
			rec.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("1" + auser.getUsername());
		return auser;
	}

	public void insertOneUser(String username, String password,
			String nickname, String firstname, String lastname, String email,
			String birthday, String address, String cardnumber, String ban) {
		String url = "jdbc:derby://localhost:1527/bookstore;create=true";
		String user = "user";
		String pwd = "123";
		Connection con = null;
		PreparedStatement pst = null;
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			con = (Connection) DriverManager.getConnection(url, user, pwd);
			// con.setAutoCommit(true);
			String sqlInsert = "INSERT INTO TBL_USER VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pst = con.prepareStatement(sqlInsert);
			pst.setString(1, username);
			pst.setString(2, password);
			pst.setString(3, nickname);
			pst.setString(4, firstname);
			pst.setString(5, lastname);
			pst.setString(6, email);
			pst.setString(7, birthday);
			pst.setString(8, address);
			pst.setString(9, cardnumber);
			pst.setString(10, "1");
			pst.executeUpdate();
			pst.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean confirmOneUser(String username, String email) {
		String url = "jdbc:derby://localhost:1527/bookstore;create=true";
		String user = "user";
		String pwd = "123";
		Connection con = null;
		PreparedStatement pst = null;
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			con = (Connection) DriverManager.getConnection(url, user, pwd);
			// con.setAutoCommit(true);
			String sql = "UPDATE TBL_USER SET Ban = '0' WHERE Username = '" + username  + "' and Email = '" + email + "'";
			pst = con.prepareStatement(sql);
			pst.executeUpdate();
			pst.close();
			con.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public void UpateOneUser(String username, String password,
			String nickname, String firstname, String lastname, String email,
			String birthday, String address, String cardnumber) {
		String url = "jdbc:derby://localhost:1527/bookstore;create=true";
		String user = "user";
		String pwd = "123";
		Connection con = null;
		PreparedStatement pst = null;
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			con = (Connection) DriverManager.getConnection(url, user, pwd);
			System.out.println("flag2");
			if(password != null && password != "") {
				String sql = "UPDATE TBL_USER SET Password = '" + password + "' WHERE Username = '" + username  + "'";
				pst = con.prepareStatement(sql);
				pst.executeUpdate();
			}
			if(nickname != null && nickname != "") {
				String sql = "UPDATE TBL_USER SET Nickname = '" + nickname + "' WHERE Username = '" + username  + "'";
				pst = con.prepareStatement(sql);
				pst.executeUpdate();
			}
			if(firstname != null && firstname != "") {
				String sql = "UPDATE TBL_USER SET Firstname = '" + firstname + "' WHERE Username = '" + username  + "'";
				pst = con.prepareStatement(sql);
				pst.executeUpdate();
			}
			if(lastname != null && lastname != "") {
				String sql = "UPDATE TBL_USER SET Lastname = '" + lastname + "' WHERE Username = '" + username  + "'";
				pst = con.prepareStatement(sql);
				pst.executeUpdate();
			}
			if(email != null && email != "") {
				String sql = "UPDATE TBL_USER SET Email = '" + email + "' WHERE Username = '" + username  + "'";
				pst = con.prepareStatement(sql);
				pst.executeUpdate();
			}
			if(birthday != null && birthday != "") {
				String sql = "UPDATE TBL_USER SET YearOfBirth = '" + birthday + "' WHERE Username = '" + username  + "'";
				pst = con.prepareStatement(sql);
				pst.executeUpdate();
			}
			if(address != null && address != "") {
				String sql = "UPDATE TBL_USER SET FullAddress = '" + address + "' WHERE Username = '" + username  + "'";
				pst = con.prepareStatement(sql);
				pst.executeUpdate();
			}
			if(cardnumber != null && cardnumber != "") {
				String sql = "UPDATE TBL_USER SET CardNumber = '" + cardnumber + "' WHERE Username = '" + username  + "'";
				pst = con.prepareStatement(sql);
				pst.executeUpdate();
			}
			pst.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*** book sellers ***/
	public ArrayList findAllSeller() {
		ArrayList<Seller> sellerList = new ArrayList();
		String url = "jdbc:derby://localhost:1527/bookstore;create=true";
		String username = "user";
		String password = "123";
		Connection con = null;
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			con = (Connection) DriverManager.getConnection(url, username,
					password);
			Statement st = (Statement) con.createStatement();
			ResultSet rec = (ResultSet) st
					.executeQuery("select * FROM TBL_SELLER");
			while (rec.next()) {
				Seller seller = new Seller();
				seller.setUsername(rec.getString(1));
				seller.setPassword(rec.getString(2));
				seller.setPublisher(rec.getString(3));
				seller.setEmail(rec.getString(4));
				seller.setAddress(rec.getString(5));
				seller.setBan(rec.getString(6));
				sellerList.add(seller);
			}
			rec.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sellerList;
	}

	public void insertOneSeller(String username, String password,
			String publisher, String email, String address, String ban) {
		String url = "jdbc:derby://localhost:1527/bookstore;create=true";
		String user = "user";
		String pwd = "123";
		Connection con = null;
		PreparedStatement pst = null;
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			con = (Connection) DriverManager.getConnection(url, user, pwd);
			// con.setAutoCommit(true);
			String sqlInsert = "INSERT INTO TBL_SELLER VALUES(?, ?, ?, ?, ?, ?) ";
			pst = con.prepareStatement(sqlInsert);
			pst.setString(1, username);
			pst.setString(2, password);
			pst.setString(3, publisher);
			pst.setString(4, email);
			pst.setString(5, address);
			pst.setString(6, "1");
			pst.executeUpdate();
			pst.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean confirmOneSeller(String username, String email) {
		String url = "jdbc:derby://localhost:1527/bookstore;create=true";
		String user = "user";
		String pwd = "123";
		Connection con = null;
		PreparedStatement pst = null;
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			con = (Connection) DriverManager.getConnection(url, user, pwd);
			// con.setAutoCommit(true);
			String sql = "UPDATE TBL_SELLER SET Ban = '0' WHERE Username = '" + username  + "' and Email = '" + email + "'";
			pst = con.prepareStatement(sql);
			pst.executeUpdate();
			pst.close();
			con.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public void UpateOneSeller (String username, String password,
			String publisher, String email, String address) {
		String url = "jdbc:derby://localhost:1527/bookstore;create=true";
		String user = "user";
		String pwd = "123";
		Connection con = null;
		PreparedStatement pst = null;
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			con = (Connection) DriverManager.getConnection(url, user, pwd);
			System.out.println("flag2");
			if(password != null && password != "") {
				String sql = "UPDATE TBL_SELLER SET Password = '" + password + "' WHERE Username = '" + username  + "'";
				pst = con.prepareStatement(sql);
				pst.executeUpdate();
			}
			if(publisher != null && publisher != "") {
				String sql = "UPDATE TBL_SELLER SET Publisher = '" + publisher + "' WHERE Username = '" + username  + "'";
				pst = con.prepareStatement(sql);
				pst.executeUpdate();
			}
			if(email != null && email != "") {
				String sql = "UPDATE TBL_USER SET Email = '" + email + "' WHERE Username = '" + username  + "'";
				pst = con.prepareStatement(sql);
				pst.executeUpdate();
			}
			if(address != null && address != "") {
				String sql = "UPDATE TBL_USER SET FullAddress = '" + address + "' WHERE Username = '" + username  + "'";
				pst = con.prepareStatement(sql);
				pst.executeUpdate();
			}
			pst.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*** admin ***/
	public ArrayList findAllAdmin() {
		ArrayList<Admin> adminList = new ArrayList();
		String url = "jdbc:derby://localhost:1527/bookstore;create=true";
		String username = "user";
		String password = "123";
		Connection con = null;
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			con = (Connection) DriverManager.getConnection(url, username,
					password);
			Statement st = (Statement) con.createStatement();
			ResultSet rec = (ResultSet) st
					.executeQuery("select * FROM TBL_ADMIN");
			while (rec.next()) {
				Admin admin = new Admin();
				admin.setUsername(rec.getString(1));
				admin.setPassword(rec.getString(2));
				admin.setEmail(rec.getString(3));
				adminList.add(admin);
			}
			rec.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adminList;
	}
	
}
