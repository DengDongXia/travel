package service;

import javax.servlet.http.HttpSession;

import domain.user.User;
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
	
	/**
	 * 用于获取用户的登录的信息
	 * @param session 用户的session对象
	 * @return  用户的相关信息
	 */
	public abstract User getLoginCheck(HttpSession session);
}
