package serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.UserUpdateService;
import dao.user.Users;
import dto.user.UpdateUserMessageInput;
@Service
public class UserUpdateServiceImpl implements UserUpdateService
{
	@Autowired
	private Users updateUser;//用于更新其用户相关的信息的数据库操作对象
	
	public boolean updateUserMessage(UpdateUserMessageInput input)
	{
		return updateUser.updateUserMessage(input)==1;
	}

}
