package controller;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.UserLoginService;
import service.UserRegisterEmailValidate;
import service.UserRegisterService;
import domain.user.User;
import dto.user.UserLoginInput;
import dto.user.UserLoginResult;
import dto.user.UserRegisterInput;
import dto.user.UserRegisterResult;

/**
 * 用于处理用户相关的Controller
 * @author 学徒
 *
 */
@Controller
@RequestMapping("/user")
public class UserController
{
	@Autowired
	private UserRegisterEmailValidate userRegisterEmail;//用户注册的邮箱服务
	@Autowired
	private UserRegisterService userRegisterService;//用户注册的数据库相关服务
	@Autowired
	private UserLoginService userLoginService;//用户登录的数据库相关服务
	
	//用于验证用户的注册
	@RequestMapping("/register")
	@ResponseBody
	public UserRegisterResult userRegister(@RequestBody UserRegisterInput input,HttpSession session)
	{
		boolean validateCodeResult=userRegisterService.checkValidateCode(session, input);
		boolean repeatedPasswordResult=userRegisterService.checkPasswordRepeated(input);
		boolean existEmail=userRegisterService.existEmail(input);
		UserRegisterResult result=new UserRegisterResult(validateCodeResult,repeatedPasswordResult,existEmail);
		if(!existEmail&&repeatedPasswordResult&&validateCodeResult)
		{
			User user=userRegisterService.makeUser(input);
			userRegisterService.insertUser(user);
		}
		return result;
	}
	
	//用于获取邮箱验证码
	@RequestMapping("/emailIdentifyCode")
	@ResponseBody
	public Map<String,Boolean> getUserRegisterEmailValidate(@RequestBody String email,HttpSession session)
	{
		email=URLDecoder.decode(email);
		String validateCode=userRegisterEmail.getValidateCode(session);
		System.out.println(validateCode);
		boolean result=userRegisterEmail.sendValidateCodeToEmail(validateCode, email);
		Map<String,Boolean> map=new HashMap<String,Boolean>();
		map.put("getIdentifyCodeResult",result);
		return map;
	}
	
	//用于用户的登录
	@RequestMapping("/loginCheck")
	@ResponseBody
	public UserLoginResult userLogin(@RequestBody UserLoginInput input,HttpSession session)
	{
		return userLoginService.checkUserLogin(session, input);
	}
	
	@RequestMapping("/isLogin")
	@ResponseBody
	public Map<String,Object>  isLogin(HttpSession session)
	{
		Map<String,Object> result=new HashMap<String,Object>();
		User user=userLoginService.getLoginCheck(session);
		result.put("isLogin",user.getEmail()!=null);
		result.put("content", user);
		return result;
	}
	
}
