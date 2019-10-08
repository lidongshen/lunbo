package com.uek.junit;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.uek.dao.impl.UserDaoImpl;
import com.uek.dao.inter.IUserDao;
import com.uek.domain.Friend;
import com.uek.domain.User;
import com.uek.service.impl.UserServiceImpl;
import com.uek.service.inter.IUserService;

public class UserDaoImplTest {
	private IUserDao userDao;
	private IUserService userService;
	@Before
	public void init() {
		userDao = new UserDaoImpl();
		userService = new UserServiceImpl();
		
	}
	
	@Test
	public void testAdd(){
		Friend friend = new Friend(4,3);
		userService.addFriend(friend);
		
	}
	@Test
	public void testDelete() {
		userDao.delete(1);
	}
	@Test
	public void testUpdate() {
		User user = new User(18,"李四","111","我是李四","ls.jpg");
		userDao.update(user);
	}
	@Test
	public void testLoad() {
		User user = userDao.load(17);
		System.out.println(user);
	}
	@Test
	public void testList() {
		List<User> users = userDao.list();
		for (User user : users) {
			System.out.println(user);
		}
	}
	@After
	public void destory() {
		userDao = null;
		userService = null;
	}
}
