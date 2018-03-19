package service;

import java.util.List;
import java.util.Map;

import domain.comment.Comment;
import dto.comment.CommentComplain;
import dto.comment.SearchCommentListInput;
import dto.comment.UserCommentResult;

/**
 * 用户的评论相关的服务类对象
 * @author 学徒
 *
 */
public interface CommentService
{
	/**
	 * 用户举报的相关内容
	 * @param input 用户举报的输入对象
	 * @return 举报的结果
	 */
	public abstract Map<String,Boolean> userComplain(CommentComplain input);
	
	/**
	 * 根据输入的条件，查找其文章相关的评论的分页数目
	 * @param input 输入的条件
	 * @return 分页的数目的结果
	 */
	public abstract int getCommentPageNumber(SearchCommentListInput input);
	
	/**
	 * 根据输入的条件，查找其相应的文章评论列表
	 * @param input 查找文章评论的条件
	 * @return 文章评论列表的情况
	 */
	public abstract List<UserCommentResult> getCommentListByCondition(SearchCommentListInput input);
	
	/**
	 * 新增文章的评论
	 * @param input 文章的评论输入对象
	 * @return 添加的结果
	 */
	public abstract boolean addEssayComment(Comment input);
	
}
