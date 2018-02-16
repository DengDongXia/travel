package dto.manager;
/**
 * 根据用户的输入条件查找的用户结果
 * @author 学徒
 *
 */
public class UserSearchResult
{
	private int userID;//用户ID
	private String userName;//用户昵称
	private boolean userStatus;//用户账号的状态
	private int userAccount;//用户的积分
	private String userPicture;//用户图像的URL
	public int getUserID()
	{
		return userID;
	}
	public void setUserID(int userID)
	{
		this.userID = userID;
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public boolean isUserStatus()
	{
		return userStatus;
	}
	public void setUserStatus(boolean userStatus)
	{
		this.userStatus = userStatus;
	}
	public int getUserAccount()
	{
		return userAccount;
	}
	public void setUserAccount(int userAccount)
	{
		this.userAccount = userAccount;
	}
	public String getUserPicture()
	{
		return userPicture;
	}
	public void setUserPicture(String userPicture)
	{
		this.userPicture = userPicture;
	}
	
	
}
