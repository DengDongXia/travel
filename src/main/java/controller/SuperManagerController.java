package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.SuperManagerService;
import dto.manager.AddManagerInput;
import dto.manager.AddManagerResult;
import dto.manager.ManagerShow;
import dto.user.UserLoginInput;
import dto.user.UserLoginResult;

@Controller
@RequestMapping("/manager/superManager")
public class SuperManagerController
{
	@Autowired
	private SuperManagerService superManagerService;
	
	@RequestMapping("/loginCheck")
	@ResponseBody
	public UserLoginResult superManagerLoginCheck(@RequestBody UserLoginInput input,HttpSession session)
	{
		return superManagerService.superManagerLoginCheck(input,session);
	}
	
	@RequestMapping("/addManager")
	@ResponseBody
	public AddManagerResult superManagerAddManager(@RequestBody AddManagerInput input)
	{
		return superManagerService.addManager(input);
	}
	
	@RequestMapping("/show")
	@ResponseBody
	public Map<String,Object> showManagers(@RequestBody ManagerShow limit)
	{
		//用于更新获取到的相关数据，将其转化成为数据库中limit语句的参数的值
		limit.changeLimitData();
		return superManagerService.getAllManager(limit);
	}
	
	@RequestMapping("/deleteManager")
	@ResponseBody
	public Map<String,Boolean> deleteManager(@RequestBody Map<String,Integer> id)
	{
		Map<String,Boolean> result=new HashMap<String,Boolean>();
		result.put("deleteResult", superManagerService.deleteManager(id.get("managerId")));
		return result;
	}
	
	
}
