package service;

import util.eassy.Essay;

/**
 * 用于实现文章的删除和保存以及更改操作
 * @author 学徒
 *
 */
public interface EssayOperatorService
{
	//用于保存文章
	public abstract boolean saveEssay(Essay essay);
	//用于删除文章
	public abstract boolean deleteEssay(Essay essay);
	//用于更新文章
	public abstract boolean updateEssay(Essay essay);
}
