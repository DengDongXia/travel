package util.password;

import java.io.UnsupportedEncodingException;

/**
 * 
 * 该接口用于密码加密验证和编码解码的相关功能的定义
 * @author 学徒
 *密码加密的方式是加密算法(密码+时间戳)
 *生成的字符编码是Base64(加密后生成的消息摘要字节序列)
 */
public interface PasswordSecurity
{
	//用于生成相应的密码加上时间戳的消息摘要字符串
	public abstract byte[] digest(String password,String Timestamp) throws UnsupportedEncodingException;
	//用于采用base64的编码方式，生成相关的字符串序列
	public abstract String encodeByteArrays(byte[] digestByteArray);
	//用于将采用base64的编码方式生成的字符串序列解码为byte数组
	public abstract byte[] decodeBase64String(String digestString);
}