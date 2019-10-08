package com.uek.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.uek.dao.inter.IUserDao;
import com.uek.domain.User;
import com.uek.utils.DBUtil;

public class UserDaoImpl implements IUserDao{

	@Override
	public void add(User user) {
		
		Connection conn = null;
		Statement stat = null;
		
		try {
			conn = DBUtil.getConnection();
			stat = conn.createStatement();
			
			String sql = "insert into t_user(name,password,signature,header) values('"+user.getName()+"','"+user.getPassword()+"','"+user.getSignature()+"','"+user.getHeader()+"')";
					
			stat.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.freeConnection(stat, conn);
		}
	}

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
			e.printStackTrace();
		} finally {
			DBUtil.freeConnection(stat, conn);
		}
		
	}

	@Override
	public void update(User user) {
		
		
		Connection conn = null;
		Statement stat = null;
		
		try {
			conn = DBUtil.getConnection();
			stat = conn.createStatement();
			
			String sql = "update t_user set password='"+user.getPassword()+"',signature='"+user.getSignature()+"' , header='"+user.getHeader()+"' where id="+user.getId();
			
					
			stat.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.freeConnection(stat, conn);
		}
	}

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
			
			//根据id最多查到一条 所以用if就可以
			if(rs.next())
			{
				user = new User();
				user.setId(rs.getInt("id"));//rs就是查询回来的结果集中的一条记录
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setSignature(rs.getString("signature"));
				user.setHeader(rs.getString("header"));
			
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.freeConnection(rs,stat, conn);
		}
		
		return user;
	}

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
			
			//根据id最多查到一条 所以用if就可以
			if(rs.next())
			{
				User user = new User();
				user.setId(rs.getInt("id"));//rs就是查询回来的结果集中的一条记录
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setSignature(rs.getString("signature"));
				user.setHeader(rs.getString("header"));
			
				users.add(user);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.freeConnection(rs,stat, conn);
		}
		
		return users;
		
	}

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
			
			//根据id最多查到一条 所以用if就可以
			if(rs.next())
			{
				user = new User();
				user.setId(rs.getInt("id"));//rs就是查询回来的结果集中的一条记录
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setSignature(rs.getString("signature"));
				user.setHeader(rs.getString("header"));
			
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.freeConnection(rs,stat, conn);
		}
		
		return user;
	}

}
