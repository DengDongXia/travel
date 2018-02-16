package dto.manager;
/**
 * 超级管理员修改管理员的输入信息对象
 * @author 学徒
 *
 */
public class UpdateManagerInput
{
	private String email;//管理员的邮箱
	private String name;//管理员的姓名
	private String quote;//管理员的个性签名
	private int managerID;//管理员的ID
	private String pictureURL;//管理员图像的URL
	public String getEmail()
	{
		return email;
	}
	public String getPictureURL()
	{
		return pictureURL;
	}
	public void setPictureURL(String pictureURL)
	{
		this.pictureURL = pictureURL;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getQuote()
	{
		return quote;
	}
	public void setQuote(String quote)
	{
		this.quote = quote;
	}
	public int getManagerID()
	{
		return managerID;
	}
	public void setManagerID(int managerID)
	{
		this.managerID = managerID;
	}
	
}
