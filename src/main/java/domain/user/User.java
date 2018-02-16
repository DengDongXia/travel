package domain.user;
/**
 * 用户的封装
 * @author 学徒
 *
 */
public class User
{
	private int id;//用户ID
	private String email;//用户邮箱
	private String name;//用户昵称
	private String password;//用户密码
	private String timestamp;//用户时间戳
	private String quote;//用户个性签名
	private boolean locked;//用户锁定状态
	private String pictureURL;//用户图像的URL
	public String getPictureURL()
	{
		return pictureURL;
	}
	public void setPictureURL(String pictureURL)
	{
		this.pictureURL = pictureURL;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getEmail()
	{
		return email;
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
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getTimestamp()
	{
		return timestamp;
	}
	public void setTimestamp(String timestamp)
	{
		this.timestamp = timestamp;
	}
	public String getQuote()
	{
		return quote;
	}
	public void setQuote(String quote)
	{
		this.quote = quote;
	}
	public boolean isLocked()
	{
		return locked;
	}
	public void setLocked(boolean locked)
	{
		this.locked = locked;
	}
	
}
