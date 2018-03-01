package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.QuestionService;
import domain.question.Question;
import dto.question.DeleteQuestionInput;
import dto.question.SearchQuestionListInput;
import dto.question.ShowQuestionDetail;
import dto.question.UpdateQuestionInput;

/**
 * 提问(即特色定制)相关的控制器类
 * @author 学徒
 *
 */
@Controller
@RequestMapping("/question")
public class QuestionController
{
	@Autowired
	private QuestionService questionService;//注入服务相关的服务类对象
	
	@RequestMapping("/add")
	@ResponseBody
	public Map<String,Boolean> addQuestion(@RequestBody Question input)
	{
		boolean addResult=questionService.addQuestion(input);
		Map<String,Boolean> result=new HashMap<String,Boolean>();
		result.put("questionAddResult", addResult);
		return result;
	}
	
	@RequestMapping("/show")
	@ResponseBody
	public Map<String,Object> showQuestionList(@RequestBody SearchQuestionListInput input)
	{
		Map<String,Object> result=new HashMap<String,Object>();
		result.put("pageNumber",questionService.getPageNumber(input));
		input.setStart();
		result.put("content",questionService.getQuestionList(input));
		return result;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String,Boolean> userDeleteQuestion(@RequestBody DeleteQuestionInput input)
	{
		Map<String,Boolean> result=new HashMap<String,Boolean>();
		result.put("questionDeleteResult",!questionService.deleteQuestionAndQuestionAnswerByInput(input));
		return result;
	}
	
	@RequestMapping("/updateSave")
	@ResponseBody
	public Map<String,Boolean> updateQuestion(@RequestBody UpdateQuestionInput input)
	{
		Map<String,Boolean> result=new HashMap<String,Boolean>();
		result.put("questionUpdateSaveResult",questionService.updateQuestionByInput(input));
		return result;
	}
	
	//用于提问的详细内容的请求
	@RequestMapping("/getDetail")
	@ResponseBody
	public Map<String,Object> showQuestionDetails(@RequestBody Map<String,String> questionID)
	{
		String id=questionID.get("questionID");
		ShowQuestionDetail detail=questionService.getQuestionDetails(id);
		Map<String,Object> result=new HashMap<String,Object>();
		result.put("questionHeader", detail.getQuestionHeader());
		result.put("questionStatus", detail.isQuestionStatus());
		result.put("questionContent", detail.getQuestionContent());
		result.put("questionPersonName", detail.getQuestionPersonName());
		result.put("questionPersonPicture", detail.getQuestionPersonPicture());
		result.put("questionTime", detail.getQuestionTime());
		result.put("questionAnswerCount", detail.getQuestionAnswerCount());
		result.put("questionID", detail.getQuestionID());
		result.put("questionAnswerPersonURL",detail.getQuestionAnswerPersonURL());
		result.put("questionAnswerPersonName",detail.getQuestionAnswerPersonName());
		result.put("questionAnswerContent", detail.getQuestionAnswerContent());
		result.put("questionAnswerTime", detail.getQuestionAnswerTime());
		return result;
	}
	
	
	
	
}
