package domain.question;

import java.util.Date;

/**
 * 提问的相关数据库类对象
 * @author 学徒
 *
 */
public class Question
{
	private int id;//提问的ID
	private int userID;//提问的用户ID
	private String time;//提问的时间
	private boolean state;//提问的状态
	private String context;//提问的内容
	private int answerID;//提问的采纳的回答的ID
	private String header;//提问的标题
	public String getHeader()
	{
		return header;
	}
	public void setHeader(String header)
	{
		this.header = header;
	}
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
	public String getTime()
	{
		return time;
	}
	public void setTime(String time)
	{
		this.time = time;
	}
	public boolean isState()
	{
		return state;
	}
	public void setState(boolean state)
	{
		this.state = state;
	}
	public String getContext()
	{
		return context;
	}
	public void setContext(String context)
	{
		this.context = context;
	}
	public int getAnswerID()
	{
		return answerID;
	}
	public void setAnswerID(int answerID)
	{
		this.answerID = answerID;
	}
}
