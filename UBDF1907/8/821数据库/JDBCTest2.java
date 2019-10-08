package com.uek;
import java.io.FileInputStream;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * 程序 ---> Mysql
 * 程序 ---> Oracle
 *
 */
/**
 * 项目配置文件：将项目中，经常会使用到的变量或者是常量抽取出来，单独
 * 				存放到一个文件中，然后程序中当引用变量或者常量时，
 * 				直接读取该配置文件即可；
 * 
 * 场景;
 * int sum = 200;
 * 程序中 ，有100个地方使用了sum变量，此刻要求sum变量的值从100修改成200；
 * 
 * IO : properties类
 * 使用步骤：1）在项目的src（项目源码）下，创建一个后缀为.properties的文件
 * 			2)创建properties对象；加载配置文件中的数据
 */
public class JDBCTest2 {

	public static void main(String[] args) throws Exception {
		
		//0、声明mysql数据库驱动相关信息
/*		String mysqlDriver = "com.mysql.jdbc.Driver";
		//localhost ：本机IP = 127.0.0.1
		String mysqlURL = "jdbc:mysql://localhost:3306/ubdf1907";
		String mysqlUserName = "root";
		String mysqlPassWord = "root";
		
		String oarcleDriver = "oracle.jdbc.driver.OracleDriver";
		String oracleURL = "jdbc:oracle:thin:localhost:1521:orcl";
		String oracleUserName = "scott";
		String oraclePassWord = "123456";*/
		
		//构建对象;
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/my.properties"));
		
		//根据属性名获取属性值：
		String mysqlDriver  = prop.getProperty("mysqlDriver");
		String mysqlURL  = prop.getProperty("mysqlURL");
		String mysqlUserName = prop.getProperty("mysqlUserName");
		String mysqlPassWord = prop.getProperty("mysqlPassWord");
		
		//1、准备要操作的数据库的驱动jar包：MySQL
		//注意：将jar包拷贝到当前项目下，还需求将jar包中的源码，导入到当前项目开发环境中；
		// build Path --> ADD 导入：
		
		//2、加载数据库的驱动：
		Class.forName(mysqlDriver);
		
		//3、创建数据库连接
		Connection conn = DriverManager.getConnection(mysqlURL, mysqlUserName, mysqlPassWord);
		
		//4、确定操作，编写sql语句
		String sql = "select * from t_emp";
		
		//5、获取发送指令器的对象，然后执行sql操作,并返回结果集
		Statement stmt = conn.createStatement();
		ResultSet resultSet = stmt.executeQuery(sql);
		
		//6、处理结果集：
		while(resultSet.next()) {
			//获取查询结果：注意：数据库的下标从1开始
			//1) 使用下标来获取一行中各个属性值：
			int emp_id = resultSet.getInt(1);
			String emp_name = resultSet.getString(2);
			double salary = resultSet.getDouble(3);
			Date brithday = resultSet.getDate(4);
			
			//2 )使用属性名名称获取值;
			/*int emp_id = resultSet.getInt("emp_id");
			String emp_name = resultSet.getString("emp_name");
			double salary = resultSet.getDouble("emp_salary");
			Date brithday = resultSet.getDate("emp_brithday");
			
			Integer emp_id = (Integer) resultSet.getObject(1);
			String emp_name = (String) resultSet.getObject(2);
			Double salary = (Double) resultSet.getObject(3);
			Date brithday = (Date) resultSet.getObject(4);*/
			
			System.out.println(emp_id +","+emp_name+","+salary+","+brithday);
		}
		
		//7、释放资源：后开先关
		resultSet.close();
		stmt.close();
		conn.close();	
	}
}









