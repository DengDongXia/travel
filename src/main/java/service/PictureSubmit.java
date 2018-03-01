package service;

import org.springframework.web.multipart.MultipartFile;

import util.picture.Picture;

/**
 * 用于图像上传的相关的接口
 * @author 学徒
 *
 */
public interface PictureSubmit
{
	/**
	 * 用于保存图片的相关数据
	 * @param picture 图像的封装对象
	 * @return 保存的图像的URL
	 */
	public abstract String savePicture(Picture picture);
	
	/**
	 * 用于将相应的part对象转化为图片描述的相关的数据对象
	 * @param part 输入对象
	 * @return 相应的图片数据封装对象
	 */
	public abstract Picture makePictureObjectByPart(MultipartFile part);
	
}
