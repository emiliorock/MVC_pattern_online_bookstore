package Data;

public class AdReActivity
{
	public String username;
	public String title;
	public String adtime;
	public String retime;
	
	public AdReActivity()
	{

	}
	
	public AdReActivity(String username, String title, String adtime, String retime)
	{
		this.username = username;
		this.title = title;
		this.adtime = adtime;
		this.retime = retime;
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

	public String getAdtime()
	{
		return adtime;
	}

	public String getRetime()
	{
		return retime;
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

	public void setAdTime(String adtime)
	{
		this.adtime = adtime;
	}

	public void setReTime(String retime)
	{
		this.retime = retime;
	}
}
