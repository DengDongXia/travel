package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.EssayService;
import service.QuestionService;
import dto.eassy.SearchEssayByUser;
import dto.question.SearchQuestionListInput;
import dto.question.ShowQuestion;

/**
 * 个人中心相关的控制器
 * @author 学徒
 *
 */
@RequestMapping("/person")
@Controller
public class PersonController
{
	@Autowired
	private QuestionService questionService;//用于注入提问相关的服务类
	private EssayService essayService;//用于注入攻略相关的服务类对象
	
	@RequestMapping("/question")
	@ResponseBody
	public Map<String,List<ShowQuestion>> getQuestionListByInput(SearchQuestionListInput input)
	{
		Map<String,List<ShowQuestion>> result =new HashMap<String,List<ShowQuestion>>();
		result.put("content", questionService.getQuestionList(input));
		return result;
	}
	
	@RequestMapping("/essay")
	@ResponseBody
	public Map<String,Object> showEssayByUser(@RequestBody SearchEssayByUser input)
	{
		Map<String,Object> result =new HashMap<String,Object>();
		input.setStart();
		result.put("content",essayService.getEssayContentList(input));
		result.put("pageNumber",essayService.getPageNumbers(input));
		return result;
	}
	
	
}
