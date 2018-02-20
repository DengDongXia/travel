package utilImpl.email;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * 用于配置相关的MailSender类的相关数据
 * @author 学徒
 *
 */
public class EmailSender
{
	//spring中邮件发送的相关类对象
	private JavaMailSenderImpl mailSender;
	//用于发送邮件的邮件服务器主机名
	private String host;
	//用于发送邮件的邮件的服务器端口
	private int port;
	//用于发送邮件的用户的用户名
	private String userName;
	//用于发送邮件的用户的口令
	private String password;
	public void setHost(String host)
	{
		this.host = host;
	}
	public void setPort(int port)
	{
		this.port = port;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public void setMailSender(JavaMailSenderImpl mailSender)
	{
		this.mailSender = mailSender;
	}
	/**
	 * 初始化邮件发送器的相关类，该方法在容器完成相应的属性注入之后进行初始化
	 */
	public void initMailSender()
	{
		mailSender.setHost(this.host);//指定用来发送Email的邮件服务器主机名
        mailSender.setPort(this.port);//默认端口，标准的SMTP端口
        mailSender.setUsername(this.userName);//用户名
        mailSender.setPassword(this.password);//密码
	}
	/**
	 * 根据输入，发送相关的邮件信息
	 * @param title 邮件的主题
	 * @param context 邮件的内容
	 * @param email 邮件的邮箱地址
	 * @return
	 */
	public boolean sendEmail(String title, String context, String email)
	{
		boolean result=true;
		SimpleMailMessage message = new SimpleMailMessage();//消息构造器
        message.setFrom(this.userName);//发件人
        message.setTo(email);//收件人
        message.setSubject(title);//主题
        message.setText(context);//正文
        try
        {
        	mailSender.send(message);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	result=false;
        }
        return result;
	}
}
