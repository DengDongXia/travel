package dto.comment;
/**
 * 查找文章相关的评论的输入对象
 * @author 学徒
 *
 */
public class SearchCommentListInput
{
	private int pageIndex;//当前的页数
	private int showLimit;//每页显示的评论数目
	private int essayID;//攻略的ID
	private int start;//limit语句的参数
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
	public int getEssayID()
	{
		return essayID;
	}
	public void setEssayID(int essayID)
	{
		this.essayID = essayID;
	}
	public int getStart()
	{
		return start;
	}
	public void setStart()
	{
		this.start =this.pageIndex*this.showLimit;
	}
	
	
	
}
