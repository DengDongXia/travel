package dto.user;
/**
 * 用户登录的结果对象
 * @author 学徒
 *
 */
public class UserLoginResult
{
	//邮箱账号的结果
	private boolean emailResult;
	//验证码的结果
	private boolean identifyCodeResult;
	//密码的结果
	private boolean passwordResult;
	//账号状态
	private boolean accountState;
	public UserLoginResult(){}
	public UserLoginResult(boolean emailResult,boolean identifyCodeResult,boolean passwordResult,boolean accountState)
	{
		this.emailResult=emailResult;
		this.identifyCodeResult=identifyCodeResult;
		this.passwordResult=passwordResult;
		this.accountState=accountState;
	}
	public boolean isEmailResult()
	{
		return emailResult;
	}
	public void setEmailResult(boolean emailResult)
	{
		this.emailResult = emailResult;
	}
	public boolean isIdentifyCodeResult()
	{
		return identifyCodeResult;
	}
	public void setIdentifyCodeResult(boolean identifyCodeResult)
	{
		this.identifyCodeResult = identifyCodeResult;
	}
	public boolean isPasswordResult()
	{
		return passwordResult;
	}
	public void setPasswordResult(boolean passwordResult)
	{
		this.passwordResult = passwordResult;
	}
	public boolean isAccountState()
	{
		return accountState;
	}
	public void setAccountState(boolean accountState)
	{
		this.accountState = accountState;
	}
	/**
	 * 该方法用于验证用户是否可以顺利登录
	 * @return 为true的时候表示可以顺利登录，为false的时候，表示不能顺利进行登录
	 */
	public boolean isPass()
	{
		return this.accountState&&this.emailResult&&this.identifyCodeResult&&this.passwordResult;
	}
}
