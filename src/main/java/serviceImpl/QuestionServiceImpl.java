package serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.QuestionService;
import dao.question.Questions;
import domain.question.Question;
import domain.user.User;
import dto.answer.QuestionAnswerInput;
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
	
	public boolean addQuestion(Question input,HttpSession session)
	{
		String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:SS").format(new Date());
		time=time.substring(0, time.length()-2);//用于省去末尾的毫秒的情况
		input.setTime(time);
		boolean result=questions.addQuestion(input);
		if(result)
			result=questions.decrementAccount(input);
		if(result)
		{
			User user=(User) session.getAttribute("user");
			user.setAccount(user.getAccount()-5);//此处用于修改其相应的用户的积分，当发表成功的时候，其进行减少5分处理
			session.setAttribute("user", user);
		}
		return result;
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
		questions.deleteQuestionAnswerByInput(input);
		boolean result =questions.deleteQuestionByInput(input);
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

	public boolean compareResult(int questionID, HttpSession session)
	{
		User user=(User)session.getAttribute("user");
		boolean result=user.getId()==questions.getQuestionPersonId(questionID);
		return result;
	}

	public boolean setAnswer(QuestionAnswerInput input)
	{
		boolean result=questions.setAnswer(input);
		if(result)
			result=questions.setAccount(input);
		return result;
	}
	
	
}
