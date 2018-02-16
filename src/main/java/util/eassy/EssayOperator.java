package util.eassy;
/**
 * 用于封装文章(攻略)的相关操作
 * @author 学徒
 *
 */
public interface EssayOperator
{
	/**
	 * 用于存储文章
	 * @param essay 文章的抽象描述
	 * @return 返回文章保存的结果
	 */
	public abstract boolean saveEassy(Essay essay);
	
	/**
	 * 用于删除文章
	 * @param essay 文章的抽象描述
	 * @return 返回文章的删除结果
	 */
	public abstract boolean deleteEssay(Essay essay);
	
	/**
	 * 用于更新文章
	 * @param essay 文章的抽象描述
	 * @return 返回文章的更新结果
	 */
	public abstract boolean updateEssay(Essay essay);
	
}
