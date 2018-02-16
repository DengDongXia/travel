package dto.comment;

import java.util.Date;

/**
 * 用户获取文章的评论列表的对象
 * @author 学徒
 *
 */
public class UserCommentResult
{
	private int commentID;//评论的ID
	private String commentContext;//评论的内容
	private Date commentDate;//评论的时间
	private String commentPersonPicture;//评论的用户的头像
	private String commentPersonName;//评论的用户的昵称
	public int getCommentID()
	{
		return commentID;
	}
	public void setCommentID(int commentID)
	{
		this.commentID = commentID;
	}
	public String getCommentContext()
	{
		return commentContext;
	}
	public void setCommentContext(String commentContext)
	{
		this.commentContext = commentContext;
	}
	public Date getCommentDate()
	{
		return commentDate;
	}
	public void setCommentDate(Date commentDate)
	{
		this.commentDate = commentDate;
	}
	public String getCommentPersonPicture()
	{
		return commentPersonPicture;
	}
	public void setCommentPersonPicture(String commentPersonPicture)
	{
		this.commentPersonPicture = commentPersonPicture;
	}
	public String getCommentPersonName()
	{
		return commentPersonName;
	}
	public void setCommentPersonName(String commentPersonName)
	{
		this.commentPersonName = commentPersonName;
	}
}
