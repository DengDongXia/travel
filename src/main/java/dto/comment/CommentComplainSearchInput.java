package dto.comment;
/**
 * 管理员查找相关评论的输入对象
 * @author 学徒
 *
 */
public class CommentComplainSearchInput
{
	private int start;//limit语句的参数之一
	private int showLimit;//每页显示的数目
	private int pageIndex;//当前页数
	public int getStart()
	{
		return start;
	}
	public void setStart()
	{
		this.start =(this.pageIndex-1)*this.showLimit;
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
}
