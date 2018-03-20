package service;

import java.util.List;

import javax.servlet.http.HttpSession;

import domain.question.Question;
import dto.answer.QuestionAnswerInput;
import dto.question.DeleteQuestionInput;
import dto.question.SearchQuestionListInput;
import dto.question.ShowQuestion;
import dto.question.ShowQuestionDetail;
import dto.question.UpdateQuestionInput;

/**
 * 提问(特色定制)相关的操作的接口
 * @author 学徒
 *
 */
public interface QuestionService
{
	/**
	 * 用于新增用户的提问
	 * @param input 用户的提问对象
	 * @return 提问的结果
	 */
	public abstract boolean addQuestion(Question input,HttpSession session);
	
	/**
	 * 根据用户的输入的参数，获取其对应的分页的数目
	 * @param input 输入的参数
	 * @return 可进行分页的数目
	 */
	public abstract int getPageNumber(SearchQuestionListInput input);
	
	/**
	 * 根据用户的输入，用于获取其对应的显示的列表
	 * @param input 用户的输入参数
	 * @return 对应的提问的显示列表
	 */
	public abstract List<ShowQuestion> getQuestionList(SearchQuestionListInput input);
	
	
	/**
	 * 用户删除相应的文章以及其对应的问题的回答
	 * @param input 用户的输入对象
	 * @return 删除的结果
	 */
	public abstract boolean deleteQuestionAndQuestionAnswerByInput(DeleteQuestionInput input);
	
	
	/**
	 * 用于用户更新相应的提问内容
	 * @param input 用户的输入
	 * @return 更新的结果
	 */
	public abstract boolean updateQuestionByInput(UpdateQuestionInput input);
	
	/**
	 * 用于得到其对应的提问的详细内容
	 * @param questionID 提问的ID
	 * @return 提问的详细内容
	 */
	public abstract ShowQuestionDetail getQuestionDetails(String questionID);
	
	/**
	 * 用于比较用户的相关的ID和文章发布人的ID的情况
	 * @param questionID 文章的ID
	 * @param session 当前用户的session对象
	 * @return 其比较的结果
	 */
	boolean compareResult(int questionID,HttpSession session);
	
	/**
	 * 用于设置其相关的问题的采纳的答案
	 * @param input 采纳的输入对象
	 * @return 其相应的结果
	 */
	boolean setAnswer(QuestionAnswerInput input);
}
