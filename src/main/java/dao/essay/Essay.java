package dao.essay;

import java.util.List;

import dto.eassy.EssayDeleteInput;
import dto.eassy.EssayDetails;
import dto.eassy.ManagerEssay;
import dto.eassy.SearchEassyCondition;
import dto.eassy.SearchEssayByUser;
import dto.eassy.UserEssayResult;

/**
 * 攻略相关的数据库操作对象
 * @author 学徒
 *
 */
public interface Essay
{
	/**
	 * 根据查找条件，获取其相应的分页的数目
	 * @param condition 分页的查找条件
	 * @return 可分页的数目
	 */
	public abstract int getPageNumber(SearchEassyCondition condition);
	
	/**
	 * 根据相应的参数，返回其相应的文章内容信息列表
	 * @param condition 文章的搜索情况
	 * @return 文章内容信息的列表
	 */
	public abstract List<ManagerEssay> getEssayContentList(SearchEassyCondition condition);
	
	/**
	 * 通过文章的ID获取其对应的文章内容
	 * @param essayID 文章的ID
	 * @return 文章的详细内容
	 */
	public abstract EssayDetails getEssayDetailsByEssayID(int essayID);
	
	/**
	 * 用于删除文章所对应的数据库记录
	 * @param input 文章的输入对象
	 * @return 删除的结果
	 */
	public abstract boolean deleteEssayByUser(EssayDeleteInput input);
	
	/**
	 * 用于删除其文章所对应的评论的数据库记录
	 * @param input 文章的评论的输入对象
	 * @return 删除的结果
	 */
	public abstract boolean deleteEssayCommentByUser(EssayDeleteInput input);
	
	/**
	 * 用于可进行的分页的数目
	 * @param input 用户的输入相关参数
	 * @return 分页的数目
	 */
	public abstract int getPageNumbers(SearchEssayByUser input);
	
	/**
	 * 用于获取用户所发布的对应的攻略
	 * @param input 用户输入的相关参数
	 * @return 对应的获取的结果
	 */
	public abstract List<UserEssayResult> getUserEssayResult(SearchEssayByUser input);
	
	/**
	 * 用于用户更新文章的内容
	 * @param essay 内容更新的相关对象
	 * @return 更新的结果
	 */
	public abstract boolean userUpdateEssay(domain.essay.Essay essay);
}
