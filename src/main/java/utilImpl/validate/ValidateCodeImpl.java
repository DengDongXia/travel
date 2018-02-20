package utilImpl.validate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Random;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

import util.validate.RandomString;
import util.validate.ValidateCode;
import util.validate.ValidateCodeSizeObject;

/**
 *用于实现验证码的相关的接口方法的实现
 * @author 学徒
 *
 */
@Component("validate")
public class ValidateCodeImpl implements ValidateCode
{
		//随机数的生成器
		private Random random = new Random();
		@Resource(name="validateCodeSizeObject")
		private ValidateCodeSizeObject object;
		@Resource(name="randomString")
		private RandomString randomString;
		
		/**
		 * 用于根据配置中的信息，获取相关的随机字符串
		 * 
		 */
		public String getRandomString()
		{
			return randomString.randomString(this.object.getFontNumber());
		}
		/**
		 * 用于根据输入的字符串的信息，生成一张二维码，并将其经过base64编码后输出到指定的输出端中
		 */
		public String outputValidateCode(String validateCodeString)
		{
			/*// 设置相应类型,告诉浏览器输出的内容为图片
			response.setContentType("image/jpeg");
			// 设置响应头信息，告诉浏览器不要缓存此内容
	        response.setHeader("Pragma", "No-cache");
	        response.setHeader("Cache-Control", "no-cache");
	        response.setDateHeader("Expire", 0);
			//获取相关信息用于生成验证码，同时将验证码输出到前端中
*/			byte[] data= getRandcode(validateCodeString);
			return Base64.encodeBase64String(data);
		}
		
		 /**
		  *  获得字体
		  */
		private Font getFont()
		{
			return new Font(this.object.getFontName(), Font.CENTER_BASELINE, this.object.getFontSize());
		}

		/*
		 * 获得颜色
		 */
		private Color getRandColor(int fc, int bc)
		{
			if (fc > 255)
				fc = 255;
			if (bc > 255)
				bc = 255;
			int r = fc + random.nextInt(bc - fc - 16);
			int g = fc + random.nextInt(bc - fc - 14);
			int b = fc + random.nextInt(bc - fc - 18);
			return new Color(r, g, b);
		}
		
		/**
		 * 绘制字符串，该方法每次只是绘制一个字符
		 */
		private void drowString(Graphics g, String validateCodeString,int i)
		{
			g.setFont(this.getFont());
			g.setColor(new Color(random.nextInt(101), random.nextInt(111), random.nextInt(121)));
			String rand = String.valueOf(validateCodeString.charAt(i));
			g.translate(random.nextInt(3), random.nextInt(3));
			g.drawString(rand, 13 * i, 16);
		}

		/**
		 * 用于绘制干扰线，该方法每次只绘制一条干扰线
		 */
		private void drowLine(Graphics g)
		{
			int x = random.nextInt(this.object.getWidth());
			int y = random.nextInt(this.object.getHeight());
			int xl = random.nextInt(13);
			int yl = random.nextInt(15);
			g.drawLine(x, y, x + xl, y + yl);
		}
		
		/**
		 * 生成随机图片，并将其输出到前端
		 */
		public byte[] getRandcode(String validateCodeString)
		{
			// BufferedImage类是具有缓冲区的Image类,Image类是用于描述图像信息的类
			BufferedImage image = new BufferedImage(this.object.getWidth(), this.object.getHeight(),BufferedImage.TYPE_INT_BGR);
			// 产生Image对象的Graphics对象,改对象可以在图像上进行各种绘制操作
			Graphics g = image.getGraphics();
			//绘制矩阵
			g.fillRect(0, 0, this.object.getWidth(),this.object.getHeight());
			//设置相应的文字
			g.setFont(new Font(this.object.getFontName(), Font.ROMAN_BASELINE, this.object.getFontSize()));
			//设置颜色
			g.setColor(getRandColor(110, 133));
			// 绘制干扰线
			for (int i = 0; i <= this.object.getLineSize(); i++)
			{
				drowLine(g);
			}
			for (int i = 0; i < validateCodeString.length(); i++)
			{
				drowString(g,validateCodeString,i);
			}
			g.dispose();
			ByteArrayOutputStream out=new ByteArrayOutputStream();
			try
			{
				// 将内存中的图片通过流动形式输出到客户端
				ImageIO.write(image, "JPEG", out);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			return out.toByteArray();
		}
}