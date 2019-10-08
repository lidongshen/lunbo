package com.uek;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


/**
 * 以捕获异常的方式来实现创建一张数据库表 ： 用户表：id , 姓名，密码
 * 更新：
 * 删除：
 * 使用mysql和oracle数据库
 */
public class JDBCTest3 {
	
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		try {
			//1.通过读取配置文件，获取数据库连接信息;
			Properties pro = new Properties();
			pro.load(new FileInputStream("src/my.properties"));
			String driver = pro.getProperty("mysqlDriver");
		    String url = pro.getProperty("mysqlURL");
		    String name = pro.getProperty("mysqlUserName");
		    String pwd = pro.getProperty("mysqlPassWord");
		    
		    //2.导入指定数据库的驱动jar包；
		    
		    //3.使用反射的方式，加载数据库驱动：
		    Class.forName(driver);
		    
		    //4.使用驱动管理类创建程序与数据库连接
		    conn = DriverManager.getConnection(url, name, pwd);
		    
		    //5.指定操作：
		    String sql = "create table t_user(id int , uname varchar(20) , pwd int)";
		    
		    //6.创建发送指令器对象，执行sql, 并且返回执行的结果；
		    stmt = conn.createStatement();
		    //所有的增删改：executeUpdate
		    int state = stmt.executeUpdate(sql);
		    if (state > 0) {
				System.out.println("执行成功！");
			} else {
				System.out.println("执行失败！");
			}		    
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
		    //7.关闭资源;
		    try {
		    	if (stmt != null) {
		    		stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
