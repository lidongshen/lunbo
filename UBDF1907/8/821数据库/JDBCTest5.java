package com.uek;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *  因为statement接口的实现类对象存在着SQL注入的漏洞，所以在开发中更多的是
 *  使用PreparedStatement（预处理sql类）来代替statement
 */
public class JDBCTest5 {
	
	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
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
		    String sql = "select * from t_user where uname= ? and pwd= ?"; //？占位符
		    //String sql = "insert into t_user values(? , ? ,?)";

		    //6.创建一个预处理sql对象，对sql进行安全检查：
		    pstmt = conn.prepareStatement(sql);
		    pstmt.setString(1, "方慧"); // 1： 占位符的位置
		    pstmt.setInt(2, 333);
		    //执行sql操作：
		    rs = pstmt.executeQuery();
		    while(rs.next()) {
		    	int id = rs.getInt(1);
		    	String uname = rs.getString(2);
		    	int password = rs.getInt(3);
		    	
		    	System.out.println(id+","+uname+","+password);
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
		    	if (pstmt != null) {
		    		pstmt.close();
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
