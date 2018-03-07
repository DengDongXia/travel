package serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.AnswerService;
import dao.answer.Answer;
import dto.answer.AddAnswer;
import dto.answer.ShowAnswerInput;
import dto.answer.ShowAnswerResult;

@Service
public class AnswerServiceImpl implements AnswerService
{
	@Autowired
	private Answer answer; //注入回答相关的数据库操作类对象
	
	public List<ShowAnswerResult> getAnswerListByInput(ShowAnswerInput input)
	{
		return answer.getAnswerListByInput(input);
	}
	
	public boolean addAnswerByInput(AddAnswer input)
	{
		input.setTime(new Date());
		return answer.addAnswer(input);
	}

	public int getAnswerListPageNumber(ShowAnswerInput input)
	{
		return answer.getAnswerListPageNumber(input);
	}
}
