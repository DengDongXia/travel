package dto.eassy;
/**
 * 攻略的删除的相关的数据输入对象
 * @author 学徒
 *
 */
public class EssayDeleteInput
{
	private int userID;//用户的ID
	private int essayID;//文章的ID
	public int getUserID()
	{
		return userID;
	}
	public void setUserID(int userID)
	{
		this.userID = userID;
	}
	public int getEssayID()
	{
		return essayID;
	}
	public void setEssayID(int essayID)
	{
		this.essayID = essayID;
	}
	
}
