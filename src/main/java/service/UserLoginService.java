package service;

import javax.servlet.http.HttpSession;

import dto.user.UserLoginInput;
import dto.user.UserLoginResult;

/**
 * 用于用户登录的相关的服务
 * @author 学徒
 *
 */
public interface UserLoginService
{
	/**
	 * 用于验证用户登录的情况
	 * @param session 用户输入的相应的session对象
	 * @param input 用户输入的数据
	 * @return 验证的结果
	 */
	public abstract UserLoginResult checkUserLogin(HttpSession session,UserLoginInput input);
}
