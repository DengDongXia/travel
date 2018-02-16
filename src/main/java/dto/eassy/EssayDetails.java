package dto.eassy;

import java.util.Date;

/**
 * 攻略相关的细节类
 * @author 学徒
 *
 */
public class EssayDetails
{
	private int essayID;//攻略的ID
	private String context;//攻略的内容
	private String essayPictureURL;//攻略的标题图像
	private String personPictureURL;//攻略的发布人的图像
	private String essayHeader;//攻略的标题
	private String country;//攻略描述的国家
	private Date time;//攻略的发布时间
	private boolean validate;//攻略的认证情况
	public int getEssayID()
	{
		return essayID;
	}
	public void setEssayID(int essayID)
	{
		this.essayID = essayID;
	}
	public String getContext()
	{
		return context;
	}
	public void setContext(String context)
	{
		this.context = context;
	}
	public String getEssayPictureURL()
	{
		return essayPictureURL;
	}
	public void setEssayPictureURL(String essayPictureURL)
	{
		this.essayPictureURL = essayPictureURL;
	}
	public String getPersonPictureURL()
	{
		return personPictureURL;
	}
	public void setPersonPictureURL(String personPictureURL)
	{
		this.personPictureURL = personPictureURL;
	}
	public String getEssayHeader()
	{
		return essayHeader;
	}
	public void setEssayHeader(String essayHeader)
	{
		this.essayHeader = essayHeader;
	}
	public String getCountry()
	{
		return country;
	}
	public void setCountry(String country)
	{
		this.country = country;
	}
	public Date getTime()
	{
		return time;
	}
	public void setTime(Date time)
	{
		this.time = time;
	}
	public boolean isValidate()
	{
		return validate;
	}
	public void setValidate(boolean validate)
	{
		this.validate = validate;
	}
}
