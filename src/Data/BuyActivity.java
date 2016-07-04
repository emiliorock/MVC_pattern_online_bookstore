package Data;

import java.sql.*;

public class BuyActivity
{
	public String username;
	public String title;
	public String buytime;
	public String price;
	public String seller;

	public BuyActivity()
	{

	}
	
	public BuyActivity(String username, String title, String buytime,
			String price, String seller)
	{
		this.username = username;
		this.title = title;
		this.buytime = buytime;
		this.price = price;
		this.seller = seller;
	}
	
	/*** GET methods ***/
	public String getUsername()
	{
		return username;
	}

	public String getTitle()
	{
		return title;
	}

	public String getBuytime()
	{
		return buytime;
	}

	public String getPrice()
	{
		return price;
	}

	public String getSeller()
	{
		return seller;
	}

	/*** SET methods ***/
	public void setUsername(String username)
	{
		this.username = username;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public void setBuyTime(String buytime)
	{
		this.buytime = buytime;
	}

	public void setPrice(String price)
	{
		this.price = price;
	}

	public void setseller(String seller)
	{
		this.seller = seller;
	}

}
