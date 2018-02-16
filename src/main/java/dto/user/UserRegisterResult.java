package dto.user;
/**
 * 返回用户进行注册的结果
 * @author 学徒
 *
 */
public class UserRegisterResult
{
	private boolean identifyCodeResult;//验证码的结果
	private boolean existEmail;//邮箱已存在
	private boolean password;//密码不一致
	public UserRegisterResult(){}
	public UserRegisterResult(boolean identifyCodeResult,boolean password,boolean existEmail)
	{
		this.identifyCodeResult=identifyCodeResult;
		this.password=password;
		this.existEmail=existEmail;
	}
	public boolean isRepeateEmail()
	{
		return existEmail;
	}
	public void setRepeateEmail(boolean existEmail)
	{
		this.existEmail = existEmail;
	}
	public boolean isPassword()
	{
		return password;
	}
	public void setPassword(boolean password)
	{
		this.password = password;
	}
	public boolean getIdentifyCodeResult()
	{
		return this.identifyCodeResult;
	}
	public void setIdentifyCodeResult(boolean identifyCodeResult)
	{
		this.identifyCodeResult=identifyCodeResult;
	}
}
