package util.eassy;

import java.io.UnsupportedEncodingException;

/**
 * 文章类的相关描述
 * @author 学徒
 *
 */
public class Essay
{
	//文章的路径
	private String path;
	//文章的名字
	private String name;
	//文章的后缀
	private String suffix;
	//文章的内容
	private String context;
	public String getPath()
	{
		return path;
	}
	public void setPath(String path)
	{
		this.path = path;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getSuffix()
	{
		return suffix;
	}
	public void setSuffix(String suffix)
	{
		this.suffix = suffix;
	}
	public String getContext()
	{
		return context;
	}
	public void setContext(String context)
	{
		this.context = context;
	}
	
	public byte[] getContextByte()
	{
		byte[] result=new byte[0];
		try
		{
			result=this.context.getBytes("utf-8");
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	public String getContextString(byte[] context)
	{
		String result="";
		try
		{
			result= new String(context,"utf-8");
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
}
