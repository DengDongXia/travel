package utilImpl.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import util.email.EmailHelper;
/**
 * 用于邮件发送的相关类
 * @author 学徒
 *
 */
@Component
public class EmailHelperImpl implements EmailHelper
{
	//注入相关的邮件发送辅助类
	@Autowired
	private EmailSender sender;
	public boolean sendEmailToUser(String title, String context, String email)
	{
		return sender.sendEmail(title, context, email);
	}
	
}
