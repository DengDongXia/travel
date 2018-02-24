package dto.user;
/**
 * 用于更新其相应个人信息的输入对象
 * @author 学徒
 *
 */
public class UpdateUserMessageInput
{
	private int userId;//其相应的用户Id
	private String name;//其相应的用户昵称
	private String quote;//其相应的用户的个性签名
	private String pictureURL;//其用户的头像的相关数据
	public String getPictureURL()
	{
		return pictureURL;
	}
	public void setPictureURL(String pictureURL)
	{
		this.pictureURL = pictureURL;
	}
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
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
}
