package utilImpl.essay;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Component;

import util.eassy.Essay;
import util.eassy.EssayOperator;

@Component
public class EssayOperatorImpl implements EssayOperator
{
	public boolean saveEassy(Essay essay)
	{
		boolean result=true;
		String path=essay.getPath()+File.separator+essay.getName()+essay.getSuffix();
		File file=new File(path);
		if(!file.exists())//文件不存在的时候，创建相应的目录
		{
			result=file.mkdirs();
		}
		try//将文件信息写到磁盘相应的位置中
		{
			OutputStream out=new FileOutputStream(file);
			out.write(essay.getContextByte());
			out.flush();
			out.close();
		}
		catch(Exception e)
		{
			result=false;
		}
		return result;
	}

	public boolean deleteEssay(Essay essay)
	{
		boolean result=true;
		String path=essay.getPath()+File.separator+essay.getName()+essay.getSuffix();
		File file=new File(path);
		if(file.exists())
		{
			result=file.delete();
		}
		return result;
	}

	public boolean updateEssay(Essay essay)
	{
		boolean result=true;
		this.deleteEssay(essay);
		result=this.saveEassy(essay);
		return result;
	}
}
