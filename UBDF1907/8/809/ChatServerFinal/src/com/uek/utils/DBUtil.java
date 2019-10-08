package com.uek.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 工具类可以定义成final 或单例的
 * 
 * @author UEK-N
 *
 */
public final class DBUtil {

	// 常量的命令 全部大写 下划线分隔 多个单词
	public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/db_chat?useUnicode=true&setCharacterEncoding=utf-8";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "root";

	// 类初始化除了面试 实际代码中很少写 注册数据库的驱动基本是个例
	// static类初始化块的特点是执行一次
	static {

		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {

			// 这种打印，实际上不管用，因为后续程序还会执行
			// 但是数据库如果连不上实际后果很严重，程序实际不应该往后执行了
			e.printStackTrace();

			throw new RuntimeException("数据库连不上!");
		}

	}

	public static Connection getConnection() throws SQLException {

		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}

	public static void freeConnection(ResultSet rs, Statement stat, Connection conn) {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stat != null) {
					try {
						stat.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						if (conn != null) {
							try {
								conn.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			}
		}

	}

	public static void freeConnection(Statement stat, Connection conn) {

		if (stat != null) {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

}
