package dao.answer;

import java.util.List;

import dto.answer.AddAnswer;
import dto.answer.ShowAnswerInput;
import dto.answer.ShowAnswerResult;

/**
 * 回答相关的数据库操作接口
 * @author 学徒
 *
 */
public interface Answer
{
	/**
	 * 根据其输入的相关参数，获取其问题回答的列表
	 * @param input 输入的相关的参数的对象
	 * @return 问题回答的列表
	 */
	public abstract List<ShowAnswerResult> getAnswerListByInput(ShowAnswerInput input);
	
	/**
	 * 根据输入的内容，将其问题的回答添加到数据库中
	 * @param input 回答的输入
	 * @return 添加的结果
	 */
	public abstract boolean addAnswer(AddAnswer input);
	
	/**
	 * 用于获取其相应的分页数
	 * @param input 用户的输入对象
	 * @return 其相应的分页数
	 */
	int getAnswerListPageNumber(ShowAnswerInput input);
	
}
