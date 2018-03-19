package dto.comment;
/**
 * 用户举报评论的相关内容
 * @author 学徒
 *
 */
public class CommentComplain
{
	private int commentID;//评论的ID
	private boolean state;//管理员对该举报的管理情况
	public int getCommentID()
	{
		return commentID;
	}
	public void setCommentID(int commentID)
	{
		this.commentID = commentID;
	}
	public boolean isState()
	{
		return state;
	}
	public void setState(boolean state)
	{
		this.state = state;
	}
}
