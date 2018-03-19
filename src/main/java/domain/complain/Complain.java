package domain.complain;
/**
 * 举报的相关的数据库对象
 * @author 学徒
 *
 */
public class Complain
{
	private int commentID;//评论的ID
	private boolean state;//管理员修改的评论的审核状态
	public Complain(){}
	public Complain(int commentID,boolean state)
	{
		this.commentID=commentID;
		this.state=state;
	}
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
