package domain.essay;

import java.util.Date;

/**
 * essay表的相关对象
 * @author 学徒
 *
 */
public class Essay
{
	private int essayID;
	private int userID;
	private boolean state;
	private String country;
	private boolean validate;
	private Date time;
	private String eassyHeader;
	private String pictureURL;
	private String context;
	public String getPictureURL()
	{
		return pictureURL;
	}
	public void setPictureURL(String pictureURL)
	{
		this.pictureURL = pictureURL;
	}
	public String getContext()
	{
		return context;
	}
	public void setContext(String context)
	{
		this.context = context;
	}
	public int getEssayID()
	{
		return essayID;
	}
	public void setEssayID(int essayID)
	{
		this.essayID = essayID;
	}
	public int getUserID()
	{
		return userID;
	}
	public void setUserID(int userID)
	{
		this.userID = userID;
	}
	public boolean isState()
	{
		return state;
	}
	public void setState(boolean state)
	{
		this.state = state;
	}
	public String getCountry()
	{
		return country;
	}
	public void setCountry(String country)
	{
		this.country = country;
	}
	public boolean isValidate()
	{
		return validate;
	}
	public void setValidate(boolean validate)
	{
		this.validate = validate;
	}
	public Date getTime()
	{
		return time;
	}
	public void setTime(Date time)
	{
		this.time = time;
	}
	public String getEassyHeader()
	{
		return eassyHeader;
	}
	public void setEassyHeader(String eassyHeader)
	{
		this.eassyHeader = eassyHeader;
	}
}
