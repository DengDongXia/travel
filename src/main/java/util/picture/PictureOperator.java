package util.picture;
/**
 * 用于操作照片相关的接口
 * @author 学徒
 *
 */
public interface PictureOperator
{
	/**
	 * 用于保存相应的图像
	 * @param picture 图像类
	 * @return 保存的结果
	 */
	public abstract boolean savePicture(Picture picture);
	
	/**
	 * 用于删除相应的图像
	 * @param picture 图像类
	 * @return 删除的结果
	 */
	public abstract boolean deletePicture(Picture picture);
	
	/**
	 * 用于修改相应的图像
	 * @param picture 图像类
	 * @return 图像更新的结果
	 */
	public abstract boolean updatePicture(Picture picture);
}
