package service;

import java.util.List;

import dto.answer.AddAnswer;
import dto.answer.ShowAnswerInput;
import dto.answer.ShowAnswerResult;

/**
 * 提问的相关回答的服务类
 * @author 学徒
 *
 */
public interface AnswerService
{
	/**
	 * 根据输入的参数，获取其对应的回答内容
	 * @param input 回答的参数对象
	 * @return 回答的结果
	 */
	public abstract List<ShowAnswerResult> getAnswerListByInput(ShowAnswerInput input);
	
	/**
	 * 根据用户的输入，添加其相应的问题的回答
	 * @param input 回答的输入对象
	 * @return 添加的结果
	 */
	public abstract boolean addAnswerByInput(AddAnswer input);


}
