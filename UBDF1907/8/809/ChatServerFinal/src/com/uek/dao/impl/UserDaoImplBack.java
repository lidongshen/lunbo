package com.uek.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.uek.dao.inter.IUserDao;
import com.uek.domain.User;

public class UserDaoImplBack implements IUserDao{

	@Override
	public void add(User user) {

		try {
			//1 加载驱动类 //2 用驱动管理器注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			//3 用驱动管理器去获取数据库连接 建立java程序和数据库的桥梁
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_chat?useUnicode=true&characterEncoding=utf-8", "root", "root");
			//4 用连接准备一个工具 小推车
			Statement stat = conn.createStatement();
			
		
			String sql = "insert into t_user(name,password,signature,header) values('"+user.getName()+"','"+user.getPassword()+"','"+user.getSignature()+"','"+user.getHeader()+"')";
				//6 工具执行sql 小推车把sql推到数据库执行
				
			stat.executeUpdate(sql);
			
			//7 关闭资源
			stat.close();
			conn.close();
			
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		try {
			//1 加载驱动类 //2 用驱动管理器注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			//3 用驱动管理器去获取数据库连接 建立java程序和数据库的桥梁
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_chat?useUnicode=true&characterEncoding=utf-8", "root", "root");
			//4 用连接准备一个工具 小推车
			Statement stat = conn.createStatement();
			
		
			String sql = "delete from t_user where id="+id;
				//6 工具执行sql 小推车把sql推到数据库执行
				
			stat.executeUpdate(sql);
			
			//7 关闭资源
			stat.close();
			conn.close();
			
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
		
		
	}

	@Override
	public void update(User user) {
		
		try {
			//1 加载驱动类 //2 用驱动管理器注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			//3 用驱动管理器去获取数据库连接 建立java程序和数据库的桥梁
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_chat?useUnicode=true&characterEncoding=utf-8", "root", "root");
			//4 用连接准备一个工具 小推车
			Statement stat = conn.createStatement();
			
		
			String sql = "update t_user set password='"+user.getPassword()+"',signature='"+user.getSignature()+"' , header='"+user.getHeader()+"' where id="+user.getId();
				//6 工具执行sql 小推车把sql推到数据库执行
				
			stat.executeUpdate(sql);
			
			//7 关闭资源
			stat.close();
			conn.close();
			
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
		
	}

	@Override
	public User load(int id) {
		User user = null;
		
		try {
			//1 加载驱动类 //2 用驱动管理器注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			//3 用驱动管理器去获取数据库连接 建立java程序和数据库的桥梁
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_chat?useUnicode=true&characterEncoding=utf-8", "root", "root");
			//4 用连接准备一个工具 小推车
			Statement stat = conn.createStatement();
			
		
			String sql = "select * from t_user where id="+id;
				//6 工具执行sql 小推车把sql推到数据库执行
				
			ResultSet rs = stat.executeQuery(sql);
			
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
			
			//7 关闭资源
			stat.close();
			conn.close();
			
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
	
		
		return user;
	}

	@Override
	public List<User> list() {
		
		//注意这里不是null 直接new出来 这样将来即使表中没有记录，返回的是一个size为0的集合
		//避免直接访问空指针
		List<User> users = new ArrayList<>();
		
		try {
			//1 加载驱动类 //2 用驱动管理器注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			//3 用驱动管理器去获取数据库连接 建立java程序和数据库的桥梁
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_chat?useUnicode=true&characterEncoding=utf-8", "root", "root");
			//4 用连接准备一个工具 小推车
			Statement stat = conn.createStatement();
			
		
			String sql = "select * from t_user";
				//6 工具执行sql 小推车把sql推到数据库执行
				
			ResultSet rs = stat.executeQuery(sql);
			
			//根据id最多查到一条 所以用if就可以
			while(rs.next())
			{
				//查询的结果集中有一条记录 我就创建一个对象 将来把对象加入list集合
				User user = new User();
				user.setId(rs.getInt("id"));//rs就是查询回来的结果集中的一条记录
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setSignature(rs.getString("signature"));
				user.setHeader(rs.getString("header"));
			
				users.add(user);
				
			}
			
			//7 关闭资源
			stat.close();
			conn.close();
			
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
	
		
		return users;
	}

	@Override
	public User loadByName(String name) {
		User user = null;
		
		try {
			//1 加载驱动类 //2 用驱动管理器注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			//3 用驱动管理器去获取数据库连接 建立java程序和数据库的桥梁
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_chat?useUnicode=true&characterEncoding=utf-8", "root", "root");
			//4 用连接准备一个工具 小推车
			Statement stat = conn.createStatement();
			
		
			String sql = "select * from t_user where name='"+name+"'";
				//6 工具执行sql 小推车把sql推到数据库执行
				
			ResultSet rs = stat.executeQuery(sql);
			
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
			
			//7 关闭资源
			stat.close();
			conn.close();
			
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
	
		
		return user;
	}

}
