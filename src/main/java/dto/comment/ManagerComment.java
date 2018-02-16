package dto.comment;

import java.util.Date;

/**
 * 返回评论的相关查找信息
 * @author 学徒
 *
 */
public class ManagerComment
{
	private int id;//评论的ID
	private int userID;//评论的用户ID
	private String userName;//评论的用户昵称
	private String userPicture;//评论的用户的图像
	private String context;//评论的内容
	private Date time;//评论的时间
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
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
	public String getUserPicture()
	{
		return userPicture;
	}
	public void setUserPicture(String userPicture)
	{
		this.userPicture = userPicture;
	}
	public String getContext()
	{
		return context;
	}
	public void setContext(String context)
	{
		this.context = context;
	}
	public Date getTime()
	{
		return time;
	}
	public void setTime(Date time)
	{
		this.time = time;
	}
}
