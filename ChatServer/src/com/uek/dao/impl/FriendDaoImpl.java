package com.uek.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.uek.dao.inter.IFriendDao;
import com.uek.domain.Friend;
import com.uek.domain.User;
import com.uek.utils.DBUtil;

public class FriendDaoImpl implements IFriendDao{

	@Override
	public Friend friendLoad(Friend friend) {
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			stat = conn.createStatement();
			String sql = "select * from t_friend where self_id ='" + friend.getSelfId() + "' and friend_id = '" + friend.getFriendId()+"'" ;
			rs = stat.executeQuery(sql);
			if(rs.next()) {
				friend = new Friend();
				friend.setId(rs.getInt("id"));
				friend.setSelfId(rs.getInt("self_id"));
				friend.setFriendId(rs.getInt("friend_id"));
				
			}else {
				friend= null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.freeConnection(rs,stat, conn);
		}
		return friend;
		
	}

}
