package dto.question;
/**
 * 用于查找特色定制的显示的输入对象
 * @author 学徒
 *
 */
public class SearchQuestionListInput
{
	private int showLimit;//每页显示的数目
	private int pageIndex;//当前页
	private int start;//数据库limit语句相关的参数之一
	private int userID;//查找用户发布的相关的提问的用户ID
	public int getUserID()
	{
		return userID;
	}
	public void setUserID(int userID)
	{
		this.userID = userID;
	}
	public void setStart(int start)
	{
		this.start = start;
	}
	public int getShowLimit()
	{
		return showLimit;
	}
	public void setShowLimit(int showLimit)
	{
		this.showLimit = showLimit;
	}
	public int getPageIndex()
	{
		return pageIndex;
	}
	public void setPageIndex(int pageIndex)
	{
		this.pageIndex = pageIndex;
	}
	public int getStart()
	{
		return start;
	}
	public void setStart()
	{
		this.start = this.showLimit*(this.pageIndex-1);
	}
	
}
