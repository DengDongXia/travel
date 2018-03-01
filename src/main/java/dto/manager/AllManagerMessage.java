package dto.manager;
/**
 * 用于超级管理员查找管理员的信息的显示
 * @author 学徒
 *
 */
public class AllManagerMessage
{
	private int managerID;//管理员的Id
	private String managerName;//管理员的姓名
	private String managerQuote;//管理员的个性签名
	private String managerPicture;//管理员的照片
	private boolean managerStatus;//管理员的状态
	public int getManagerID()
	{
		return managerID;
	}
	public void setManagerID(int managerID)
	{
		this.managerID = managerID;
	}
	public String getManagerName()
	{
		return managerName;
	}
	public void setManagerName(String managerName)
	{
		this.managerName = managerName;
	}
	public String getManagerQuote()
	{
		return managerQuote;
	}
	public void setManagerQuote(String managerQuote)
	{
		this.managerQuote = managerQuote;
	}
	public String getManagerPicture()
	{
		return managerPicture;
	}
	public void setManagerPicture(String managerPicture)
	{
		this.managerPicture = managerPicture;
	}
	public boolean isManagerStatus()
	{
		return managerStatus;
	}
	public void setManagerStatus(boolean managerStatus)
	{
		this.managerStatus = managerStatus;
	}
}
