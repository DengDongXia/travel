package dto.eassy;
/**
 * 相关的输入类对象
 * @author 学徒
 *
 */
public class AddEssayInput
{
	private String context;
	private String country;
	private String essayHeader;
	private String pictureURL;
	private int userID;
	public String getContext()
	{
		return context;
	}
	public void setContext(String context)
	{
		this.context = context;
	}
	public String getCountry()
	{
		return country;
	}
	public void setCountry(String country)
	{
		this.country = country;
	}
	public String getEssayHeader()
	{
		return essayHeader;
	}
	public void setEssayHeader(String essayHeader)
	{
		this.essayHeader = essayHeader;
	}
	public String getPictureURL()
	{
		return pictureURL;
	}
	public void setPictureURL(String pictureURL)
	{
		this.pictureURL = pictureURL;
	}
	public int getUserID()
	{
		return userID;
	}
	public void setUserID(int userID)
	{
		this.userID = userID;
	}
}
