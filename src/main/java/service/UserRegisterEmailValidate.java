package service;

import javax.servlet.http.HttpSession;

/**
 * 用于用户邮箱注册验证码的发送
 * @author 学徒
 *
 */
public interface UserRegisterEmailValidate
{
	/**
	 * 用于获取验证码并将验证码保存在session中
	 * @param session 保存的session对象
	 * @return 所生成的验证码
	 */
	public abstract String getValidateCode(HttpSession session);
	/**
	 * 将生成的验证码发送到相应的邮箱地址中
	 * @param validateCode 要进行发送的验证码
	 * @param email 要发送的邮箱地址
	 * @return 发送的结果
	 */
	public abstract boolean sendValidateCodeToEmail(String validate,String email);
}
