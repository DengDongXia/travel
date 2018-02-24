package util.picture;

import util.picture.Picture;

/**
 * 图像上传到服务器端并进行保存的相关的服务接口
 * @author 学徒
 *
 */
public interface PictureSubmit
{
	/**
	 *用于产生图片的唯一的名字 
	 * @pram picture 图像的相关的封装类对象
	 * @return 图片的名字
	 */
	public abstract String generateName(Picture picture);
	
	/**
	 * 用于在磁盘中存入相应的图片对象
	 * @param picture 图片的描述类
	 * @return 图像的URL
	 */
	public abstract String savePicture(Picture picture);

}
