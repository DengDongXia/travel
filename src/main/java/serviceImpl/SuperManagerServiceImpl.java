package serviceImpl;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.SuperManagerService;
import util.password.PasswordSecurity;
import dao.manager.Managers;
import dao.superManager.SuperManagers;
import domain.user.User;
import dto.manager.AddManagerInput;
import dto.manager.AddManagerResult;
import dto.manager.AllManagerMessage;
import dto.manager.ManagerShow;
import dto.manager.UpdateManagerInput;
import dto.user.UserLoginInput;
import dto.user.UserLoginResult;
@Service
public class SuperManagerServiceImpl implements SuperManagerService
{
	@Autowired
	private SuperManagers superManager;//超级管理员的数据库操作对象
	@Autowired
	private PasswordSecurity passwordSecurity;//密码相关的验证
	@Autowired
	private Managers manager;//管理员相关的数据库操作对象
	
	public Map<String,Object> getAllManager(ManagerShow limit)
	{
		Map<String,Object> result=new HashMap<String,Object>();
		//用于获取管理员的数目
		List<AllManagerMessage> managerList=superManager.getAllManager(limit);
		//用于获取管理员的相关的数据列表
		int pageNumber=superManager.getPageNumber(limit);
		result.put("pageNumber",pageNumber);
		result.put("content", managerList);
		return result;
	}
	
	public AddManagerResult addManager(AddManagerInput input)
	{
		boolean existManager=this.isExistManager(input.getEmail());
		AddManagerResult result=new AddManagerResult(true,"");
		if(existManager==false)
		{
			User user=this.makeUserByManagerInput(input);
			superManager.insertManagerToUser(user);
			int id=superManager.getManagerIdByEmail(input.getEmail());
			superManager.insertManagerToUserRole(id);
		}
		else
		{
			result.setAddManagerResult(false);
			result.setFalseResult("管理员邮箱已存在");
		}
		return result;
	}
	/**
	 * 用于实现管理员的输入数据对象到插入数据库的用户对象的转换
	 * @param input 超级管理员的输入数据对象
	 * @return
	 */
	private User makeUserByManagerInput(AddManagerInput input)
	{
		User user=new User();
		user.setEmail(input.getEmail());
		user.setName(input.getName());
		user.setQuote(input.getQuote());
		String timeStamp=String.valueOf(System.currentTimeMillis());
		user.setTimestamp(timeStamp);
		try
		{
			user.setPassword(passwordSecurity.encodeByteArrays((passwordSecurity.digest(input.getPassword(),timeStamp))));
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		return user;
	}
	
	/**
	 * 用于判断新增的管理员是否已经存在
	 * @param email 新增的管理员的邮箱
	 * @return 为true时表示存在，为false时表示不存在
	 */
	private boolean isExistManager(String email)
	{
		User user=manager.getManagerByEmail(email);
		return user!=null;
	}
	
	public UserLoginResult superManagerLoginCheck(UserLoginInput input,HttpSession session)
	{
		boolean validateCodeResult=this.checkUserValidateCode(input, session);
		User superManager=this.getSuperManagerByEmail(input);
		boolean emailResult= superManager!=null;
		boolean passwordResult=this.checkUserPassword(input, superManager);
		boolean accountState=this.checkLocked(superManager);
		UserLoginResult result=new UserLoginResult(emailResult,validateCodeResult,passwordResult,accountState);
		//当通过验证的时候，将查询到的用户数据保存到session中
		if(result.isPass())
			session.setAttribute("user", superManager);
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
	 * @param input 用户的输入对象
	 * @return 数据库中的用户的数据对象
	 */
	private User getSuperManagerByEmail(UserLoginInput input)
	{
		return superManager.getSuperManagerByEmail(input.getEmail());
	}
	
	public boolean updateManagerStatus(String managerID)
	{
		boolean result=true;
		try
		{
			manager.updateManagerStatus(managerID);
		}
		catch(Exception e)
		{
			result=false;
		}
		return result;
	}
	
	public Map<String,Boolean> updateManagerMessage(UpdateManagerInput input,HttpSession session)
	{
		Map<String,Boolean> result=new HashMap<String,Boolean>();
		result.put("managerUpdateResult",true);
		try
		{
			manager.updateManagerMessage(input);
			User user=(User)session.getAttribute("user");
			user.setEmail(input.getEmail());
			user.setName(input.getName());
			user.setPictureURL(input.getPictureURL());
			user.setQuote(input.getQuote());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			result.put("managerUpdateResult",false);
		}
		return result;
	}

	public boolean deleteManager(int id)
	{
		boolean result=false;
		if(superManager.IsUserManager(id)==1)//用于判断超级管理员要进行删除的是否为管理员
		{
			result=superManager.deleteManagerUser(id);
			if(result)
				superManager.deleteManagerRole(id);
		}
		return result;
	}
}
