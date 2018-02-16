package util.email;
/**
 * 用于实现邮件发送的辅助的相关的接口类
 * @author 学徒
 *
 */
public interface EmailHelper
{
	/**
	 * 用于发送相关的内容到对应的邮箱中
	 * @param title 邮件的标题
	 * @param context 邮件的内容
	 * @param email 邮箱的地址
	 * @return 发送的结果
	 */
	public abstract boolean sendEmailToUser(String title,String context,String email);
}
