package serviceImpl;

import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.PictureSubmit;
import util.picture.Picture;

@Service
public class PictureSubmitImpl implements PictureSubmit
{
	@Autowired
	private util.picture.PictureSubmit pictureSubmitService;//注入相应的服务类对象
	
	public String savePicture(Picture picture)
	{
		return pictureSubmitService.savePicture(picture);
	}

	public Picture makePictureObjectByPart(Part part)
	{
		byte[] data=new byte[(int)part.getSize()];
		try
		{
			part.getInputStream().read(data);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		Picture picture = new Picture();
		picture.setData(data);
		picture.setName(pictureSubmitService.generateName(picture));
		String submitName=part.getSubmittedFileName();
		String suffix=(submitName.substring(submitName.lastIndexOf(".")));
		picture.setSuffix(suffix);
		return picture;
	}
	
}
