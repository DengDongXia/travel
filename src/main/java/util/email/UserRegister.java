package util.email;

import javax.servlet.http.HttpSession;

/**
 * 用户注册的相关的邮件验证码的发送类
 * @author 学徒
 *
 */
public interface UserRegister
{
	/**
	 * 用于获取验证码，并将其保存在Session中，同时，返回生成的验证码 
	 * @return 返回获取到的验证码
	 */
	public abstract String getEmailRandomValidate(HttpSession session);
	/**
	 * 用于发送验证码到给定的邮箱中
	 * @param validate 验证码
	 * @param email 邮箱
	 * @return 发送的结果
	 */
	public abstract boolean sendValidate(String validate,String email);
}
