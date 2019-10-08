package com.uek.service.inter;

import java.util.List;

import com.uek.domain.Friend;
import com.uek.domain.User;

public interface IUserService {
	User load(int id);
	void register(User user);
	User login(String name,String password);
	List<User> friendList(User user);
	List<User> seachFriendList(String name);
	void addFriend(Friend friend);
}
