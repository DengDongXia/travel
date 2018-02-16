package controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.ValidateCodeGetAndCheck;

/**
 * 用于实现验证码方面相关的请求和处理
 * @author 学徒
 *
 */
@Controller
@RequestMapping("/login")
public class GetValidateCodeController
{
	//用于注入相关的服务类
	@Autowired
	private ValidateCodeGetAndCheck validate;
	/**
	 * 用于获取一个验证码存入session中并将验证码生成相关的图片发送到前端中
	 * @param response 前端的响应对象
	 * @param session 相关的存储验证码的session对象
	 */
	@RequestMapping("/identifyCode")
	public void getValidateCodeAndOupt(HttpServletResponse response,HttpSession session)
	{
		validate.getValidateCodeAndOutput(response, session);
	}
}