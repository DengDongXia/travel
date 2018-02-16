package utilImpl.password;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

import org.apache.commons.codec.binary.Base64;

import util.password.PasswordSecurity;


public class PasswordSecurityImpl implements PasswordSecurity
{
	private MessageDigest security;
	private String securityName;
	private String charset;
	//用于注入密码加密算法的名称，例如MD5
	public void setSecurityName(String securityName)
	{
		this.securityName=securityName;
	}
	//用于注入生成的密码报文的获取字节序列的编码方式
	public void setCharset(String charset)
	{
		this.charset=charset;
	}
	//该方法在启动完成,并注入了相关的security的值之后启动，完成相关的类的初始化
	public void initSecurity() throws Exception
	{
		security=MessageDigest.getInstance(this.securityName);
	}
	
	public byte[] digest(String password, String Timestamp) throws UnsupportedEncodingException
	{
		String value=Timestamp+password;
		byte[] result=security.digest(value.getBytes(this.charset));
		return result;
	}

	public String encodeByteArrays(byte[] digestByteArray)
	{
		return Base64.encodeBase64String(digestByteArray);
	}

	public byte[] decodeBase64String(String digestString)
	{
		return Base64.decodeBase64(digestString);
	}
}
