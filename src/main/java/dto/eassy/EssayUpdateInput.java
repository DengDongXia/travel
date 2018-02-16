package dto.eassy;
/**
 * 用于管理员修改相关的攻略信息的输入情况
 * @author 学徒
 *
 */
public class EssayUpdateInput
{
	private boolean state;//攻略的验证情况
	private boolean validate;//攻略的认证状态
	private int id;//攻略的ID
	public boolean isState()
	{
		return state;
	}
	public void setState(boolean state)
	{
		this.state = state;
	}
	public boolean isValidate()
	{
		return validate;
	}
	public void setValidate(boolean validate)
	{
		this.validate = validate;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
}
