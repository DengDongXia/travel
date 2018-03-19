package dto.comment;

import java.util.Date;

/**
 * 返回评论的相关查找信息
 * @author 学徒
 *
 */
public class ManagerComment
{
	/*private int id;//评论的ID
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
	}*/
	private String essayHeader;//文章的标题
	private String commentContext;//评论的内容
	private int essayID;//文章的ID
	private int commentId;//评论的ID
	public String getEssayHeader()
	{
		return essayHeader;
	}
	public void setEssayHeader(String essayHeader)
	{
		this.essayHeader = essayHeader;
	}
	public String getCommentContext()
	{
		return commentContext;
	}
	public void setCommentContext(String commentContext)
	{
		this.commentContext = commentContext;
	}
	public int getEssayID()
	{
		return essayID;
	}
	public void setEssayID(int essayID)
	{
		this.essayID = essayID;
	}
	public int getCommentId()
	{
		return commentId;
	}
	public void setCommentId(int commentId)
	{
		this.commentId = commentId;
	}
}
