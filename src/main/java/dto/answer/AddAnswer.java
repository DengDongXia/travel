package dto.answer;

import java.util.Date;

/**
 * 用于添加其对应的回答的数据的对象
 * @author 学徒
 *
 */
public class AddAnswer
{
	private String context;//回复的内容
	private int userID;//回复的用户ID
	private int questionID;//回复的问题的ID
	private Date time;//回复的时间
	public String getContext()
	{
		return context;
	}
	public void setContext(String context)
	{
		this.context = context;
	}
	public int getUserID()
	{
		return userID;
	}
	public void setUserID(int userID)
	{
		this.userID = userID;
	}
	public int getQuestionID()
	{
		return questionID;
	}
	public void setQuestionID(int questionID)
	{
		this.questionID = questionID;
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
