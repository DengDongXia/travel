package service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dto.manager.AddManagerInput;
import dto.manager.AddManagerResult;
import dto.manager.ManagerShow;
import dto.manager.UpdateManagerInput;
import dto.user.UserLoginInput;
import dto.user.UserLoginResult;
/**
 * 用于超级管理员相关的服务对象
 * @author 学徒
 *
 */
public interface SuperManagerService
{
	/**
	 * 用于验证超级管理员的登录情况
	 * @param input 管理员的输入数据对象
	 * @param session 管理员的会话对象
	 * @return 验证的结果
	 */
	public abstract UserLoginResult superManagerLoginCheck(UserLoginInput input,HttpSession session);
	
	/**
	 * 用于超级管理员新增管理员的情况
	 * @param input 输入的需要新增的管理员信息
	 * @return 新增的结果
	 */
	public abstract AddManagerResult addManager(AddManagerInput input);
	
	/**
	 * 用于获取对应的数据库的管理员信息
	 * @return 管理员信息的列表
	 */
	public abstract Map<String,Object>  getAllManager(ManagerShow limit);
	
	/**
	 * 修改管理员的账号可用状态
	 * @param managerID 管理员的ID
	 * @return 修改的结果
	 */
	public abstract boolean updateManagerStatus(String managerID);
	
	/**
	 * 修改管理员的相关信息
	 * @param input 管理员信息修改的相关数据对象
	 * @return 修改的结果
	 */
	public abstract Map<String,Boolean> updateManagerMessage(UpdateManagerInput input,HttpSession session);
	
	/**
	 * 用于超级管理员根据根据管理员的Id删除相应的管理员记录
	 * @param id 管理员的Id
 	 * @return 删除的结果
	 */
	boolean deleteManager(int id);
}
