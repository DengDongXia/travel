package dao.comment;

import java.util.List;

import dto.comment.CommentComplain;
import dto.comment.SearchCommentListInput;
import dto.comment.UserCommentResult;


/**
 * 评论相关的数据库操作接口
 * @author 学徒
 *
 */
public interface Comment
{
	/**
	 * 用户举报评论相关的数据库操作
	 * @param input 用户举报某条评论的输入对象
	 * @return 执行的结果
	 */
	public abstract boolean userComplain(CommentComplain input);

	/**
	 * 用户相关文章的查找列表的分页数目
	 * @param input 分页的条件
	 * @return 分页的数目
	 */
	public abstract int getCommentPageNumber(SearchCommentListInput input);
	
	/**
	 * 根据用户的输入条件，获取其相应的评论列表
	 * @param input 输入条件
	 * @return 评论列表
	 */
	public abstract List<UserCommentResult> getCommentListByCondition(SearchCommentListInput input);
	
	/**
	 * 往数据库中新增一个攻略的评论
	 * @param input 新增的攻略的评论
	 * @return 新增的结果
	 */
	public abstract boolean addEssayComment(domain.comment.Comment input);
	
	/**
	 * 用于判断举报情况是否已经存在,并进行过相应的审核
	 * 避免管理员重复审核同一评论和数据库中插入同一举报内容的情况存在
	 * @Param 用户的举报的输入情况
	 */
	public abstract boolean isExistComplain(CommentComplain input);
	
	/**
	 * 用于用户增加相应的积分
	 * @param input 用户的输入情况
	 * @return 其相应的积分增加的结果
	 */
	boolean addEssayAccount(domain.comment.Comment input);
}
