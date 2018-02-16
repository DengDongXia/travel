package serviceImpl;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;

import service.PictureOperatorService;
import util.picture.Picture;
import util.picture.PictureOperator;

/**
 * 用于实现图像上传的相关操作
 * @author 学徒
 *
 */
public class PictureOperatorServiceImpl implements PictureOperatorService
{
	@Autowired
	private PictureOperator pictureOperator;
	//图片存储路径的相关信息的注入
	private String direction;
	private String userPath;
	private String commentPath;
	private String essayPath;
	//用于注入和获取配置的相关信息
	public String getDirection()
	{
		return direction;
	}
	public void setDirection(String direction)
	{
		this.direction = direction;
	}

	public String getUserPath()
	{
		return userPath;
	}

	public void setUserPath(String userPath)
	{
		this.userPath = userPath;
	}

	public String getCommentPath()
	{
		return commentPath;
	}

	public void setCommentPath(String commentPath)
	{
		this.commentPath = commentPath;
	}

	public String getEssayPath()
	{
		return essayPath;
	}

	public void setEssayPath(String essayPath)
	{
		this.essayPath = essayPath;
	}
	/**
	 * 用于图像的相关操作
	 * @param picture 图像类的相关对象
	 * @return 图像保存的结果
	 */
	private boolean savePicture(Picture picture)
	{
		return pictureOperator.savePicture(picture);
	}

	public boolean deletePicture(Picture picture)
	{
		return pictureOperator.deletePicture(picture);
	}

	public boolean updatePicture(Picture picture)
	{
		return pictureOperator.updatePicture(picture);
	}
	
	/**
	 * 用于将用户的图像的输入对象转化为相应的
	 * @param part 
	 * @return 用户的照片的描述对象
	 * 
	 */
	public Picture makePictureByPart(Part part)
	{
		Picture picture=new Picture();
		try
		{
			picture.setData(part.getInputStream(),(int)part.getSize());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		String fileSuffix=part.getHeader("content-disposition");//用于获取文件的扩展名
		fileSuffix=fileSuffix.substring(fileSuffix.lastIndexOf("."));
		picture.setSuffix(fileSuffix);
		return picture;
	}
	
	public boolean saveCommentPicture(Picture picture)
	{
		String path=this.direction+File.separator+this.commentPath;
		picture.setPath(path);
		return this.savePicture(picture);
	}
	
	public boolean saveEssayPicture(Picture picture)
	{
		String path=this.direction+File.separator+this.essayPath;
		picture.setPath(path);
		return this.savePicture(picture);
	}
	
	public boolean savePersonPicture(Picture picture)
	{
		String path=this.direction+File.separator+this.userPath;
		picture.setPath(path);
		return this.savePicture(picture);
	}

}
