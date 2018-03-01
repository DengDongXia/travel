package serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.QuestionService;
import dao.question.Questions;
import domain.question.Question;
import dto.question.DeleteQuestionInput;
import dto.question.SearchQuestionListInput;
import dto.question.ShowQuestion;
import dto.question.ShowQuestionDetail;
import dto.question.UpdateQuestionInput;

@Service
public class QuestionServiceImpl implements QuestionService
{
	@Autowired 
	private Questions questions;//注入提问相关的数据库操作类对象
	
	public boolean addQuestion(Question input)
	{
		String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:SS").format(new Date());
		time=time.substring(0, time.length()-2);//用于省去末尾的毫秒的情况
		input.setTime(time);
		return questions.addQuestion(input);
	}

	public int getPageNumber(SearchQuestionListInput input)
	{
		return questions.getPageNumberByInput(input);
	}

	public List<ShowQuestion> getQuestionList(SearchQuestionListInput input)
	{
		return questions.getQuestionListByInput(input);
	}
	
	public boolean deleteQuestionAndQuestionAnswerByInput(DeleteQuestionInput input)
	{
		boolean result =questions.deleteQuestionByInput(input)&&questions.deleteQuestionAnswerByInput(input);
		return result;
	}
	
	public boolean updateQuestionByInput(UpdateQuestionInput input)
	{
		return questions.updateQuestion(input);
	}
	
	public ShowQuestionDetail getQuestionDetails(String questionID)
	{
		return questions.getQuestionDetailsByQuestionID(questionID);
	}
	
	
}
