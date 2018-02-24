package dto.question;
/**
 * 更新相应的提问的输入情况
 * @author 学徒
 *
 */
public class UpdateQuestionInput
{
	private int userID;//对其进行更新操作的用户的ID
	private int questionID;//对其更新的问题的ID
	private String context;//更新的文章的内容
	private String questionHeader;//更新其文章的标题
	public String getQuestionHeader()
	{
		return questionHeader;
	}
	public void setQuestionHeader(String questionHeader)
	{
		this.questionHeader = questionHeader;
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
	public String getContext()
	{
		return context;
	}
	public void setContext(String context)
	{
		this.context = context;
	}
}
