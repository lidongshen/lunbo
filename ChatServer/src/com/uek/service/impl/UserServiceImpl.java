package com.uek.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.uek.dao.impl.FriendDaoImpl;
import com.uek.dao.impl.UserDaoImpl;
import com.uek.dao.inter.IFriendDao;
import com.uek.dao.inter.IUserDao;
import com.uek.domain.Friend;
import com.uek.domain.User;
import com.uek.exception.ChatException;
import com.uek.service.inter.IUserService;
import com.uek.utils.DBUtil;

public class UserServiceImpl implements IUserService{
	private IUserDao userDao = new UserDaoImpl();
	private IFriendDao friendDao = new FriendDaoImpl();
	@Override
	public void register(User user) {
		User u = userDao.loadByName(user.getName());
		if(u == null) {
			userDao.add(user);
		}else {
			throw new ChatException("用户已经注册！");
		}
	}
	//登录
	@Override
	public User login(String name, String password) {
		User user = userDao.loadByName(name);
		if(user == null) {
			throw new ChatException("用户名不存在!");
		}
		if(!user.getPassWord().equals(password)) {
			throw new ChatException("密码不正确");
		}
		return user;
	}

	@Override
	public List<User> friendList(User user) {
		List<User> users = userDao.friendList(user);
		
		return users;
	}

	@Override
	public List<User> seachFriendList(String name) {
		List<User> users = userDao.seachFriendList(name);
		if(users.isEmpty()) {
			throw new ChatException("用户不存在");
		}
		return users;
	}
	@Override
	public void addFriend(Friend friend) {
		Friend friendLoad = friendDao.friendLoad(friend);
		
			userDao.add(friend);
			Friend friend2 = new Friend();
			friend2.setSelfId(friend.getFriendId());
			friend2.setFriendId(friend.getSelfId());
			userDao.add(friend2);
		
		
		
	}
	
	@Override
	public User load(int id) {
		User user = userDao.load(id);
		return user;
	}
	

}
