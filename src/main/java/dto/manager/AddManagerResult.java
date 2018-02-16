package dto.manager;
/**
 * 超级管理员增添管理员时的结果数据对象
 * @author 学徒
 *
 */
public class AddManagerResult
{
	//添加用户的结果
	private boolean addManagerResult;
	//添加用户失败的原因
	private String falseResult;
	public AddManagerResult(){}
	public AddManagerResult(boolean addManagerResult,String falseResult)
	{
		this.addManagerResult=addManagerResult;
		this.falseResult=falseResult;
	}
	public boolean isAddManagerResult()
	{
		return addManagerResult;
	}
	public void setAddManagerResult(boolean addManagerResult)
	{
		this.addManagerResult = addManagerResult;
	}
	public String getFalseResult()
	{
		return falseResult;
	}
	public void setFalseResult(String falseResult)
	{
		this.falseResult = falseResult;
	}
	
}
