package com.uek.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.uek.dao.inter.IUserDao;
import com.uek.domain.Friend;
import com.uek.domain.User;
import com.uek.utils.DBUtil;

public class UserDaoImpl implements IUserDao {
	//加好友
	@Override
	public void add(User user) {
		Connection conn = null;
		Statement stat = null;
		try {
			conn = DBUtil.getConnection();
			stat = conn.createStatement();
			String sql = "insert into t_user(name,password,signature,heared) values('" + user.getName() + "','"
					+ user.getPassWord() + "','" + user.getSignature() + "','" + user.getHeared() + "')";
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.freeConnection(stat, conn);
		}
	}
	//删好友
	@Override
	public void delete(int id) {
		Connection conn = null;
		Statement stat = null;
		try {
			conn = DBUtil.getConnection();
			stat = conn.createStatement();
			String sql = "delete from t_user where id="+id;
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.freeConnection(stat, conn);
		}
	}
	//修改
	@Override
	public void update(User user) {
		Connection conn = null;
		Statement stat = null;
		try {
			conn = DBUtil.getConnection();
			stat = conn.createStatement();
			String sql = "update t_user set password='"+user.getPassWord()+"',signature='"+user.getSignature()+"',heared='"+user.getHeared()+"'";
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.freeConnection(stat, conn);
		}
	}
	//单个查找
	@Override
	public User load(int id) {
		User user = null;
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			stat = conn.createStatement();
			String sql = "select * from t_user where id="+id;
			rs = stat.executeQuery(sql);
			while(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassWord(rs.getString("password"));
				user.setSignature(rs.getString("signature"));
				user.setHeared(rs.getString("heared"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.freeConnection(rs,stat, conn);
		}
		return user;
	}
	//全部查找
	@Override
	public List<User> list() {
		List<User> users = new ArrayList<User>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			stat = conn.createStatement();
			String sql = "select * from t_user";
			rs = stat.executeQuery(sql);
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassWord(rs.getString("password"));
				user.setSignature(rs.getString("signature"));
				user.setHeared(rs.getString("heared"));
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.freeConnection(rs,stat, conn);
		}
		return users;
	}
	//根据名字查找
	@Override
	public User loadByName(String name) {
		User user = null;
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			stat = conn.createStatement();
			String sql = "select * from t_user where name='"+name+"'";
			rs = stat.executeQuery(sql);
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassWord(rs.getString("password"));
				user.setSignature(rs.getString("signature"));
				user.setHeared(rs.getString("heared"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.freeConnection(rs,stat, conn);
		}
		return user;
	}
	//查找好友
	@Override
	public List<User> friendList(User user) {
		List<User> users = new ArrayList<>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			stat = conn.createStatement();
			String sql = "SELECT * FROM t_user WHERE id IN ( SELECT friend_id FROM t_friend WHERE self_id = ( SELECT id FROM t_user WHERE name = '"+ user.getName() + "' ))";
			rs = stat.executeQuery(sql);
			while(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassWord(rs.getString("password"));
				user.setSignature(rs.getString("signature"));
				user.setHeared(rs.getString("heared"));
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.freeConnection(rs,stat, conn);
		}
		return users;
	}
	//搜索好友
	@Override
	public List<User> seachFriendList(String name) {
		List<User> users = new ArrayList<>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			stat = conn.createStatement();
			String sql = "select * from t_user where name like '%" + name + "%'";
			rs = stat.executeQuery(sql);
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassWord(rs.getString("password"));
				user.setSignature(rs.getString("signature"));
				user.setHeared(rs.getString("heared"));
				users.add(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.freeConnection(rs,stat, conn);
		}
		return users;
	}
	@Override
	public void add(Friend friend) {
		Connection conn = null;
		Statement stat = null;
		try {
			conn = DBUtil.getConnection();
			stat = conn.createStatement();
			String sql = "insert into t_friend(self_id,friend_id) values('"+friend.getSelfId()+"','"+friend.getFriendId()+"')";
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.freeConnection(stat, conn);
		}
	}
	
}
