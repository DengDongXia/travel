package service;

import javax.servlet.http.HttpSession;

import domain.user.User;
import dto.user.UserRegisterInput;

/**
 * 用于用户的注册的相关服务
 * @author 学徒
 *
 */
public interface UserRegisterService
{
	/**
	 * 用于验证验证码的结果
	 * @param session 用户的Session对象
	 * @param input 用户的输入数据对象
	 * @return 验证码的结果 一致返回true，否则返回false
	 */
	public abstract boolean checkValidateCode(HttpSession session,UserRegisterInput input);
	/**
	 * 用于验证用户输入的重复密码的结果
	 * @param input 用户的输入数据对象
	 * @return 验证的结果，密码相同输入true，否则返回false
	 */
	public abstract boolean checkPasswordRepeated(UserRegisterInput input);
	
	/**
	 * 用于验证用户输入的邮箱是否存在
	 * @param input 用户的输入的数据对象
	 * @return 验证的结果,已经存在则返回true，否则返回false
	 */
	public abstract boolean existEmail(UserRegisterInput input);
	
	/**
	 * 用于新增加一个用户
	 * @param user 新增加一个用户到数据库中
	 * @return
	 */
	public abstract boolean insertUser(User user);
	
	/**
	 * 用于将用户的输入转化为一个User对象
	 * @param input 用户的输入对象
	 * @return User对象
	 */
	public abstract User makeUser(UserRegisterInput input);
	
}
