package controller;

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
		return superManagerService.getAllManager(limit);
	}
	
	
	
}
