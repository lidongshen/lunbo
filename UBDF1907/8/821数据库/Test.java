package com.uek;

import static org.hamcrest.CoreMatchers.containsString;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Test {
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8", "root", "123456");
		Statement stmt = conn.createStatement();
		String uname = "shi";
		String pwd = "1' or '1' ='1";  //SQL注入
		String sql = "select * from t_user where uname = '"+uname+"' and pwd='"+pwd+"'";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			int uid = rs.getInt("uid");
			String name = rs.getString("uname");
			int pwd1 = rs.getInt("pwd");
			
			System.out.println(uid +","+name+","+pwd);
		}
		
		rs.close();
		stmt.close();
		conn.close();
	}
}








































