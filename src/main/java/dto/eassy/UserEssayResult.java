package dto.eassy;
/**
 * 用户查找其对应的攻略相关的数据对象
 * @author 学徒
 *
 */
public class UserEssayResult
{
	private String essayPicture;//文章的照片
	private String essayHeader;//文章的标题
	private String essayContent;//文章的内容
	private String essayCountry;//文章所描述的国家
	private int essayID;//文章的ID
	private String essayPersonName;//文章发布人的姓名
	private int commentCount;//文章的评论数目
	private boolean essayStatus;//文章的状态
	public String getEssayPicture()
	{
		return essayPicture;
	}
	public void setEssayPicture(String essayPicture)
	{
		this.essayPicture = essayPicture;
	}
	public String getEssayHeader()
	{
		return essayHeader;
	}
	public void setEssayHeader(String essayHeader)
	{
		this.essayHeader = essayHeader;
	}
	public String getEssayContent()
	{
		return essayContent;
	}
	public void setEssayContent(String essayContent)
	{
		this.essayContent = essayContent;
	}
	public String getEssayCountry()
	{
		return essayCountry;
	}
	public void setEssayCountry(String essayCountry)
	{
		this.essayCountry = essayCountry;
	}
	public int getEssayID()
	{
		return essayID;
	}
	public void setEssayID(int essayID)
	{
		this.essayID = essayID;
	}
	public String getEssayPersonName()
	{
		return essayPersonName;
	}
	public void setEssayPersonName(String essayPersonName)
	{
		this.essayPersonName = essayPersonName;
	}
	public int getCommentCount()
	{
		return commentCount;
	}
	public void setCommentCount(int commentCount)
	{
		this.commentCount = commentCount;
	}
	public boolean isEssayStatus()
	{
		return essayStatus;
	}
	public void setEssayStatus(boolean essayStatus)
	{
		this.essayStatus = essayStatus;
	}
}
