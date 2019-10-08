package com.uek.junit;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.uek.dao.impl.UserDaoImpl;
import com.uek.dao.inter.IUserDao;
import com.uek.domain.User;

/**
 * 关于junit
 * 	1 知道它是做什么的
 *  2 会引入junit 
 *  3 掌握几个标注 @Test @Before @After 
 *  4 注意如何测单个方法，测所有方法
 *  
 * @author UEK-N
 *
 */
public class UserDaoImplTest {
	
	private IUserDao userDao;
	
	@Before
	public void init()
	{
		userDao = new UserDaoImpl();
	}
	
	// junit是java中最著名的做单元测试的工具
	@Test
	public void testAdd() {

		// 没有id的构造器 插入不需要设置id id自动自增
		User user = new User("zs", "zs", "zsqm", "gsl.png");

		userDao.add(user);
	}

	@Test
	public void testDelete() {

		userDao.delete(100);
	}

	@Test
	public void testUpdate() {

		//更新时候用带id的构造器 因为dao根据id更新别的字段
		User user = new User(18 , "zs", "222", "zsqm", "gsl.png");

		userDao.update(user);
	}

	@Test
	public void testLoad() {

		User user = userDao.load(18);
		
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
	public void destroy()
	{
		userDao = null;
	}

}
