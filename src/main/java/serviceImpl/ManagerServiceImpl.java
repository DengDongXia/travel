package serviceImpl;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.ManagerService;
import util.password.PasswordSecurity;
import dao.manager.Managers;
import domain.user.User;
import dto.comment.ManagerComment;
import dto.eassy.EssayUpdateInput;
import dto.eassy.ManagerEssay;
import dto.eassy.SearchEassyCondition;
import dto.manager.UserSearchResult;
import dto.user.UserLoginInput;
import dto.user.UserLoginResult;
@Service
public class ManagerServiceImpl implements ManagerService
{
	@Autowired
	private Managers manager;//管理员相关的数据库操作
	@Autowired
	private PasswordSecurity passwordSecurity;//密码相关的验证
	
	public UserLoginResult managerLoginCheck(UserLoginInput input,HttpSession session)
	{
		boolean validateCodeResult=this.checkUserValidateCode(input, session);
		User manager=this.getManagerByEmail(input);
		boolean emailResult= manager!=null;
		boolean passwordResult=this.checkUserPassword(input, manager);
		boolean accountState=this.checkLocked(manager);
		UserLoginResult result=new UserLoginResult(emailResult,validateCodeResult,passwordResult,accountState);
		//当通过验证的时候，将查询到的用户数据保存到session中
		if(result.isPass())
			session.setAttribute("user", manager);
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
		return input.getValidateCode().equals((String)session.getAttribute("validate"));
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
	private User getManagerByEmail(UserLoginInput input)
	{
		return manager.getManagerByEmail(input.getEmail());
	}
	
	public UserSearchResult getUserByCondition(String condition)
	{
		return manager.getUserByCondition(condition);
	}
	
	public Map<String,Boolean> managerUpdateUser(UserSearchResult update)
	{
		boolean updateResult=true;
		try
		{
			update.setUserStatus(!update.isUserStatus());
			manager.updateUserMessage(update);
			manager.updateUserAccount(update);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			updateResult=false;
		}
		Map<String,Boolean> result=new HashMap<String,Boolean>();
		result.put("userUpdateResult",updateResult);
		return result;
	}
	
	public List<ManagerEssay> getEassyContent(SearchEassyCondition condition)
	{
		//设置其相应的sql语句的limit条件的起始参数
		condition.setStart();
		List<ManagerEssay> result =manager.getEssayByCondition(condition);
		return result;
	}

	public int getEassyPageNumber(SearchEassyCondition condition)
	{
		return manager.getEssayPageNumber(condition);
	}

	public boolean updateEssayByManager(EssayUpdateInput essayInput)
	{
		return manager.updateEssayByManager(essayInput);
	}
	
	public ManagerComment getCommentByCommentID(int commentID)
	{
		return manager.getCommentByCommentID(commentID);
	}
	
	public boolean deleteComment(int commentID)
	{
		return manager.deleteComment(commentID);
	}
	
}
