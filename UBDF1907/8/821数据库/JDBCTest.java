package com.uek;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * JDBC : java database connectivity  Java数据库连接
 *     
 * jdbc API :   封装在java.sql包下
 * 1）驱动管理类：DriverManager ,通过该类可以获取到程序与数据库的连接
 * 2）连接接口：Connection , 通过连接接口的对象，可以实现对数据库的增删改查操作，并且可以获取到执行的结果
 * 3）发送指令器接口：Statement ， 可以通过该接口对象，程序向数据库发送操作的指令（sql语句），然后返回结果
 * 4）结果集（集合）接口；ResultSet ,sql执行的结果会封装到一个结果集对象的集合当中。 
 */
public class JDBCTest {

	public static void main(String[] args) throws Exception {
		
		/**
		 * JDBC API操作步骤：
		 */
		//0、声明mysql数据库驱动相关信息
		String driver = "com.mysql.jdbc.Driver";
		//localhost ：本机IP = 127.0.0.1
		String url = "jdbc:mysql://localhost:3306/ubdf1907";
		String userName = "root";
		String passWord = "root";
		
		//1、准备要操作的数据库的驱动jar包：MySQL
		//注意：将jar包拷贝到当前项目下，还需求将jar包中的源码，导入到当前项目开发环境中；
		// build Path --> ADD 导入：
		
		//2、加载数据库的驱动：
		Class.forName(driver);
		
		//3、创建数据库连接
		Connection conn = DriverManager.getConnection(url, userName, passWord);
		
		//4、确定操作，编写sql语句
		String sql = "select * from t_emp";
		
		//5、获取发送指令器的对象，然后执行sql操作,并返回结果集
		Statement stmt = conn.createStatement();
		ResultSet resultSet = stmt.executeQuery(sql);
		
		//6、处理结果集：
		while(resultSet.next()) {
			//获取查询结果：注意：数据库的下标从1开始
			//1) 使用下标来获取一行中各个属性值：
			/*int emp_id = resultSet.getInt(1);
			String emp_name = resultSet.getString(2);
			double salary = resultSet.getDouble(3);
			Date brithday = resultSet.getDate(4);*/
			
			//2 )使用属性名名称获取值;
			/*int emp_id = resultSet.getInt("emp_id");
			String emp_name = resultSet.getString("emp_name");
			double salary = resultSet.getDouble("emp_salary");
			Date brithday = resultSet.getDate("emp_brithday");*/
			
			Integer emp_id = (Integer) resultSet.getObject(1);
			String emp_name = (String) resultSet.getObject(2);
			Double salary = (Double) resultSet.getObject(3);
			Date brithday = (Date) resultSet.getObject(4);
			
			System.out.println(emp_id +","+emp_name+","+salary+","+brithday);
		}
		
		//7、释放资源：后开先关
		resultSet.close();
		stmt.close();
		conn.close();	
	}
}









