package dto.manager;
/**
 * 超级管理员增添管理员时的数据对象
 * @author 学徒
 *
 */
public class AddManagerInput
{
	//管理员登录的邮箱
	private String email;
	//管理员登录的姓名
	private String name;
	//管理员登录的密码,可默认，默认的情况下为 "123"
	private String password="123";
	//管理员的个性签名,可默认，默认的情况下为   "花自飘零水自流!!!"
	private String quote="花自飘零水自流!!!";
	public AddManagerInput(){}
	public AddManagerInput(String email,String name,String password,String quote)
	{
		this.email=email;
		this.name=name;
		this.password=password;
		this.quote=quote;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getQuote()
	{
		return quote;
	}
	public void setQuote(String quote)
	{
		this.quote = quote;
	}
	
	
}
