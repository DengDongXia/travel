package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;

import service.PictureSubmit;

@Controller
@RequestMapping("/picture")
public class PictureController
{
	@Autowired
	private PictureSubmit pictureSubmitService;//注入相关的图像保存的服务类
	
	@RequestMapping("submit")
	@ResponseBody
	public Map<String,String> savePicture(@RequestBody @RequestPart Part part)
	{
		Map<String,String> result= new HashMap<String,String>();
		result.put("pictureURL", pictureSubmitService.savePicture((pictureSubmitService.makePictureObjectByPart(part))));
		return result;
	}
	
}
