package service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import dto.comment.ManagerComment;
import dto.eassy.EssayUpdateInput;
import dto.eassy.ManagerEssay;
import dto.eassy.SearchEassyCondition;
import dto.manager.UserSearchResult;
import dto.user.UserLoginInput;
import dto.user.UserLoginResult;

/**
 * 用于验证管理员的登录情况，以及管理员的其它的相关服务
 * @author 学徒
 *
 */
public interface ManagerService
{
	/**
	 * 用于验证管理员的登录情况
	 * @param input 管理员的输入数据对象
	 * @param session 管理员的会话对象
	 * @return 验证的结果
	 */
	public abstract UserLoginResult managerLoginCheck(UserLoginInput input,HttpSession session);
	
	/**
	 * 用于管理员根据搜索条件查找相关的用户信息
	 * @param condition 管理员查找用户的条件
	 * @return 管理员查找的结果
	 */
	public abstract UserSearchResult getUserByCondition(String condition);
	
	/**
	 * 用于管理员更新用户的相关信息
	 * @param updateResult 用户更新后的信息
	 * @return 更新的结果
	 */
	public abstract Map<String,Boolean> managerUpdateUser(UserSearchResult updateResult);
	
	/**
	 * 用于管理员获取的文章的相关内容
	 * @param condition 管理员文章查找的相关条件
	 * @return 文章的查找结果组成的列表
	 */
	public abstract List<ManagerEssay> getEassyContent(SearchEassyCondition condition);
	
	/**
	 * 用于管理员根据输入的条件获取其对应的文章的分页情况
	 * @param condition 输入的查找条件
	 * @return 文章的分页情况
	 */
	public abstract int getEassyPageNumber(SearchEassyCondition condition);
	
	/**
	 * 用于管理员根据输入的情况修改其对应的文章
	 * @param 文章的修改情况
	 * @return 修改的结果
	 */
	public abstract boolean updateEssayByManager(EssayUpdateInput essayInput);
	
	/**
	 * 根据评论的ID，搜索出相应的信息
	 * @param commentID 评论的ID
	 * @return 相应的内容信息
	 */
	public abstract ManagerComment getCommentByCommentID(int commentID);

	/**
	 * 用于管理员根据评论的ID删除相关的评论
	 * @param commentID 删除相应的评论记录
	 * @return 执行的结果
	 */
	public abstract boolean deleteComment(int commentID);
	
}
