package dao.superManager;

import java.util.List;

import domain.user.User;
import dto.manager.AllManagerMessage;
import dto.manager.ManagerShow;


/**
 * 用于超级管理员相关的数据库操作的对象
 * @author 学徒
 *
 */
public interface SuperManagers
{
	/**
	 * 根据邮箱获取超级管理员对应的数据库对象
	 * @param email 超级管理员的邮箱
	 * @return 超级管理员的数据库对象
	 */
	public abstract User getSuperManagerByEmail(String email);
	
	/**
	 * 根据用户的输入对象，往用户表中插入相关的对象
	 * @param input 用户的输入对象
	 * @return 数据库受影响的行数
	 */
	public abstract int insertManagerToUser(User input);
	
	/**
	 * 用于往用户角色表中插入相关的数据
	 * @param id 新增的管理员的id
	 * @return 数据库受影响的行数
	 */
	public abstract int insertManagerToUserRole(int id);
	
	/**
	 * 根据管理员的邮箱账号，获取其对应的用户id
	 * @param email 邮箱账号
	 * @return 用户对应的id
	 */
	public abstract int getManagerIdByEmail(String email);
	
	/**
	 * 用于分页获取数据库中的所有管理员用户的数据
	 * @param limit 分页的限制条件
	 * @return 所有管理员所组成的列表
	 */
	public abstract List<AllManagerMessage> getAllManager(ManagerShow limit);
	
	/**
	 * 用于获取数据库中管理员的数据的分页数目
	 * @param limit 分页的限制条件
	 * @return 可以分页的数目
	 */
	public abstract int getPageNumber(ManagerShow limit);
	
	/**
	 * 用于超级管理员根据管理员的相关信息删除管理员的记录
	 * @param id 管理员的id
	 * @return 删除的结果
	 */
	boolean deleteManagerUser(int id);
	
	/**
	 * 用于超级管理员根据管理员的相关信息删除管理员的用户角色记录
	 * @param id 管理员的id
	 * @return 删除的结果
	 */
	boolean deleteManagerRole(int id);
	
	/**
	 * 用于根据用户的ID判断是否为管理员
	 * @param id 用户的ID
	 * @return 其用户角色的ID
	 */
	int IsUserManager(int id);
}
