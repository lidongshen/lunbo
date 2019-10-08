package com.uek.test.TestJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestJDBC {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//testAdd();
		//testDelete();
		//testUpdate();
		
		testQuery();
	}

	private static void testAdd() throws ClassNotFoundException, SQLException {
		//1 加载数据库的驱动 就是mysql的jdbc的实现类
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/db_chat";
		String user = "root";
		String password = "root";
		
		//2 利用驱动管理器获取数据库的连接
		Connection conn = DriverManager.getConnection(url, user, password);
		
		//3 准备一个sql语句
		String sql = "insert into t_user(name,age) values('ww',30)";
		
		
		//4 利用创建好的连接去准备一个工具小推车
		Statement stat = conn.createStatement();
		
		
		//5  利用小推车 把sql推到对面的数据库去执行sql
		stat.executeUpdate(sql);
		
		//6 关闭打开的资源 先打开的后关闭
		stat.close();
		conn.close();
	}
	
	private static void testDelete() throws ClassNotFoundException, SQLException {
		//1 加载数据库的驱动 就是mysql的jdbc的实现类
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/db_chat";
		String user = "root";
		String password = "root";
		
		//2 利用驱动管理器获取数据库的连接
		Connection conn = DriverManager.getConnection(url, user, password);
		
		
		//3 准备一个sql语句
		String sql = "delete from t_user where id=2";
		
		
		//4 利用创建好的连接去准备一个工具小推车
		Statement stat = conn.createStatement();
		
		
		//5  利用小推车 把sql推到对面的数据库去执行sql
		stat.executeUpdate(sql);
		
		
		//6 关闭打开的资源 先打开的后关闭
		stat.close();
		conn.close();
	}
	
	private static void testUpdate() throws ClassNotFoundException, SQLException {
		//1 加载数据库的驱动 就是mysql的jdbc的实现类
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/db_chat";
		String user = "root";
		String password = "root";
		
		//2 利用驱动管理器获取数据库的连接
		Connection conn = DriverManager.getConnection(url, user, password);
		
		
		//3 准备一个sql语句
		String sql = "update t_user set age=100 where id=1";
		
		
		//4 利用创建好的连接去准备一个工具小推车
		Statement stat = conn.createStatement();
		
		
		//5  利用小推车 把sql推到对面的数据库去执行sql
		stat.executeUpdate(sql);
		
		
		//6 关闭打开的资源 先打开的后关闭
		stat.close();
		conn.close();
	}
	
	private static void testQuery() throws ClassNotFoundException, SQLException {
		//1 加载数据库的驱动 就是mysql的jdbc的实现类
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/db_chat";
		String user = "root";
		String password = "root";
		
		//2 利用驱动管理器获取数据库的连接
		Connection conn = DriverManager.getConnection(url, user, password);
		
		
		//3 准备一个sql语句
		String sql = "select * from t_user";
		
		
		//4 利用创建好的连接去准备一个工具小推车
		Statement stat = conn.createStatement();
		
		
		//5  利用小推车 把sql推到对面的数据库去执行sql
		ResultSet rs = stat.executeQuery(sql);
		
		while(rs.next())
		{
			System.out.println(rs.getString("name") + "\t" + rs.getInt("age"));
		}
		
		//6 关闭打开的资源 先打开的后关闭
		stat.close();
		conn.close();
	}
	
}
