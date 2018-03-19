package dto.answer;
/**
 * 用户采纳相关评论的输入对象
 * @author 学徒
 *
 */
public class QuestionAnswerInput
{
	private int commentId;//采纳的评论的ID
	private int questionID;//提问的ID
	public int getCommentId()
	{
		return commentId;
	}
	public void setCommentId(int commentId)
	{
		this.commentId = commentId;
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
