package dto.eassy;
/**
 * 用户查找的相关
 * @author 学徒
 *
 */
public class SearchEssayByUser
{
	private int userID;//用户的ID
	private int showLimit;//每页的显示数目
	private int pageIndex;//当前页数
	private int start;//limit语句的相关参数
	public int getUserID()
	{
		return userID;
	}
	public void setUserID(int userID)
	{
		this.userID = userID;
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
		this.start = (this.pageIndex-1)*this.showLimit;
	}
	
}
