package serviceImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.CommentService;
import dao.comment.Comment;
import dto.comment.SearchCommentListInput;
import dto.comment.UserCommentResult;
@Service
public class CommentServiceImpl implements CommentService
{
	@Autowired
	private Comment comments;//评论相关的数据库操作类
	
	public Map<String, Boolean> userComplain(domain.comment.Comment input)
	{
		Map<String,Boolean> result=new HashMap<String,Boolean>();
		input.setTime(new Date());
		boolean commentResult=comments.userComplain(input);
		result.put("complainResult",commentResult);
		return result;
	}

	public int getCommentPageNumber(SearchCommentListInput input)
	{
		return comments.getCommentPageNumber(input);
	}

	public List<UserCommentResult> getCommentListByCondition(SearchCommentListInput input)
	{
		return comments.getCommentListByCondition(input);
	}
	
	public boolean addEssayComment(domain.comment.Comment input)
	{
		input.setTime(new Date());
		return comments.addEssayComment(input);
	}
	
}
