package domain.comment;

import java.util.Date;

/**
 * 文章评论相关的数据库映射对象
 * @author 学徒
 *
 */
public class Comment
{
	private int id;//评论的ID
	private int userID;//评论的用户ID
	private int essayID;//评论的文章ID
	private String context;//输入的内容
	private String time;//时间
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
	public int getEssayID()
	{
		return essayID;
	}
	public void setEssayID(int essayID)
	{
		this.essayID = essayID;
	}
	public String getContext()
	{
		return context;
	}
	public void setContext(String context)
	{
		this.context = context;
	}
	public String getTime()
	{
		return time;
	}
	public void setTime(String time)
	{
		this.time = time;
	}
}
