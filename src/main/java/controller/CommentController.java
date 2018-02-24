package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;

import service.CommentService;
import service.PictureSubmit;
import util.picture.Picture;
import domain.comment.Comment;
import dto.comment.SearchCommentListInput;
/**
 * 用于评论相关的控制器
 * @author 学徒
 *
 */
@Controller
@RequestMapping("/comments")
public class CommentController
{
	@Autowired
	private CommentService commentService;//注入评论相关的服务类对象
	
	@RequestMapping("/complain")
	@ResponseBody
	public Map<String,Boolean> personComplainComment(@RequestBody Comment input)
	{
		return commentService.userComplain(input);
	}
	
	@RequestMapping("/essay")
	@ResponseBody
	public Map<String,Object> getCommentList(@RequestBody SearchCommentListInput input)
	{
		Map<String,Object> result =new HashMap<String,Object>();
		result.put("pageNumber",commentService.getCommentPageNumber(input));
		input.setStart();
		result.put("content",commentService.getCommentListByCondition(input));
		return result;
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public Map<String,Boolean> addEssayComment(@RequestBody Comment input)
	{
		Map<String,Boolean> result =new HashMap<String,Boolean>();
		result.put("commentsResult",commentService.addEssayComment(input));
		return result;
	}
	
}
