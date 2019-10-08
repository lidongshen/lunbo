package com.uek.dao.inter;

import java.util.List;

import com.uek.domain.Friend;
import com.uek.domain.User;

public interface IUserDao {
	void add(User user);
	void delete(int id);
	void update(User user);
	User load(int id);
	List<User> list();
	User loadByName(String name);
	List<User> friendList(User user);
	List<User> seachFriendList(String name);
	void add(Friend friend);
	
}
