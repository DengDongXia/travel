package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.ManagerService;
import service.SuperManagerService;
import dto.comment.CommentComplainSearchInput;
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
	public Map<String,Boolean> updateManagerMessage(@RequestBody UpdateManagerInput input,HttpSession session)
	{
		return superManagerService.updateManagerMessage(input,session);
	}
	
	
	@RequestMapping("/user/seacher")
	@ResponseBody
	public Map<String,Object> managerGetUser(@RequestBody Map<String,String> condition)
	{
		String conditionString=condition.get("condition");
		UserSearchResult user=managerService.getUserByCondition(conditionString);
		Map<String,Object> result=new HashMap<String,Object>();
		if(user!=null)
		{
			result.put("userID",user.getUserID());
			result.put("userName",user.getUserName());
			result.put("userStatus",user.isUserStatus());
			result.put("userAccount",user.getUserAccount());
			result.put("userPicture",user.getUserPicture());
			result.put("live",true);
		}
		else 
		{
			result.put("live", false);
		}
		return result;
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
	public Map<String,Object> getCommentByManager(@RequestBody CommentComplainSearchInput commentInput)
	{
		commentInput.setStart();//设置其相应的limit的语句的起始参数
		Map<String,Object> result=new HashMap<String,Object>();
		result.put("pageNumber",managerService.getComplainPageNumber(commentInput));
		result.put("content", managerService.getCommentByCommentID(commentInput));
		return result;
	}
	
	@RequestMapping("/comment/correct")
	@ResponseBody
	public Map<String,Boolean> saveCommentComplain(@RequestBody Map<String,Integer> id)
	{
		int commentID=id.get("commentID");
		Map<String,Boolean> result=new HashMap<String,Boolean>();
		result.put("commentDeleteResult",managerService.saveComplain(commentID));
		return result;
	}
	
	@RequestMapping("/comment/delete")
	@ResponseBody
	public Map<String,Boolean> deleteCommentByManager(@RequestBody Map<String,Integer> commentID)
	{
		Map<String,Boolean> result=new HashMap<String,Boolean>();
		int id=commentID.get("commentID");
		result.put("commentDeleteResult", managerService.deleteComment(id));
		return result;
	}
}
