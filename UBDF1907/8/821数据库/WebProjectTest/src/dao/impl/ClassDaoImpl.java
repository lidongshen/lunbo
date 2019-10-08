package dao.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dao.ClassDao;
import entity.Clazz;

/**
 * DAO层的实现类：
 * 	完成使用JDBC对数据的增删改查;
 *
 */
public class ClassDaoImpl implements ClassDao{
	
	public static void main(String[] args) {
		ClassDaoImpl classDaoImpl = new ClassDaoImpl();
		List<Clazz> selectAll = classDaoImpl.selectAll();
		System.out.println(selectAll);
	}
	
	//查询班级表中所有数据：
	public List<Clazz> selectAll(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Clazz> list = new ArrayList<Clazz>();
		
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
		    
		    //5.指定操作
		    String sql = "select * from t_class1";
		    //更新 删除

		    //6.创建一个预处理sql对象，对sql进行安全检查：
		    pstmt = conn.prepareStatement(sql);

		    //执行sql操作：
		    rs = pstmt.executeQuery();
		    while(rs.next()) {
		    	int cid = rs.getInt(1);
		    	String cname = rs.getString(2);
		    	//封装对象：
		    	Clazz clazz = new Clazz(cid, cname);
		    	list.add(clazz);
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
		return list;
	}

	@Override
	public boolean createClassTable() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean state = false;
		
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
		    
		    //5.指定操作
		    String sql = "create table t_class1(cid int , cname varchar(20))";
		    //更新 删除

		    //6.创建一个预处理sql对象，对sql进行安全检查：
		    pstmt = conn.prepareStatement(sql);

		    //执行sql操作：
		    int state1 = pstmt.executeUpdate();
		    System.out.println(state);
		    if (state1 >= 0) {
				state = true;
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
		return state;
	}

}
