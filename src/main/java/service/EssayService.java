package service;

import java.util.List;

import domain.essay.Essay;
import dto.eassy.EssayDeleteInput;
import dto.eassy.EssayDetails;
import dto.eassy.ManagerEssay;
import dto.eassy.SearchEassyCondition;
import dto.eassy.SearchEssayByUser;
import dto.eassy.UserEssayResult;

/**
 * 攻略相关的服务接口
 * @author 学徒
 *
 */
public interface EssayService
{
	/**
	 * 用于获取其相应的可显示的页面的数目
	 * @return 可显示的页面的数目
	 */
	public abstract int getPageNumber(SearchEassyCondition condition);
	
	/**
	 * 根据用户输入情况的参数，查找相应的攻略信息
	 * @param condition 输入的参数的条件
	 * @return 相应的攻略信息
	 */
	public abstract List<ManagerEssay> getEssayContentList(SearchEassyCondition condition);
	
	/**
	 * 用于通过攻略的ID来获取攻略的相关内容
	 * @param essayID 攻略的ID
	 * @return 攻略的相关内容
	 */
	public abstract EssayDetails getEssayDetailsByEssayID(int essayID);
	
	/**
	 * 用于用户删除其对应的文章的相关的评论
	 * @param input 文章的输入对象
	 * @return 删除的结果
	 */
	public abstract boolean deleteEssayCommentByUser(EssayDeleteInput input);
	
	/**
	 * 用于用户删除其对应的文章的内容
	 * @param input 文章的输入对象
	 * @return 删除的结果
	 */
	public abstract boolean deleteEssayByUser(EssayDeleteInput input);
	
	/**
	 * 用于获取其用户的文章相关的对象
	 * @param input 输入对象
	 * @return 查找的结果
	 */
	public abstract List<UserEssayResult> getEssayContentList(SearchEssayByUser input);
	
	/**
	 * 用于获取其相应的分页的数目
	 * @param input 用户的输入对象
	 * @return 可进行的分页的数目
	 */
	public abstract int getPageNumbers(SearchEssayByUser input);
	
	/**
	 * 更新文章内容
	 * @param essay 文章的内容的相关对象
	 * @return 更新的结果
	 */
	public abstract boolean updateEssay(Essay essay);
	
}
