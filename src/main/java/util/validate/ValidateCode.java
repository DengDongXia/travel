package util.validate;

import javax.servlet.http.HttpServletResponse;

/**
 * 该接口为用于生成验证码的方法的接口
 * @author 学徒
 *
 */
public interface ValidateCode
{
	/**
	 * 用于生成验证码，并将验证码发送到请求的前端
	 * @param response 用于发送到对方的响应对象
	 * @param validateCodeString 用于生成验证码的字符串的内容
	 */
	public abstract String outputValidateCode(String validateCodeString);
	/**
	 * 用于获取随机生成的二维码
	 * @return 二维码的字符串
	 */
	public abstract String getRandomString();
}