package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用于页面跳转相关的控制器
 * @author 学徒
 *
 */
@Controller
public class PageRedirectController
{
	//用于跳转到相应的文章详细内容的页面
	@RequestMapping("/essay/details")
	public String showEssayDetails()
	{
		return "redirect:jsp/details";
	}
	
	//用于跳转到个人中心相应的页面
	@RequestMapping("/index/person")
	public String showPersonMessage()
	{
		return "redirect:jsp/personalMessage";
	}
	
	//用于跳转到特色定制的相关的页面
	@RequestMapping("/index/question")
	public String showSpecialQuestion()
	{
		return "redirect:jsp/specialQuestion";
	}
	
	@RequestMapping("/question/details")
	public String showQuestionDetails()
	{
		return "redirect:jsp/questionDetails";
	}
	
	//用于跳转到文章更新的相关的详细页面
	@RequestMapping("/question/update")
	public String updateQuestion()
	{
		return "redirecr:jsp/questionUpdate";
	}
	
	@RequestMapping("/essay/update")
	public String updateEssayByUser()
	{
		return "redirect:jsp/essayUpdate";
	}
	
	@RequestMapping("/user/index")
	public String redirectToUserIndex()
	{
		return "redirect:jsp/index";
	}
	
	@RequestMapping("/manager/index")
	public String redirectToManagerIndex()
	{
		return "redirect:jsp/manager/index";
	}
	
	@RequestMapping("/superManager/index")
	public String redirectToSuperManagerIndex()
	{
		return "redirect:jsp/superManager/index";
	}
}
