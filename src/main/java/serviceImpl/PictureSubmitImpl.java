package serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

	public Picture makePictureObjectByPart(MultipartFile part)
	{
		byte[] data=new byte[0];
		try
		{
			data=part.getBytes();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		Picture picture = new Picture();
		picture.setData(data);
		picture.setName(pictureSubmitService.generateName(picture));
		String submitName=part.getOriginalFilename();
		String suffix=(submitName.substring(submitName.lastIndexOf(".")));
		picture.setSuffix(suffix);
		return picture;
	}
	
}
