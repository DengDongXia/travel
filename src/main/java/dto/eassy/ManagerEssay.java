package dto.eassy;
/**
 * 文章相关的数据对象
 * @author 学徒
 *
 */
public class ManagerEssay
{
	private String eassyPicture;//文章标题图片的URL
	private String eassyHeader;//文章的标题
	private String eassyCountry;//文章所描述的国家
	private String eassyContent;//文章的内容
	private int eassyID;//文章的ID
	private String eassyPersonName;//文章的发布人的昵称
	private int eassyPersonID;//文章的发布人的ID
	private String eassyPersonPicture;//文章的发布人的图像
	private int eassyCommentCount;//文章评论的数目
	private boolean eassyState;//文章的状态
	public int getEassyPersonID()
	{
		return eassyPersonID;
	}
	public void setEassyPersonID(int eassyPersonID)
	{
		this.eassyPersonID = eassyPersonID;
	}
	public String getEassyPersonPicture()
	{
		return eassyPersonPicture;
	}
	public void setEassyPersonPicture(String eassyPersonPicture)
	{
		this.eassyPersonPicture = eassyPersonPicture;
	}
	public String getEassyPicture()
	{
		return eassyPicture;
	}
	public void setEassyPicture(String eassyPicture)
	{
		this.eassyPicture = eassyPicture;
	}
	public String getEassyHeader()
	{
		return eassyHeader;
	}
	public void setEassyHeader(String eassyHeader)
	{
		this.eassyHeader = eassyHeader;
	}
	public String getEassyCountry()
	{
		return eassyCountry;
	}
	public void setEassyCountry(String eassyCountry)
	{
		this.eassyCountry = eassyCountry;
	}
	public String getEassyContent()
	{
		return eassyContent;
	}
	public void setEassyContent(String eassyContent)
	{
		this.eassyContent = eassyContent;
	}
	public int getEassyID()
	{
		return eassyID;
	}
	public void setEassyID(int eassyID)
	{
		this.eassyID = eassyID;
	}
	public String getEassyPersonName()
	{
		return eassyPersonName;
	}
	public void setEassyPersonName(String eassyPersonName)
	{
		this.eassyPersonName = eassyPersonName;
	}
	public int getEassyCommentCount()
	{
		return eassyCommentCount;
	}
	public void setEassyCommentCount(int eassyCommentCount)
	{
		this.eassyCommentCount = eassyCommentCount;
	}
	public boolean isEassyState()
	{
		return eassyState;
	}
	public void setEassyState(boolean eassyState)
	{
		this.eassyState = eassyState;
	}
}
