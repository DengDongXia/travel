package serviceImpl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.EssayService;
import dao.essay.Essay;
import dto.eassy.EssayDeleteInput;
import dto.eassy.EssayDetails;
import dto.eassy.ManagerEssay;
import dto.eassy.SearchEassyCondition;
import dto.eassy.SearchEssayByUser;
import dto.eassy.UserEssayResult;
/**
 * 服务相关的接口的实现类
 * @author 学徒
 *
 */
@Service
public class EssayServiceImpl implements EssayService
{
	@Autowired
	private Essay essays;
	
	public int getPageNumber(SearchEassyCondition condition)
	{
		return essays.getPageNumber(condition); 
	}

	public List<ManagerEssay> getEssayContentList(SearchEassyCondition condition)
	{
		List<ManagerEssay> result=essays.getEssayContentList(condition);
		return result;
	}
	
	public EssayDetails getEssayDetailsByEssayID(int essayID)
	{
		return essays.getEssayDetailsByEssayID(essayID);
	}
	
	public boolean deleteEssayCommentByUser(EssayDeleteInput input)
	{
		return essays.deleteEssayCommentByUser(input);
	}
	
	public boolean deleteEssayByUser(EssayDeleteInput input)
	{
		return essays.deleteEssayByUser(input);
	}
	
	public int getPageNumbers(SearchEssayByUser input)
	{
		return essays.getPageNumbers(input);
	}
	
	public List<UserEssayResult> getEssayContentList(SearchEssayByUser input)
	{
		return essays.getUserEssayResult(input);
	}
	
	public boolean updateEssay(domain.essay.Essay essay)
	{
		return essays.userUpdateEssay(essay);
	}

	public boolean addEssay(domain.essay.Essay essay)
	{
		String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:SS").format(new Date());
		time=time.substring(0, time.length()-2);//用于省去末尾的毫秒的情况
		essay.setTime(time);
		return essays.addEssay(essay)==1;
	}
}
