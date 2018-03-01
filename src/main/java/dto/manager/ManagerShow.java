package dto.manager;
/**
 * 
 * @author 学徒
 *
 */
public class ManagerShow
{
	//当前页数,即第几页
	private int pageIndex;
	//每页显示数量
	private int limit;
	//limit语句中开始的行数
	private int start;
	//管理员的查找条件，当为空的时候，默认筛选出全部的管理员信息
	private String condition;
	public String getCondition()
	{
		return condition;
	}
	public void setCondition(String condition)
	{
		this.condition = condition;
	}
	public int getStart()
	{
		return start;
	}
	public void setStart(int start)
	{
		this.start = start;
	}
	public int getPageIndex()
	{
		return pageIndex;
	}
	public void setPageIndex(int pageIndex)
	{
		this.pageIndex = pageIndex;
	}
	public int getLimit()
	{
		return limit;
	}
	public void setLimit(int limit)
	{
		this.limit = limit;
	}
	
	/**
	 * 用于根据传入的相关数据转变为limit语句相关的数据
	 * 根据其当前页数和每页的显示限制数目，得出其开始进行显示的数据库的条数
	 */
	public void changeLimitData()
	{
		this.start=(this.pageIndex-1)*this.limit;
	}
}
