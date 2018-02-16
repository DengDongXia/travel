package serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import service.EssayOperatorService;
import util.eassy.Essay;
import util.eassy.EssayOperator;

public class EssayOperatorServiceImpl implements EssayOperatorService
{
	@Autowired
	private EssayOperator essayOperator;
	//文章文件保存的相关路径
	private String direction;
	private String path;
	//用于注入和获取其相关的文件的路径
	public String getDirection()
	{
		return direction;
	}

	public void setDirection(String direction)
	{
		this.direction = direction;
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}
	//执行相关的文章文件的操作
	public boolean saveEssay(Essay essay)
	{
		return essayOperator.saveEassy(essay);
	}

	public boolean deleteEssay(Essay essay)
	{
		return essayOperator.deleteEssay(essay);
	}

	public boolean updateEssay(Essay essay)
	{
		return essayOperator.updateEssay(essay);
	}

}
