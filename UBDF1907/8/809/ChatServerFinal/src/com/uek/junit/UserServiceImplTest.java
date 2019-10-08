package com.uek.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.uek.domain.User;
import com.uek.service.impl.UserServiceImpl;
import com.uek.service.inter.IUserService;

public class UserServiceImplTest {
	
	private IUserService userService;
	
	@Before
	public void init()
	{
		userService = new UserServiceImpl();
	}
	
	@Test
	public void testRegister()
	{
		//测试必须覆盖所有的分支 一个都不能放过
		User user = new User("zss","111","zssqm","gsl.png");
		
		userService.register(user);
	}

	@Test
	public void testLogin()
	{
		
		User user = userService.login("zs","1134241");
		
		System.out.println(user);
	}
	
	@After
	public void destory()
	{
		userService = null;
	}
	
}
