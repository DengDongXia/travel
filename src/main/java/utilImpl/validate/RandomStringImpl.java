package utilImpl.validate;

import java.util.Random;

import org.springframework.stereotype.Component;
import util.validate.RandomString;



/**
 * 该类用于根据需要生成随机化的文字并进行返回
 * @author 学徒
 *
 */
@Component("randomString")
public class RandomStringImpl implements  RandomString
{
	private Random random=new Random();
	private final static String STRING_KEY="23456789ABCDEFGHJKMNPQRSTUVWXYZabcdefghjkmnpqrstuvwxyz";
	public String randomString(int stringNumber)
	{
		StringBuilder result=new StringBuilder();
		for(int i=0;i<stringNumber;i++)
		{
			int index=random.nextInt(STRING_KEY.length());
			result.append(STRING_KEY.charAt(index));
		}
		return result.toString();
	}
}
