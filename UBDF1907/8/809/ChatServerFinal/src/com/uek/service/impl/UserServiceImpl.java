package com.uek.service.impl;

import com.uek.dao.impl.UserDaoImpl;
import com.uek.dao.inter.IUserDao;
import com.uek.domain.User;
import com.uek.exception.ChatException;
import com.uek.service.inter.IUserService;

/**
 * 业务逻辑层是面向用户的，dao层是面向数据库的
 * 
 * 业务逻辑层并不一定要访问数据库，需要考虑业务层面是否合理性，业务逻辑层的方法
 * 可能组合很多个dao的方法，完成一个业务逻辑 
 * 
 * 比如以注册register业务方法为例，会去调用dao的add方法放到数据库，但是布置这些，需要
 * 考虑
 * 	1 用户名是否已经被注册了？如果被注册过如何处理？ 
 *  2 可能注册成功之后会给客户发一封邮件，要求客户开通
 *  3 。。。 
 * 
 * @author UEK-N
 *
 */
public class UserServiceImpl implements IUserService{

	//业务逻辑层(上一层)调用dao层（下一层）的服务，下一层为上一层提供服务，就体现在
	//上一层持有下一层的引用，能够调用下一层的方法
	private IUserDao userDao = new UserDaoImpl();
	
	@Override
	public void register(User user) {
		
		User u = userDao.loadByName(user.getName());
		
		if(u == null)
		{
			userDao.add(user);
		}else
		{
			//听清楚 异常 throws try catch finally 
			//自定义异常和throw用的非常少 掌握这里就够了
			throw new ChatException("用户名已存在");
		}
		
	}

	@Override
	public User login(String username, String password) {
		
		User user = userDao.loadByName(username);
		
		if(user == null)
		{
			throw new ChatException("用户名不存在!");
		}
		
		//如果用户名存在 继续判断数据库的密码和用户界面输入的密码是否匹配
		if(!user.getPassword().equals(password))
		{
			throw new ChatException("密码不正确!");
		}
		
		return user;
	}
	
}
