package serviceImpl;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.UserLoginService;
import util.password.PasswordSecurity;
import dao.user.Users;
import domain.user.User;
import dto.user.UserLoginInput;
import dto.user.UserLoginResult;
@Service
public class UserLoginServiceImpl implements UserLoginService
{
	@Autowired
	private Users userLogin;//数据库的相关的操作类
	@Autowired
	private PasswordSecurity passwordSecurity;//用户密码的相关的加密类
	
	public UserLoginResult checkUserLogin(HttpSession session,UserLoginInput input)
	{
		boolean validateCodeResult=this.checkUserValidateCode(input, session);
		User user=this.getUserByEmail(input);
		boolean emailResult= (user!=null);
		boolean passwordResult=this.checkUserPassword(input, user);
		boolean accountState=this.checkLocked(user);
		UserLoginResult result=new UserLoginResult(emailResult,validateCodeResult,passwordResult,accountState);
		//当通过验证的时候，将查询到的用户数据保存到session中
		if(result.isPass())
			session.setAttribute("user", user);
		return result;
	}
	/**
	 * 用于获取用户的锁定状态
	 * @param user 数据库用户的查询结果
	 * @return 用户的锁定状态
	 */
	private boolean checkLocked(User user)
	{
		boolean result=false;
		if(user!=null&&!user.isLocked())
			result=true;
		return result;
	}
	/**
	 * 用于验证用户输入的验证码的结果
	 * @param input 用户的输入的数据对象
	 * @param session 用户的session对象
	 * @return 验证的结果
	 */
	private boolean checkUserValidateCode(UserLoginInput input,HttpSession session)
	{
		return input.getValidateCode().equalsIgnoreCase((String)session.getAttribute("validate"));
	}
	
	/**
	 * 用于验证用户输入的密码的结果和数据库中的结果
	 * @param input 用户的输入数据对象
	 * @param user 用户的数据库对象
	 * @return 验证的结果
	 */
	private boolean checkUserPassword(UserLoginInput input,User user)
	{
		boolean result=false;
		if(user!=null)
		{
			try
			{
				byte[] digestByteArray = passwordSecurity.digest(input.getPassword(),user.getTimestamp());
				String password=passwordSecurity.encodeByteArrays(digestByteArray);
				result=user.getPassword().equals(password);
			}
			catch (UnsupportedEncodingException e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	 * 根据用户的输入对象的相关数据，依据其邮箱号码，获取数据库的相关的用户数据
	 * @param input
	 * @return 数据库中的用户的数据对象
	 */
	private User getUserByEmail(UserLoginInput input)
	{
		return userLogin.getUserByEmail(input.getEmail());
	}
	
	/**
	 * 用于验证用户的登录情况
	 * @Param session 用户的相关的session对象
	 * @return 用户的信息
	 */
	public User getLoginCheck(HttpSession session)
	{
		User user=(User)session.getAttribute("user");
		if(user==null)
			user=new User();
		return user;
	}
}
