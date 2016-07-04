package DAO;

import Data.Item;

import java.io.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import org.apache.derby.client.am.Connection;
import org.apache.derby.client.am.ResultSet;
import org.apache.derby.client.am.Statement;

public class ItemDAO {

	public static ArrayList findAllItem() {
		ArrayList<Item> itemList = new ArrayList();
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
					.executeQuery("select * FROM TBL_ITEM");
			while (rec.next()) {
				Item item = new Item();
				item.setTitle(rec.getString("Title"));
				item.setAuthor(rec.getString("Authors"));
				item.setType(rec.getString("PublicationType"));
				item.setDate(rec.getString("PublicationDate"));
				item.setPrice(rec.getString("Price"));
				item.setSeller(rec.getString("Seller"));
				item.setPublisher(rec.getString("Publisher"));
				item.setPause(rec.getString("Pause"));
				itemList.add(item);
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
		return itemList;
	}

	public void insertOneItem(String title, String author, String type,
			String date, String price, String seller, String publisher,
			String pause) {
		System.out.println(pause);
		String url = "jdbc:derby://localhost:1527/bookstore;create=true";
		String user = "user";
		String pwd = "123";
		Connection con = null;
		PreparedStatement pst = null;
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			con = (Connection) DriverManager.getConnection(url, user, pwd);
			// con.setAutoCommit(true);
			String sqlInsert = "INSERT INTO TBL_ITEM VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			pst = con.prepareStatement(sqlInsert);
			pst.setString(1, title);
			pst.setString(2, author);
			pst.setString(3, type);
			pst.setString(4, date);
			pst.setString(5, price);
			pst.setString(6, seller);
			pst.setString(7, publisher);
			pst.setString(8, pause);
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

	public static ArrayList findSellerItem(String seller) {
		ArrayList<Item> itemList = new ArrayList();
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
					.executeQuery("SELECT * FROM TBL_ITEM");
			while (rec.next()) {
				Item item = new Item();
				item.setTitle(rec.getString("Title"));
				item.setAuthor(rec.getString("Authors"));
				item.setType(rec.getString("PublicationType"));
				item.setDate(rec.getString("PublicationDate"));
				item.setPrice(rec.getString("Price"));
				item.setSeller(rec.getString("Seller"));
				item.setPublisher(rec.getString("Publisher"));
				item.setPause(rec.getString("Pause"));
				if (item.seller.equals(seller)) {
					itemList.add(item);
				}
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
		return itemList;
	}

	public void pauseOneItem(String title, String seller) {
		String url = "jdbc:derby://localhost:1527/bookstore;create=true";
		String user = "user";
		String pwd = "123";
		Connection con = null;
		PreparedStatement pst = null;
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			con = (Connection) DriverManager.getConnection(url, user, pwd);
			// con.setAutoCommit(true);
			String sql = "UPDATE TBL_ITEM SET Pause = '1' WHERE Title = '" + title  + "' and Seller = '" + seller + "'";
			pst = con.prepareStatement(sql);
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
	
	public void resumeOneItem(String title, String seller) {
		String url = "jdbc:derby://localhost:1527/bookstore;create=true";
		String user = "user";
		String pwd = "123";
		Connection con = null;
		PreparedStatement pst = null;
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			con = (Connection) DriverManager.getConnection(url, user, pwd);
			// con.setAutoCommit(true);
			String sql = "UPDATE TBL_ITEM SET Pause = '0' WHERE Title = '" + title  + "' and Seller = '" + seller + "'";
			pst = con.prepareStatement(sql);
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
}
