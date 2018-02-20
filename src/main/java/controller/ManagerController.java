package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;

import service.ManagerService;
import service.PictureOperatorService;
import service.SuperManagerService;
import util.picture.Picture;
import dto.comment.ManagerComment;
import dto.eassy.EssayUpdateInput;
import dto.eassy.SearchEassyCondition;
import dto.manager.UpdateManagerInput;
import dto.manager.UserSearchResult;
import dto.user.UserLoginInput;
import dto.user.UserLoginResult;

@Controller
@RequestMapping("/manager")
public class ManagerController
{
	@Autowired
	private ManagerService managerService;//管理员相关的服务类对象
	@Autowired
	private SuperManagerService superManagerService;//超级管理员相关的服务类对象
	@Autowired
	private PictureOperatorService pictureOperatorService;//图像相关的操作类对象
	
	@RequestMapping("/loginCheck")
	@ResponseBody
	public UserLoginResult managerLoginCheck(@RequestBody UserLoginInput input,HttpSession session)
	{
		return managerService.managerLoginCheck(input, session);
	}
	
	@RequestMapping("/status")
	@ResponseBody
	public Map<String,Boolean> updateManagerStatus(@RequestBody String managerID)
	{
		boolean updateResult=superManagerService.updateManagerStatus(managerID);
		Map<String,Boolean> result=new HashMap<String,Boolean>();
		result.put("managerStatus",updateResult);
		return result;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Map<String,Boolean> updateManagerMessage(@RequestBody UpdateManagerInput input)
	{
		return superManagerService.updateManagerMessage(input);
	}
	
	@RequestMapping("/picture/submit")
	@ResponseBody
	public Map<String,Object> updateManagerPicture(@RequestBody @RequestPart("picture")Part part,@RequestParam("managerID")String managerID)
	{
		Map<String,Object> result=new HashMap<String,Object>();
		Picture picture=pictureOperatorService.makePictureByPart(part);
		picture.setName(managerID);
		boolean saveResult=pictureOperatorService.savePersonPicture(picture);
		result.put("saveResult", saveResult);
		result.put("pictureURL", "/picture/"+picture.getName()+picture.getSuffix());
		return result;
	}
	
	@RequestMapping("/user/seacher")
	@ResponseBody
	public UserSearchResult managerGetUser(@RequestBody String condition)
	{
		return managerService.getUserByCondition(condition);
	}
	
	@RequestMapping("/user/update")
	@ResponseBody
	public Map<String,Boolean> managerUserUpdate(@RequestBody UserSearchResult updateResult)
	{
		return managerService.managerUpdateUser(updateResult);
	}
	
	@RequestMapping("/essay/search")
	@ResponseBody
	public Map<String,Object> getEassyByManager(@RequestBody SearchEassyCondition condition)
	{
		Map<String,Object> result=new HashMap<String,Object>();
		result.put("content",managerService.getEassyContent(condition));
		result.put("pageNumber",managerService.getEassyPageNumber(condition));
		return result;
	}
	
	@RequestMapping("/essay/update")
	@ResponseBody
	public Map<String,Boolean> updateEssayByManager(@RequestBody EssayUpdateInput essayUpdate)
	{
		Map<String,Boolean> result=new HashMap<String,Boolean>();
		result.put("essayUpdateResult",managerService.updateEssayByManager(essayUpdate));
		return result;
	}
	
	@RequestMapping("/comment/search")
	@ResponseBody
	public ManagerComment getCommentByManager(@RequestParam int commentID)
	{
		return managerService.getCommentByCommentID(commentID);
	}
	
	@RequestMapping("/comment/delete")
	@ResponseBody
	public Map<String,Boolean> deleteCommentByManager(@RequestParam int commentID)
	{
		Map<String,Boolean> result=new HashMap<String,Boolean>();
		result.put("commentDeleteResult", managerService.deleteComment(commentID));
		return result;
	}
}
