package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import service.PictureSubmit;

@Controller
@RequestMapping("/picture")
public class PictureController
{
	@Autowired
	private PictureSubmit pictureSubmitService;//注入相关的图像保存的服务类
	
	@RequestMapping("submit")
	@ResponseBody
	public Map<String,Object> savePicture(@RequestParam("pic") MultipartFile part)
	{
		Map<String,Object> result= new HashMap<String,Object>();
		result.put("pictureURL", pictureSubmitService.savePicture((pictureSubmitService.makePictureObjectByPart(part))));
		result.put("saveResult", true);
		return result;
	}
	
}
