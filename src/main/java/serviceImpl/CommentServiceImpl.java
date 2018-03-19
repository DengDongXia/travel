package serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.CommentService;
import dao.comment.Comment;
import dto.comment.CommentComplain;
import dto.comment.SearchCommentListInput;
import dto.comment.UserCommentResult;
@Service
public class CommentServiceImpl implements CommentService
{
	@Autowired
	private Comment comments;//评论相关的数据库操作类
	
	public Map<String, Boolean> userComplain(CommentComplain input)
	{
		Map<String,Boolean> result=new HashMap<String,Boolean>();
		/*String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:SS").format(new Date());
		time=time.substring(0, time.length()-2);//用于省去末尾的毫秒的情况
		input.setTime(time);*/
		boolean commentResult=true;
		if(!comments.isExistComplain(input))
			commentResult=comments.userComplain(input);
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
		String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:SS").format(new Date());
		time=time.substring(0, time.length()-2);//用于省去末尾的毫秒的情况
		input.setTime(time);
		return comments.addEssayComment(input);
	}
	
}
