package dto.user;

public class UserRegisterInput
{
	private String email;
	private String password;
	private String repeatePassword;
	private String emailValidateCode;
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
	public String getRepeatePassword()
	{
		return repeatePassword;
	}
	public void setRepeatePassword(String repeatePassword)
	{
		this.repeatePassword = repeatePassword;
	}
	public String getEmailValidateCode()
	{
		return emailValidateCode;
	}
	public void setEmailValidateCode(String emailValidateCode)
	{
		this.emailValidateCode = emailValidateCode;
	}
	
}
