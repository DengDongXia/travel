package dto.question;
/**
 * 用于用户删除相关的攻略的输入数据对象
 * @author 学徒
 *
 */
public class DeleteQuestionInput
{
	private int userID;//用户ID
	private int questionID;//提问的ID
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
	
}
