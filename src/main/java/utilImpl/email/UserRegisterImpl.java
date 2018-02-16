package utilImpl.email;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import util.email.EmailHelper;
import util.email.UserRegister;
import util.validate.RandomString;

/**
 * 用于实现验证码的发送
 * @author 学徒
 *
 */
@Component
public class UserRegisterImpl implements UserRegister
{
	//注入随机数生成的类
	@Autowired
	@Qualifier("randomString")
	private RandomString random;
	//注入用于发送邮件的类
	@Autowired
	private EmailHelper emailHelper;
	public String getEmailRandomValidate(HttpSession session)
	{
		String validate=random.randomString(5);
		session.setAttribute("registerValidate",validate);
		return validate;
	}

	public boolean sendValidate(String validate, String email)
	{
		String title="旅游攻略指南~欢迎用户注册";
		String context="欢迎来到旅游攻略指南网站，邮箱验证码为: "+validate+"，请尽快完成实现注册哦~";
		return emailHelper.sendEmailToUser(title, context, email);
	}

}
