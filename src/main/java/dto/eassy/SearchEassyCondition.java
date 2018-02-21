package dto.eassy;
/**
 * 管理员进行文章搜索的查找条件
 * @author 学徒
 *
 */
public class SearchEassyCondition
{
	private int pageIndex;//进行分页查询的当前页
	private int showLimit;//每页显示的数目
	private String condition;//搜索的条件(文章的ID)，当其为null时，将按照进行认证的文章进行显示
	private int start;//根据其他参数的结果，得到limit语句的参数
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
		return this.start;
	}
	public void setStart()//用于设置limit语句的相关参数
	{
		this.start=(this.pageIndex-1)*this.showLimit;
	}
	
}
