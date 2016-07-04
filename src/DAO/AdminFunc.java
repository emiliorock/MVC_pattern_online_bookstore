package DAO;

import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.derby.client.am.Connection;
import org.apache.derby.client.am.PreparedStatement;
import org.apache.derby.client.am.ResultSet;
import org.apache.derby.client.am.Statement;

import Data.AdReActivity;
import Data.BuyActivity;
import Data.Item;
import Data.User;

public class AdminFunc
{
	public ArrayList<Item> GetSellItem() throws Exception
	{
		ArrayList<Item> SellItem = new ArrayList<Item>();
		String url = "jdbc:derby://localhost:1527/bookstore;create=true";
		String username = "user";
		String password = "123";
		Connection con = null;

		Class.forName("org.apache.derby.jdbc.ClientDriver");
		con = (Connection) DriverManager.getConnection(url, username, password);
		Statement st = (Statement) con.createStatement();
		ResultSet rec = (ResultSet) st.executeQuery("select * FROM TBL_ITEM");

		while (rec.next())
		{
			Item one = new Item(rec.getString(1), rec.getString(2),
					rec.getString(3), rec.getString(4), rec.getString(5),
					rec.getString(6), rec.getString(7), rec.getString(8));
			SellItem.add(one);
		}
		rec.close();
		st.close();

		return SellItem;
	}

	public void RmFromTBItem(String NodeTitle) throws Exception
	{
		String url = "jdbc:derby://localhost:1527/bookstore;create=true";
		String username = "user";
		String password = "123";

		Class.forName("org.apache.derby.jdbc.ClientDriver");
		Connection con = (Connection) DriverManager.getConnection(url,
				username, password);
		PreparedStatement pst = (PreparedStatement) con
				.prepareStatement("DELETE FROM TBL_ITEM WHERE Title = ?");
		pst.setString(1, NodeTitle);
		pst.executeUpdate();
		pst.close();
		con.close();
	}

	public ArrayList<Item> RemoveSearch(String Remove) throws Exception
	{
		ArrayList<Item> ItemList = new ArrayList<Item>();
		String url = "jdbc:derby://localhost:1527/bookstore;create=true";
		String username = "user";
		String password = "123";
		Connection con = null;

		Class.forName("org.apache.derby.jdbc.ClientDriver");
		con = (Connection) DriverManager.getConnection(url, username, password);
		Statement st = (Statement) con.createStatement();
		ResultSet rec = (ResultSet) st.executeQuery("select * FROM TBL_ITEM");

		ResultSetMetaData rsmd = rec.getMetaData();
		int count = rsmd.getColumnCount();
		String[] name = new String[count];
		for (int i = 0; i < count; i++)
		{
			name[i] = rsmd.getColumnName(i + 1);
		}

		while (rec.next())
		{
			for (int i = 0; i < count; i++)
			{
				if (name[i].toLowerCase().equals("title")
						&& rec.getString(i + 1).toLowerCase()
								.contains(Remove.toLowerCase()))
				{
					Item one = new Item(rec.getString(1), rec.getString(2),
							rec.getString(3), rec.getString(4),
							rec.getString(5), rec.getString(6),
							rec.getString(7), rec.getString(8));
					ItemList.add(one);
				}
			}
		}
		rec.close();
		st.close();

		return ItemList;
	}

	public ArrayList<User> GetUser() throws Exception
	{
		ArrayList<User> UserList = new ArrayList<User>();
		String url = "jdbc:derby://localhost:1527/bookstore;create=true";
		String username = "user";
		String password = "123";
		Connection con = null;

		Class.forName("org.apache.derby.jdbc.ClientDriver");
		con = (Connection) DriverManager.getConnection(url, username, password);
		Statement st = (Statement) con.createStatement();
		ResultSet rec = (ResultSet) st.executeQuery("select * FROM TBL_USER");

		while (rec.next())
		{
			User one = new User(rec.getString(1), rec.getString(2),
					rec.getString(3), rec.getString(4), rec.getString(5),
					rec.getString(6), rec.getString(7), rec.getString(8),
					rec.getString(9), rec.getString(10));
			UserList.add(one);
		}
		rec.close();
		st.close();

		return UserList;
	}

	public ArrayList<User> UsernameSearch(String keyname) throws Exception
	{
		ArrayList<User> UserList = new ArrayList<User>();
		String url = "jdbc:derby://localhost:1527/bookstore;create=true";
		String username = "user";
		String password = "123";
		Connection con = null;

		Class.forName("org.apache.derby.jdbc.ClientDriver");
		con = (Connection) DriverManager.getConnection(url, username, password);
		Statement st = (Statement) con.createStatement();
		ResultSet rec = (ResultSet) st.executeQuery("select * FROM TBL_USER");

		while (rec.next())
		{
			if (rec.getString(1).contains(keyname))
			{
				User one = new User(rec.getString(1), rec.getString(2),
						rec.getString(3), rec.getString(4), rec.getString(5),
						rec.getString(6), rec.getString(7), rec.getString(8),
						rec.getString(9), rec.getString(10));
				UserList.add(one);
			}
		}
		rec.close();
		st.close();

		return UserList;
	}

	public void BanUser(String BanUserName) throws Exception
	{
		String url = "jdbc:derby://localhost:1527/bookstore;create=true";
		String user = "user";
		String pwd = "123";
		
		Class.forName("org.apache.derby.jdbc.ClientDriver");
		Connection con = (Connection) DriverManager.getConnection(url, user, pwd);
		String sql = "UPDATE TBL_USER SET Ban = '1' WHERE Username = '" + BanUserName + "'";
		PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
		
		pst.executeUpdate();
		pst.close();
		con.close();

	}
	
	public void FreeUser(String FreeUserName) throws Exception
	{
		String url = "jdbc:derby://localhost:1527/bookstore;create=true";
		String user = "user";
		String pwd = "123";
		
		Class.forName("org.apache.derby.jdbc.ClientDriver");
		Connection con = (Connection) DriverManager.getConnection(url, user, pwd);
		String sql = "UPDATE TBL_USER SET Ban = '0' WHERE Username = '" + FreeUserName + "'";
		PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
		
		pst.executeUpdate();
		pst.close();
		con.close();

	}
	
	public ArrayList<BuyActivity> GetBuy(String keyname) throws Exception
	{
		ArrayList<BuyActivity> BuyList = new ArrayList<BuyActivity>();
		String url = "jdbc:derby://localhost:1527/bookstore;create=true";
		String username = "user";
		String password = "123";
		Connection con = null;
		Class.forName("org.apache.derby.jdbc.ClientDriver");
		con = (Connection) DriverManager.getConnection(url, username, password);
		
		Statement st = (Statement) con.createStatement();
		ResultSet rec = (ResultSet) st.executeQuery("select * FROM TBL_ACTIVITY_BUY");
		while (rec.next())
		{
			if (rec.getString(1).contains(keyname))
			{
				BuyActivity one = new BuyActivity(rec.getString(1), rec.getString(2), rec.getString(3), rec.getString(4), rec.getString(5));
				BuyList.add(one);
			}
		}
		rec.close();
		st.close();

		return BuyList;
	}
	
	public ArrayList<AdReActivity> GetAdRe(String keyname) throws Exception
	{
		ArrayList<AdReActivity> AdReList = new ArrayList<AdReActivity>();
		String url = "jdbc:derby://localhost:1527/bookstore;create=true";
		String username = "user";
		String password = "123";
		Connection con = null;
		Class.forName("org.apache.derby.jdbc.ClientDriver");
		con = (Connection) DriverManager.getConnection(url, username, password);
		
		Statement st = (Statement) con.createStatement();
		ResultSet rec = (ResultSet) st.executeQuery("select * FROM TBL_ACTIVITY_ADRE");
		while (rec.next())
		{
			if (rec.getString(1).contains(keyname))
			{
				AdReActivity one = new AdReActivity(rec.getString(1), rec.getString(2), rec.getString(3), rec.getString(4));
				AdReList.add(one);
			}
		}
		rec.close();
		st.close();

		return AdReList;
	}
}
