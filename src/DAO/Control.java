package DAO;

import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.derby.client.am.Connection;
import org.apache.derby.client.am.PreparedStatement;
import org.apache.derby.client.am.ResultSet;
import org.apache.derby.client.am.Statement;

import Data.Item;
import Data.Seller;

public class Control
{
	public ArrayList<Item> BasicSearch(String Title, String Author,	String Price, String Seller) throws Exception
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

		if (Title.equals(""))
		{
			if (Author.equals(""))
			{
				if (Price.equals(""))
				{
					if (Seller.equals("")) // Title 0 Author 0 Price 0 Seller 0
					{
						;
					} else
					// Title 0 Author 0 Price 0 Seller 1
					{
						while (rec.next())
						{
							if (rec.getString(6).toLowerCase()
									.contains(Seller.toLowerCase())
									&& rec.getString(8).equals("0"))
							{
								Item one = new Item(rec.getString(1),
										rec.getString(2), rec.getString(3),
										rec.getString(4), rec.getString(5),
										rec.getString(6), rec.getString(7),
										rec.getString(8));
								ItemList.add(one);
							}
						}
					}
				} else
				{
					if (Seller.equals(""))// Title 0 Author 0 Price 1 Seller 0
					{
						while (rec.next())
						{
							if (Integer.valueOf(rec.getString(5)).intValue() < Integer
									.valueOf(Price).intValue()
									&& rec.getString(8).equals("0"))
							{
								Item one = new Item(rec.getString(1),
										rec.getString(2), rec.getString(3),
										rec.getString(4), rec.getString(5),
										rec.getString(6), rec.getString(7),
										rec.getString(8));
								ItemList.add(one);
							}
						}
					} else
					// Title 0 Author 0 Price 1 Seller 1
					{
						while (rec.next())
						{
							if (rec.getString(6).toLowerCase()
									.contains(Seller.toLowerCase())
									&& Integer.valueOf(rec.getString(5))
											.intValue() < Integer
											.valueOf(Price).intValue()
									&& rec.getString(8).equals("0"))
							{
								Item one = new Item(rec.getString(1),
										rec.getString(2), rec.getString(3),
										rec.getString(4), rec.getString(5),
										rec.getString(6), rec.getString(7),
										rec.getString(8));
								ItemList.add(one);
							}
						}
					}
				}
			} else
			{
				if (Price.equals(""))
				{
					if (Seller.equals(""))// Title 0 Author 1 Price 0 Seller 0
					{
						while (rec.next())
						{
							if (rec.getString(2).toLowerCase()
									.contains(Author.toLowerCase())
									&& rec.getString(8).equals("0"))
							{
								Item one = new Item(rec.getString(1),
										rec.getString(2), rec.getString(3),
										rec.getString(4), rec.getString(5),
										rec.getString(6), rec.getString(7),
										rec.getString(8));
								ItemList.add(one);
							}
						}
					} else
					// Title 0 Author 1 Price 0 Seller 1
					{
						while (rec.next())
						{
							if (rec.getString(2).toLowerCase()
									.contains(Author.toLowerCase())
									&& rec.getString(6).toLowerCase()
											.contains(Seller.toLowerCase())
									&& rec.getString(8).equals("0"))
							{
								Item one = new Item(rec.getString(1),
										rec.getString(2), rec.getString(3),
										rec.getString(4), rec.getString(5),
										rec.getString(6), rec.getString(7),
										rec.getString(8));
								ItemList.add(one);
							}
						}
					}
				} else
				{
					if (Seller.equals(""))// Title 0 Author 1 Price 1 Seller 0
					{
						while (rec.next())
						{
							if (rec.getString(2).toLowerCase()
									.contains(Author.toLowerCase())
									&& Integer.valueOf(rec.getString(5))
											.intValue() < Integer
											.valueOf(Price).intValue()
									&& rec.getString(8).equals("0"))
							{
								Item one = new Item(rec.getString(1),
										rec.getString(2), rec.getString(3),
										rec.getString(4), rec.getString(5),
										rec.getString(6), rec.getString(7),
										rec.getString(8));
								ItemList.add(one);
							}
						}
					} else
					// Title 0 Author 1 Price 1 Seller 1
					{
						while (rec.next())
						{
							if (rec.getString(2).toLowerCase()
									.contains(Author.toLowerCase())
									&& Integer.valueOf(rec.getString(5))
											.intValue() < Integer
											.valueOf(Price).intValue()
									&& rec.getString(6).toLowerCase()
											.contains(Seller.toLowerCase())
									&& rec.getString(8).equals("0"))
							{
								Item one = new Item(rec.getString(1),
										rec.getString(2), rec.getString(3),
										rec.getString(4), rec.getString(5),
										rec.getString(6), rec.getString(7),
										rec.getString(8));
								ItemList.add(one);
							}
						}
					}
				}
			}
		} else
		{
			if (Author.equals(""))
			{
				if (Price.equals(""))
				{
					if (Seller.equals(""))// Title 1 Author 0 Price 0 Seller 0
					{
						while (rec.next())
						{
							if (rec.getString(1).toLowerCase()
									.contains(Title.toLowerCase())
									&& rec.getString(8).equals("0"))
							{
								Item one = new Item(rec.getString(1),
										rec.getString(2), rec.getString(3),
										rec.getString(4), rec.getString(5),
										rec.getString(6), rec.getString(7),
										rec.getString(8));
								ItemList.add(one);
							}
						}
					} else
					// Title 1 Author 0 Price 0 Seller 1
					{
						while (rec.next())
						{
							if (rec.getString(1).toLowerCase()
									.contains(Title.toLowerCase())
									&& rec.getString(6).toLowerCase()
											.contains(Seller.toLowerCase())
									&& rec.getString(8).equals("0"))
							{
								Item one = new Item(rec.getString(1),
										rec.getString(2), rec.getString(3),
										rec.getString(4), rec.getString(5),
										rec.getString(6), rec.getString(7),
										rec.getString(8));
								ItemList.add(one);
							}
						}
					}
				} else
				{
					if (Seller.equals(""))// Title 1 Author 0 Price 1 Seller 0
					{
						while (rec.next())
						{
							if (rec.getString(1).toLowerCase()
									.contains(Title.toLowerCase())
									&& Integer.valueOf(rec.getString(5))
											.intValue() < Integer
											.valueOf(Price).intValue()
									&& rec.getString(8).equals("0"))
							{
								Item one = new Item(rec.getString(1),
										rec.getString(2), rec.getString(3),
										rec.getString(4), rec.getString(5),
										rec.getString(6), rec.getString(7),
										rec.getString(8));
								ItemList.add(one);
							}
						}
					} else
					// Title 1 Author 0 Price 1 Seller 1
					{
						while (rec.next())
						{
							if (rec.getString(1).toLowerCase()
									.contains(Title.toLowerCase())
									&& Integer.valueOf(rec.getString(5))
											.intValue() < Integer
											.valueOf(Price).intValue()
									&& rec.getString(6).toLowerCase()
											.contains(Seller.toLowerCase())
									&& rec.getString(8).equals("0"))
							{
								Item one = new Item(rec.getString(1),
										rec.getString(2), rec.getString(3),
										rec.getString(4), rec.getString(5),
										rec.getString(6), rec.getString(7),
										rec.getString(8));
								ItemList.add(one);
							}
						}
					}
				}
			} else
			{
				if (Price.equals(""))
				{
					if (Seller.equals(""))// Title 1 Author 1 Price 0 Seller 0
					{
						while (rec.next())
						{
							if (rec.getString(1).toLowerCase()
									.contains(Title.toLowerCase())
									&& rec.getString(2).toLowerCase()
											.contains(Author.toLowerCase())
									&& rec.getString(8).equals("0"))
							{
								Item one = new Item(rec.getString(1),
										rec.getString(2), rec.getString(3),
										rec.getString(4), rec.getString(5),
										rec.getString(6), rec.getString(7),
										rec.getString(8));
								ItemList.add(one);
							}
						}
					} else
					// Title 1 Author 1 Price 0 Seller 1
					{
						while (rec.next())
						{
							if (rec.getString(1).toLowerCase()
									.contains(Title.toLowerCase())
									&& rec.getString(2).toLowerCase()
											.contains(Author.toLowerCase())
									&& rec.getString(6).toLowerCase()
											.contains(Seller.toLowerCase())
									&& rec.getString(8).equals("0"))
							{
								Item one = new Item(rec.getString(1),
										rec.getString(2), rec.getString(3),
										rec.getString(4), rec.getString(5),
										rec.getString(6), rec.getString(7),
										rec.getString(8));
								ItemList.add(one);
							}
						}
					}
				} else
				{
					if (Seller.equals(""))// Title 1 Author 1 Price 1 Seller 0
					{
						while (rec.next())
						{
							if (rec.getString(1).toLowerCase()
									.contains(Title.toLowerCase())
									&& rec.getString(2).toLowerCase()
											.contains(Author.toLowerCase())
									&& Integer.valueOf(rec.getString(5))
											.intValue() < Integer
											.valueOf(Price).intValue()
									&& rec.getString(8).equals("0"))
							{
								Item one = new Item(rec.getString(1),
										rec.getString(2), rec.getString(3),
										rec.getString(4), rec.getString(5),
										rec.getString(6), rec.getString(7),
										rec.getString(8));
								ItemList.add(one);
							}
						}
					} else
					{
						while (rec.next())
						{
							if (rec.getString(1).toLowerCase()
									.contains(Title.toLowerCase())
									&& rec.getString(2).toLowerCase()
											.contains(Author.toLowerCase())
									&& Integer.valueOf(rec.getString(5))
											.intValue() < Integer
											.valueOf(Price).intValue()
									&& rec.getString(6).toLowerCase()
											.contains(Seller.toLowerCase())
									&& rec.getString(8).equals("0"))
							{
								Item one = new Item(rec.getString(1),
										rec.getString(2), rec.getString(3),
										rec.getString(4), rec.getString(5),
										rec.getString(6), rec.getString(7),
										rec.getString(8));
								ItemList.add(one);
							}
						}
					}
				}
			}
		}

		rec.close();
		st.close();

		return ItemList;
	}

	public ArrayList<Item> AdvancedSearch(String Title, String Author,	String Price, String Seller)
			throws Exception
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
		
		if (Title.equals(""))
		{
			if (Author.equals(""))
			{
				if (Price.equals(""))
				{
					if (Seller.equals("")) // Title 0 Author 0 Price 0 Seller 0
					{
						;
					} else
					// Title 0 Author 0 Price 0 Seller 1
					{
						while (rec.next())
						{
							if (rec.getString(8).equals("0"))
							{
								Pattern pattern = Pattern.compile(Seller.toLowerCase());
								Matcher matcher = pattern.matcher(rec.getString(6).toLowerCase());
								if (matcher.matches())
								{
									Item one = new Item(rec.getString(1), rec.getString(2),
											rec.getString(3), rec.getString(4),
											rec.getString(5), rec.getString(6),
											rec.getString(7), rec.getString(8));
									ItemList.add(one);
								}
							}
						
						}
					}
				} else
				{
					;
				}
			} else
			{
				if (Price.equals(""))
				{
					if (Seller.equals(""))// Title 0 Author 1 Price 0 Seller 0
					{
						while (rec.next())
						{
							if (rec.getString(8).equals("0"))
							{
								Pattern pattern = Pattern.compile(Author.toLowerCase());
								Matcher matcher = pattern.matcher(rec.getString(2).toLowerCase());
								if (matcher.matches())
								{
									Item one = new Item(rec.getString(1), rec.getString(2),
											rec.getString(3), rec.getString(4),
											rec.getString(5), rec.getString(6),
											rec.getString(7), rec.getString(8));
									ItemList.add(one);
								}
							}
						
						}
					} else
					// Title 0 Author 1 Price 0 Seller 1
					{
						while (rec.next())
						{
							if (rec.getString(8).equals("0"))
							{
								Pattern pattern = Pattern.compile(Author.toLowerCase());
								Matcher matcher = pattern.matcher(rec.getString(2).toLowerCase());
								Pattern pattern1 = Pattern.compile(Seller.toLowerCase());
								Matcher matcher1 = pattern1.matcher(rec.getString(6).toLowerCase());
								if (matcher.matches() && matcher1.matches())
								{
									Item one = new Item(rec.getString(1), rec.getString(2),
											rec.getString(3), rec.getString(4),
											rec.getString(5), rec.getString(6),
											rec.getString(7), rec.getString(8));
									ItemList.add(one);
								}
							}
						
						}
					}
				} else
				{
					;
				}
			}
		} else
		{
			if (Author.equals(""))
			{
				if (Price.equals(""))
				{
					if (Seller.equals(""))// Title 1 Author 0 Price 0 Seller 0
					{
						while (rec.next())
						{
							if (rec.getString(8).equals("0"))
							{
								Pattern pattern = Pattern.compile(Title.toLowerCase());
								Matcher matcher = pattern.matcher(rec.getString(1).toLowerCase());
								if (matcher.matches())
								{
									Item one = new Item(rec.getString(1), rec.getString(2),
											rec.getString(3), rec.getString(4),
											rec.getString(5), rec.getString(6),
											rec.getString(7), rec.getString(8));
									ItemList.add(one);
								}
							}
						
						}
					} else
					// Title 1 Author 0 Price 0 Seller 1
					{
						while (rec.next())
						{
							if (rec.getString(8).equals("0"))
							{
								Pattern pattern = Pattern.compile(Title.toLowerCase());
								Matcher matcher = pattern.matcher(rec.getString(1).toLowerCase());
								Pattern pattern1 = Pattern.compile(Seller.toLowerCase());
								Matcher matcher1 = pattern1.matcher(rec.getString(6).toLowerCase());
								if (matcher.matches() && matcher1.matches())
								{
									Item one = new Item(rec.getString(1), rec.getString(2),
											rec.getString(3), rec.getString(4),
											rec.getString(5), rec.getString(6),
											rec.getString(7), rec.getString(8));
									ItemList.add(one);
								}
							}
						
						}
					}
				} else
				{
					;
				}
			} else
			{
				if (Price.equals(""))
				{
					if (Seller.equals(""))// Title 1 Author 1 Price 0 Seller 0
					{
						while (rec.next())
						{
							if (rec.getString(8).equals("0"))
							{
								Pattern pattern = Pattern.compile(Title.toLowerCase());
								Matcher matcher = pattern.matcher(rec.getString(1).toLowerCase());
								Pattern pattern1 = Pattern.compile(Author.toLowerCase());
								Matcher matcher1 = pattern1.matcher(rec.getString(2).toLowerCase());
								if (matcher.matches() && matcher1.matches())
								{
									Item one = new Item(rec.getString(1), rec.getString(2),
											rec.getString(3), rec.getString(4),
											rec.getString(5), rec.getString(6),
											rec.getString(7), rec.getString(8));
									ItemList.add(one);
								}
							}
						
						}
					} else
					// Title 1 Author 1 Price 0 Seller 1
					{
						while (rec.next())
						{
							if (rec.getString(8).equals("0"))
							{
								Pattern pattern = Pattern.compile(Title.toLowerCase());
								Matcher matcher = pattern.matcher(rec.getString(1).toLowerCase());
								Pattern pattern1 = Pattern.compile(Author.toLowerCase());
								Matcher matcher1 = pattern1.matcher(rec.getString(2).toLowerCase());
								Pattern pattern2 = Pattern.compile(Seller.toLowerCase());
								Matcher matcher2 = pattern2.matcher(rec.getString(6).toLowerCase());
								if (matcher.matches() && matcher1.matches() && matcher2.matches())
								{
									Item one = new Item(rec.getString(1), rec.getString(2),
											rec.getString(3), rec.getString(4),
											rec.getString(5), rec.getString(6),
											rec.getString(7), rec.getString(8));
									ItemList.add(one);
								}
							}
						
						}
					}
				} else
				{
					;
				}
			}
		}

		rec.close();
		st.close();

		return ItemList;
	}

	public void AddToTBCart(Item node, String Username, String time)
			throws Exception
	{
		String url = "jdbc:derby://localhost:1527/bookstore;create=true";
		String username = "user";
		String password = "123";

		Class.forName("org.apache.derby.jdbc.ClientDriver");
		Connection con = (Connection) DriverManager.getConnection(url,
				username, password);
		PreparedStatement pst = (PreparedStatement) con
				.prepareStatement("INSERT INTO TBL_CART VALUES(?, ?, ?, ?, ?)");
		pst.setString(1, Username);
		pst.setString(2, node.getTitle());
		pst.setString(3, node.getAuthor());
		pst.setString(4, null);
		pst.setString(5, time);
		pst.executeUpdate();
		pst.close();
		con.close();
	}

	public void AddToTBBuy(Item node, String Username, String time)
			throws Exception
	{
		String url = "jdbc:derby://localhost:1527/bookstore;create=true";
		String username = "user";
		String password = "123";
		Class.forName("org.apache.derby.jdbc.ClientDriver");
		Connection con = (Connection) DriverManager.getConnection(url,
				username, password);

		PreparedStatement pst = (PreparedStatement) con
				.prepareStatement("INSERT INTO TBL_ACTIVITY_BUY VALUES(?, ?, ?, ?, ?)");
		pst.setString(1, Username);
		pst.setString(2, node.getTitle());
		pst.setString(3, time);
		pst.setString(4, node.getPrice());
		pst.setString(5, node.getSeller());
		pst.executeUpdate();
		pst.close();
		con.close();
	}

	public void AddToTBAdRe(Item node, String Username, String reTime)
			throws Exception
	{
		String url = "jdbc:derby://localhost:1527/bookstore;create=true";
		String username = "user";
		String password = "123";
		Class.forName("org.apache.derby.jdbc.ClientDriver");
		Connection con = (Connection) DriverManager.getConnection(url,
				username, password);

		Statement st = (Statement) con.createStatement();
		ResultSet rec = (ResultSet) st.executeQuery("select * FROM TBL_CART");
		String adTime = null;
		while (rec.next())
		{
			if (rec.getString(1).equals(Username)
					&& rec.getString(2).equals(node.getTitle()))
			{
				adTime = rec.getString(5);
			}
		}
		rec.close();
		st.close();

		PreparedStatement pst = (PreparedStatement) con
				.prepareStatement("INSERT INTO TBL_ACTIVITY_ADRE VALUES(?, ?, ?, ?)");
		pst.setString(1, Username);
		pst.setString(2, node.getTitle());
		pst.setString(3, adTime);
		pst.setString(4, reTime);
		pst.executeUpdate();

		pst.close();
		con.close();
	}

	public void RmFromTBCart(Item node, String Username) throws Exception
	{
		String url = "jdbc:derby://localhost:1527/bookstore;create=true";
		String username = "user";
		String password = "123";

		Class.forName("org.apache.derby.jdbc.ClientDriver");
		Connection con = (Connection) DriverManager.getConnection(url,
				username, password);
		PreparedStatement pst = (PreparedStatement) con
				.prepareStatement("DELETE FROM TBL_CART WHERE Title = ? and Username = ?");
		pst.setString(1, node.getTitle());
		pst.setString(2, Username);
		pst.executeUpdate();
		pst.close();
		con.close();
	}

	public String GetSellerEmail(String SellerName) throws Exception
	{
		String url = "jdbc:derby://localhost:1527/bookstore;create=true";
		String username = "user";
		String password = "123";
		Connection con = null;

		Class.forName("org.apache.derby.jdbc.ClientDriver");
		con = (Connection) DriverManager.getConnection(url, username, password);
		Statement st = (Statement) con.createStatement();
		ResultSet rec = (ResultSet) st.executeQuery("select * FROM TBL_SELLER");

		String Email = null;
		while (rec.next())
		{
			if (rec.getString(1).equals(SellerName))
			{
				Email = rec.getString(4);
			}
		}
		rec.close();
		st.close();
		return Email;
	}
	
	public ArrayList<Item> getrandom() throws Exception
	{
		String url = "jdbc:derby://localhost:1527/bookstore;create=true";
		String username = "user";
		String password = "123";
		Connection con = null;

		Class.forName("org.apache.derby.jdbc.ClientDriver");
		con = (Connection) DriverManager.getConnection(url, username, password);
		Statement st = (Statement) con.createStatement();
		ResultSet rec = (ResultSet) st.executeQuery("select * FROM TBL_Item");
		
		ArrayList<Item> ItemList = new ArrayList<Item>();
		ArrayList<Item> randomItem = new ArrayList<Item>();
		int[] randnum = new int[8];
		
		for (int j = 0; j < 8; ++j)
		{				
			randnum = unique(randnum, 100);
		}
		
		while (rec.next())
		{
			Item one = new Item(rec.getString(1), rec.getString(2),
					rec.getString(3), rec.getString(4),
					rec.getString(5), rec.getString(6),
					rec.getString(7), rec.getString(8));
			ItemList.add(one);
		}
		
		for (int j = 0; j < 8; ++j)
		{				
			randomItem.add(ItemList.get(randnum[j]));
		}
		
		rec.close();
		st.close();
		return randomItem;
	}
	
	private int[] unique(int[] randnum, int length)
	{
		Random rand = new Random();
		for (int i = 0; i < randnum.length; ++i)
		{
			randnum[i] = rand.nextInt(length);
			for (int j = 0; j < i; ++j)
			{
				while (randnum[i] == randnum[j])
				{
					--i;
					break;
				}
			}
		}
		
		return randnum;
		
	}
}
