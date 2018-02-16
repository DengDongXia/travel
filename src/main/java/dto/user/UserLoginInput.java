package dto.user;
/**
 * 用户登录时的输入对象
 * @author 学徒
 *
 */
public class UserLoginInput
{
	//邮箱
	private String email;
	//密码
	private String password;
	//验证码
	private String validateCode;
	public UserLoginInput(){}
	public UserLoginInput(String email,String password,String validateCode)
	{
		this.email=email;
		this.password=password;
		this.validateCode=validateCode;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getValidateCode()
	{
		return validateCode;
	}
	public void setValidateCode(String validateCode)
	{
		this.validateCode = validateCode;
	}
}
