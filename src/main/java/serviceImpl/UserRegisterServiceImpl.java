package serviceImpl;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.UserRegisterService;
import util.password.PasswordSecurity;
import dao.user.Users;
import domain.user.User;
import dto.user.UserRegisterInput;
@Service
public class UserRegisterServiceImpl implements UserRegisterService
{
	@Autowired
	private Users userRegister;//用户注册的数据库操作类
	@Autowired
	private PasswordSecurity passwordSecurity;//密码安全的相关的操作类
	
	public boolean checkValidateCode(HttpSession session,UserRegisterInput input)
	{
		return ((String)session.getAttribute("registerValidate")).equalsIgnoreCase(input.getEmailValidateCode());
	}

	public boolean checkPasswordRepeated(UserRegisterInput input)
	{
		return input.getPassword().equalsIgnoreCase(input.getRepeatePassword());
	}

	public boolean existEmail(UserRegisterInput input)
	{
		User user=userRegister.getUserByEmail(input.getEmail());
		return user!=null;
	}

	public boolean insertUser(User user)
	{
		int insertUserResult=userRegister.insertUser(user);
		System.out.println(user.getEmail());
		int id=userRegister.getInsertUserId(user.getEmail());
//		User returnUser=userRegister.getUserByEmail(user.getEmail());
		int insertUserRoleResult=userRegister.insertUserRole(id);
		int insertUserAccount=userRegister.insertUserAccount(id);
		return insertUserResult!=0&&insertUserRoleResult!=0&&insertUserAccount!=0;
	}

	public User makeUser(UserRegisterInput input)
	{
		User user=new User();
		user.setEmail(input.getEmail());
		user.setTimestamp(String.valueOf(System.currentTimeMillis()));
		user.setName(input.getEmail().substring(0,7));
		try
		{
			user.setPassword(passwordSecurity.encodeByteArrays((passwordSecurity.digest(input.getPassword(), user.getTimestamp()))));
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		return user;
	}
	
	
}
