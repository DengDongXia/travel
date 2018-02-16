package utilImpl.picture;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Component;

import util.picture.Picture;
import util.picture.PictureOperator;

@Component
public class PictureOperatorImpl implements PictureOperator
{

	public boolean savePicture(Picture picture)
	{
		boolean result=true;
		File file=new File(picture.getPath()+File.separator+picture.getName()+picture.getSuffix());
		if(!file.exists())//文件不存在时，创建相应的目录
		{
			result=file.mkdirs();
		}
		try//将文件信息写入磁盘相应的位置中
		{
			OutputStream out=new FileOutputStream(file);
			out.write(picture.getData());
			out.flush();
			out.close();
		}
		catch(Exception e)
		{
			result=false;
		}
		return result;
	}

	public boolean deletePicture(Picture picture)
	{
		boolean result=true;
		File file=new File(picture.getPath()+File.separator+picture.getName()+picture.getSuffix());
		if(file.exists())//文件存在时，将其进行删除
		{
			result=file.delete();
		}
		return result;
	}

	public boolean updatePicture(Picture picture)
	{
		boolean result=true;
		this.deletePicture(picture);
		result=this.savePicture(picture);
		return result;
	}

}
