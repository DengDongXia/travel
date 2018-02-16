package dto.question;

import java.util.Date;
/**
 * 提问的详细内容的相关信息
 * @author 学徒
 *
 */
public class ShowQuestionDetail
{
	private String questionHeader;//提问的标题
	private boolean questionStatus;//提问的状态
	private String questionContent;//提问的内容
	private String questionPersonName;//提问人的昵称
	private String questionPersonPicture;//提问人的照片的URL
	private Date questionTime;//提问的时间
	private int questionAnswerCount;//提问的回答的数目
	private int questionID;//提问的ID
	private String questionAnswerPersonURL;//采纳的回答的用户的URL
	private String questionAnswerPersonName;//采纳的回答的用户的昵称
	private String questionAnswerContent;//采纳的回答的内容
	private Date questionAnswerTime;//采纳的回答的回答时间
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
	public String getQuestionAnswerPersonURL()
	{
		return questionAnswerPersonURL;
	}
	public void setQuestionAnswerPersonURL(String questionAnswerPersonURL)
	{
		this.questionAnswerPersonURL = questionAnswerPersonURL;
	}
	public String getQuestionAnswerPersonName()
	{
		return questionAnswerPersonName;
	}
	public void setQuestionAnswerPersonName(String questionAnswerPersonName)
	{
		this.questionAnswerPersonName = questionAnswerPersonName;
	}
	public String getQuestionAnswerContent()
	{
		return questionAnswerContent;
	}
	public void setQuestionAnswerContent(String questionAnswerContent)
	{
		this.questionAnswerContent = questionAnswerContent;
	}
	public Date getQuestionAnswerTime()
	{
		return questionAnswerTime;
	}
	public void setQuestionAnswerTime(Date questionAnswerTime)
	{
		this.questionAnswerTime = questionAnswerTime;
	}
}
