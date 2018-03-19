package dao.manager;

import java.util.List;

import domain.complain.Complain;
import domain.user.User;
import dto.comment.CommentComplainSearchInput;
import dto.comment.ManagerComment;
import dto.eassy.EssayUpdateInput;
import dto.eassy.ManagerEssay;
import dto.eassy.SearchEassyCondition;
import dto.manager.UpdateManagerInput;
import dto.manager.UserSearchResult;

/**
 * 用于管理员的数据库的相关操作
 * @author 学徒
 *
 */
public interface Managers
{
	/**
	 * 通过管理员的邮箱获取相应的数据库对象
	 * @param email 管理员的邮箱
	 * @return 管理员的数据库对象
	 */
	public abstract User getManagerByEmail(String email);
	
	/**
	 * 通过管理员的ID修改管理员的账号可用状态
	 * @param managerID 管理员的ID
	 * @return 修改的结果
	 */
	public abstract boolean updateManagerStatus(String managerID) throws Exception;
	
	/**
	 * 修改管理员的相关的信息
	 * @param input 用户进行修改的相关数据对象
	 * @return 修改的结果
	 */
	public abstract boolean updateManagerMessage(UpdateManagerInput input)throws Exception;
	
	/**
	 * 用于根据搜索条件获取其相应的用户的数据库对象
	 * @param condition 用户的查询条件
	 * @return 用户的数据库查询结果
	 */
	public abstract UserSearchResult getUserByCondition(String condition);
	
	/**
	 * 用于管理员更新用户的相关信息
	 * @param update 用户更新的信息
	 * @throws Exception 抛出相关的异常
	 */
	public abstract void updateUserMessage(UserSearchResult update)throws Exception;
	
	/**
	 * 用于管理员更新用户的积分情况
	 * @param update 用户更新的信息
	 * @throws Exception 抛出的异常
	 */
	public abstract void updateUserAccount(UserSearchResult update)throws Exception;
	
	/**
	 * 根据管理员的输入情况，筛选出相应的文章的情况
	 * @param condition 筛选条件
	 * @return 查找出的文章的列表
	 */
	public abstract List<ManagerEssay> getEssayByCondition(SearchEassyCondition condition);
	
	/**
	 * 用于获取其相应的文章筛选条件的文章的总数
	 * @param condition 文章筛选条件
	 * @return 文章的总数
	 */
	public abstract int getEssayPageNumber(SearchEassyCondition condition);
	
	/**
	 * 用于管理员更新用户文章的相关情况
	 * @param essay 文章的修改情况
	 * @return 修改的结果
	 */
	public abstract boolean updateEssayByManager(EssayUpdateInput essayInput);
	
	/**
	 * 用于管理员根据评论的ID获取其对应的评论的相关内容信息
	 * @param commentID 评论的ID
	 * @return 评论的相关内容
	 */
	public abstract List<ManagerComment> getCommentByCommentID(CommentComplainSearchInput commentInput);
	
	/**
	 * 用于管理员根据评论的ID删除相应的信息
	 * @param commentID 评论的ID
	 * @return 删除的结果
	 */
	public abstract boolean deleteComment(int commentID);
	
	/**
	 * 用于设置其相关的举报的管理员审核情况
	 * @param complain 管理员的审核的情况的封装对象
	 */
	public abstract boolean updateComplainState(int commentID);
	
	/**
	 * 用于获取其评论的相关的可显示的页面的数目
	 * @param commentInput 评论的输入情况
	 * @return 可显示的页面数目
	 */
	int getComplainPageNumber(CommentComplainSearchInput commentInput);
}
