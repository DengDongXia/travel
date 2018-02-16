package serviceImpl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import service.ValidateCodeGetAndCheck;
import util.validate.ValidateCode;

@Service
public class ValidateCodeGetAndCheckImpl implements ValidateCodeGetAndCheck
{
	//用于实现验证码方面的相关的类
	@Resource(name="validate")
	private ValidateCode validate;
	
	public boolean checkValidateCode(HttpSession session, String input)
	{
		String sessionValidate=(String)session.getAttribute("validate");
		return input.toUpperCase().equals(sessionValidate.toUpperCase());
	}

	public void getValidateCodeAndOutput(HttpServletResponse response,HttpSession session)
	{
		String validateCode=validate.getRandomString();
		System.out.println("验证码:"+validateCode);
		session.setAttribute("validate",validateCode);
		validate.outputValidateCode(response, validateCode);
	}

}
