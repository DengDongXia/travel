package dto.answer;
/**
 * 提问回答的输入对象
 * @author 学徒
 *
 */
public class ShowAnswerInput
{
	private int questionID;//提问的ID
	private int pageIndex;//提问分页的当前页
	private int showLimit;//提问分页的每页显示限制
	private int start;//limit分页语句的相关参数数据
	public int getQuestionID()
	{
		return questionID;
	}
	public void setQuestionID(int questionID)
	{
		this.questionID = questionID;
	}
	public int getPageIndex()
	{
		return pageIndex;
	}
	public void setPageIndex(int pageIndex)
	{
		this.pageIndex = pageIndex;
	}
	public int getShowLimit()
	{
		return showLimit;
	}
	public void setShowLimit(int showLimit)
	{
		this.showLimit = showLimit;
	}
	public int getStart()
	{
		return start;
	}
	public void setStart()
	{
		this.start = (this.pageIndex-1)*this.showLimit;
	}
}
