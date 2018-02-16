package util.picture;

import java.io.IOException;
import java.io.InputStream;

/**
 * 图像类的相关描述
 * @author 学徒
 *
 */
public class Picture
{
	//图像的存储路径
	private String path;
	//图像的格式(扩展名)
	private String suffix;
	//图像的名字
	private String name;
	//图像的数据
	private byte[] data;
	public String getPath()
	{
		return path;
	}
	public void setPath(String path)
	{
		this.path = path;
	}
	public String getSuffix()
	{
		return suffix;
	}
	public void setSuffix(String suffix)
	{
		this.suffix = suffix;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public byte[] getData()
	{
		return data;
	}
	public void setData(byte[] data)
	{
		this.data = data;
	}
	/**
	 * 用于设置用户输入的数据到对应的字节数组中
	 * @param inputStream 输入流对象
	 * @param size 字节数组的大小
	 */
	public void setData(InputStream inputStream,int size)
	{
		data=new byte[size];
		try
		{
			inputStream.read(data);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
