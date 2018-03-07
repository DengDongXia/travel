package utilImpl.picture;

import java.io.File;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

import util.picture.Picture;
import util.picture.PictureSubmit;
public class PictureSubmitImpl implements PictureSubmit
{
	private String saveLocation;//用于保存图像的位置
	private String pictureURLPrefix;//要进行返回的图像的URL的位置前缀
	public String getSaveLocation()
	{
		return saveLocation;
	}
	public void setSaveLocation(String saveLocation)
	{
		this.saveLocation = saveLocation;
	}
	public String getPictureURLPrefix()
	{
		return pictureURLPrefix;
	}
	public void setPictureURLPrefix(String pictureURLPrefix)
	{
		this.pictureURLPrefix = pictureURLPrefix;
	}
	/**
	 * 存储相应的图片到指定的位置，并返回其相应的URL
	 */
	public String savePicture(Picture picture)
	{
		File pictureFile=new File(this.saveLocation+picture.getName()+picture.getSuffix());
		try
		{
			FileOutputStream out=new FileOutputStream(pictureFile);
			out.write(picture.getData());
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		String pictureURL=this.pictureURLPrefix+picture.getName()+picture.getSuffix();
		return pictureURL;
	}
	/**
	 * 根据图像数据的相关信息，生成图像的名字
	 */
	public String generateName(Picture picture)
	{
		String randomString = String.valueOf(((int)(Math.random()*1000)));
		String hashString=null;
		/*hashString = Base64.encodeBase64String(((MessageDigest.getInstance("MD5").digest(picture.getData()))));
		hashString=hashString.substring(10);*/
		hashString=String.valueOf(System.currentTimeMillis());
		String result=hashString+randomString;
		return result;
	}
	
	
	
}
