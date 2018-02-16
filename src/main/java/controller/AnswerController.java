package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import service.AnswerService;
import service.PictureOperatorService;
import util.picture.Picture;
import dto.answer.AddAnswer;
import dto.answer.ShowAnswerInput;
import dto.answer.ShowAnswerResult;

/**
 * 提问的回答相关的控制器
 * @author 学徒
 *
 */
@RequestMapping("/answer")
@Controller
public class AnswerController
{
	@Autowired
	private AnswerService answerService;//注入相关的提问的回答的服务类
	private PictureOperatorService pictureOperatorService;//图像上传相关的服务类
	
	@RequestMapping("/show")
	@ResponseBody
	public List<ShowAnswerResult> getAnswerListByInput(@RequestBody ShowAnswerInput input)
	{
		input.setStart();
		return answerService.getAnswerListByInput(input);
	}
	
	@RequestMapping("/picture/submit")
	@ResponseBody
	public Map<String,Object> answerPictureSubmit(@RequestBody Part part,@RequestParam("userID") String userID,@RequestParam("questionID")String questionID)
	{
		Map<String,Object> result=new HashMap<String,Object>();
		Picture picture=pictureOperatorService.makePictureByPart(part);
		String pictureURL=userID+questionID+(int)(Math.random()*10000);
		picture.setName(pictureURL);
		result.put("pictureID",pictureURL);
		result.put("pictureSaveResult",pictureOperatorService.saveCommentPicture(picture));
		return result;
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public Map<String,Boolean> addQuestionAnswerByInput(@RequestBody AddAnswer input)
	{
		Map<String,Boolean> result=new HashMap<String,Boolean>();
		result.put("answerResult",answerService.addAnswerByInput(input));
		return result;
	}
	
}
