package dao.user;

import domain.user.User;
import dto.user.UpdateUserMessageInput;

/**
 * 用于用户相关的操作
 * @author 学徒
 *
 */
public interface Users
{
	/**
	 * 通过用户的邮箱获取相应的用户信息
	 * @param email 用户输入的邮箱
	 * @return 用户的数据
	 */
	public abstract User getUserByEmail(String email);
	/**
	 * 新增用户
	 * @param user 要进行新增的用户的数据 
	 * @return 数据库受影响的行数
	 */
	public abstract int insertUser(User user);
	/**
	 * 往数据库的用户数据角色表中插入相关的数据
	 * @param userId 用户ID
	 * @return 数据库受影响的行数
	 */
	public abstract int insertUserRole(int userId); 
	
	/**
	 * 往数据库中的用户积分表中插入相关的数据
	 * @param userId 用户ID
	 * @return 数据库受影响的行数
	 */
	public abstract int insertUserAccount(int userId);
	
	/**
	 * 用于更新其用户相关的信息
	 * @param input 用户的输入对象
	 * @return 受影响的行数
	 */
	public abstract int updateUserMessage(UpdateUserMessageInput input);
}
