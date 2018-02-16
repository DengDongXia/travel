package dao.question;

import java.util.List;

import domain.question.Question;
import dto.question.DeleteQuestionInput;
import dto.question.SearchQuestionListInput;
import dto.question.ShowQuestion;
import dto.question.ShowQuestionDetail;
import dto.question.UpdateQuestionInput;

/**
 * 提问相关的数据库操作类
 * @author 学徒
 *
 */
public interface Questions
{
	/**
	 * 用于根据用户的输入，在数据库中新增提问的记录
	 * @param input 用户的输入情况
	 * @return 新增的结果
	 */
	public abstract boolean addQuestion(Question input);
	
	/**
	 * 用于根据用户的输入，获取其可显示的页面的数目
	 * @param input 输入情况
	 * @return 可进行显示的页面的数目
	 */
	public abstract int getPageNumberByInput(SearchQuestionListInput input);

	
	/**
	 * 用于根据用户的输入情况，获取其对应的提问列表
	 * @param input 用户的输入
	 * @return 提问列表
	 */
	public abstract List<ShowQuestion> getQuestionListByInput(SearchQuestionListInput input);
	
	/**
	 * 根据用户的输入情况，删除相应的提问
	 * @param input 用户的输入情况
	 * @return 删除的结果
	 */
	public abstract boolean deleteQuestionByInput(DeleteQuestionInput input);
	
	/**
	 * 根据用户的输入情况，删除其问题所对应的回答
	 * @param input 用户的输入情况
	 * @return 其删除的结果
	 */
	public abstract boolean deleteQuestionAnswerByInput(DeleteQuestionInput input);
	
	/**
	 * 用于用户更新提问的数据库的操作
	 * @param input 提问的更新内容
	 * @return 更新的结果
	 */
	public abstract boolean updateQuestion(UpdateQuestionInput input);
	
	/**
	 * 通过提问的ID获取其对应提问的详细内容
	 * @param questionID 提问的ID
	 * @return 提问的详细内容
	 */
	public abstract ShowQuestionDetail getQuestionDetailsByQuestionID(String questionID);
	
}
