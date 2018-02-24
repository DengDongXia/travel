package service;

import dto.user.UpdateUserMessageInput;

/**
 * 用于更新用户的相关信息的服务类对象
 * @author 学徒
 *
 */
public interface UserUpdateService
{
	/**
	 * 更新其用户相关的信息
	 * @param input 用户相关信息的输入对象
	 * @return 更新的结果
	 */
	public abstract boolean updateUserMessage(UpdateUserMessageInput input);
}
