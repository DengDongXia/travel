package dto.question;

import java.util.Date;

/**
 * 用于显示提问的列表的提问对象
 * @author 学徒
 *
 */
public class ShowQuestion
{
	private String questionHeader;//提问的标题
	private boolean questionStatus;//提问的状态
	private String questionContent;//提问的内容
	private String questionPersonName;//提问人的昵称
	private String questionPersonPicture;//提问人的照片的URL
	private Date questionTime;//提问的时间
	private int questionAnswerCount;//提问的回答的数目
	private int questionID;//提问的ID
	public String getQuestionHeader()
	{
		return questionHeader;
	}
	public void setQuestionHeader(String questionHeader)
	{
		this.questionHeader = questionHeader;
	}
	public boolean isQuestionStatus()
	{
		return questionStatus;
	}
	public void setQuestionStatus(boolean questionStatus)
	{
		this.questionStatus = questionStatus;
	}
	public String getQuestionContent()
	{
		return questionContent;
	}
	public void setQuestionContent(String questionContent)
	{
		this.questionContent = questionContent;
	}
	public String getQuestionPersonName()
	{
		return questionPersonName;
	}
	public void setQuestionPersonName(String questionPersonName)
	{
		this.questionPersonName = questionPersonName;
	}
	public String getQuestionPersonPicture()
	{
		return questionPersonPicture;
	}
	public void setQuestionPersonPicture(String questionPersonPicture)
	{
		this.questionPersonPicture = questionPersonPicture;
	}
	public Date getQuestionTime()
	{
		return questionTime;
	}
	public void setQuestionTime(Date questionTime)
	{
		this.questionTime = questionTime;
	}
	public int getQuestionAnswerCount()
	{
		return questionAnswerCount;
	}
	public void setQuestionAnswerCount(int questionAnswerCount)
	{
		this.questionAnswerCount = questionAnswerCount;
	}
	public int getQuestionID()
	{
		return questionID;
	}
	public void setQuestionID(int questionID)
	{
		this.questionID = questionID;
	}
}
