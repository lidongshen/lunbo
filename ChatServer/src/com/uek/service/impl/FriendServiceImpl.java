package com.uek.service.impl;

import com.uek.dao.impl.FriendDaoImpl;
import com.uek.dao.inter.IFriendDao;
import com.uek.domain.Friend;
import com.uek.exception.ChatException;
import com.uek.service.inter.IFriendService;

public class FriendServiceImpl implements IFriendService{
	private IFriendDao friendDao = new FriendDaoImpl();
	@Override
	public void yesFriend(Friend friend) {
		Friend friendLoad = friendDao.friendLoad(friend);
		if(friendLoad != null) {
			throw new ChatException("已经是好友");
		}
	}
	
}
