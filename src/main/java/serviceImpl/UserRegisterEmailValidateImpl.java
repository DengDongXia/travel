package serviceImpl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.UserRegisterEmailValidate;
import util.email.UserRegister;

/**
 * 用于实现用户注册的邮件的发送的相关类
 * @author 学徒
 *
 */
@Service
public class UserRegisterEmailValidateImpl implements UserRegisterEmailValidate
{
	
	@Autowired
	private UserRegister userEmailSender;//用于注入相关的邮件发送类
	
	public String getValidateCode(HttpSession session)
	{
		return userEmailSender.getEmailRandomValidate(session);
	}

	public boolean sendValidateCodeToEmail(String validate, String email)
	{
		return userEmailSender.sendValidate(validate, email);
	}
	
}
