package service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 该类用于验证码的获取以及值的验证
 * @author 学徒
 *
 */
public interface ValidateCodeGetAndCheck
{
	/**
	 * 用于验证其输入的二维码的值和session中生成的二维码的值的相等情况
	 * @param session 用户的session对象
	 * @param input 用户输入的二维码的值
	 * @return 验证的结果
	 */
	public abstract boolean checkValidateCode(HttpSession session,String input);
	
	/**
	 * 用于直接输出验证码到response对象中
	 * @param response 输出对象
	 * @param session 保存对象
	 */
	public abstract void getValidateCodeAndOutput(HttpServletResponse response,HttpSession session);
}