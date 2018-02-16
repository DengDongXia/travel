package util.validate;

/**
 * 该类用于封装验证码相关的参数对象
 * @author 学徒
 *
 */
public class ValidateCodeSizeObject
{
	// 图片宽的默认值
	private int width = 80;
	// 图片高的默认值
	private int height = 26;
	// 干扰线数量的默认值
	private int lineSize = 40;
	//字体大小的默认值
	private int fontSize=18;
	//字体的默认值
	private String fontName="Times New Roman";
	//验证码默认的数量
	private int fontNumber=4;
	public int getFontNumber()
	{
		return fontNumber;
	}
	public void setFontNumber(int fontNumber)
	{
		this.fontNumber = fontNumber;
	}
	//相应的get、set方法
	public int getWidth()
	{
		return width;
	}
	public void setWidth(int width)
	{
		this.width = width;
	}
	public int getHeight()
	{
		return height;
	}
	public void setHeight(int height)
	{
		this.height = height;
	}
	public int getLineSize()
	{
		return lineSize;
	}
	public void setLineSize(int lineSize)
	{
		this.lineSize = lineSize;
	}
	public int getFontSize()
	{
		return fontSize;
	}
	public void setFontSize(int fontSize)
	{
		this.fontSize = fontSize;
	}
	public String getFontName()
	{
		return fontName;
	}
	public void setFontName(String fontName)
	{
		this.fontName = fontName;
	}
}
