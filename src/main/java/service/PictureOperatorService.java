package service;

import javax.servlet.http.Part;

import util.picture.Picture;

/**
 * 该接口用于实现图像上传相关的操作
 * @author 学徒
 *
 */

public interface PictureOperatorService
{
	/**
	 * 用于保存用户文章评论的图像
	 * @param picture 图像类的对象
	 * @return 保存的结果
	 */
	public abstract boolean saveCommentPicture(Picture picture);
	
	/**
	 * 用于保存用户文章的图像
	 * @param picture 图像类的对象
	 * @return 保存的结果
	 */
	public abstract boolean saveEssayPicture(Picture picture);
	
	/**
	 * 用于保存用户的图像
	 * @param picture 图像类的对象
	 * @return 保存的结果
	 */
	public abstract boolean savePersonPicture(Picture picture);
	/**
	 * 用于删除图像
	 * @param picture 图像类的相关对象
	 * @return 删除的结果
	 */
	public abstract boolean deletePicture(Picture picture);
	/**
	 * 用于更新图像
	 * @param picture 图像类的相关对象
	 * @return 更新的结果
	 */
	public abstract boolean updatePicture(Picture picture);
	
	/**
	 * 根据用户输入的图像的数据，将其组装成一个Picture对象进行返回
	 * @param part 用户图像数据的接收对象
	 * @return 图像对象
	 */
	public abstract Picture makePictureByPart(Part part);
}
