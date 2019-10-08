
package com.uek.testIO和网络编程.v8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class Server08 {
	
	public static Map<String , Socket> userIdAndSockets = new HashMap<String ,Socket>();
	
	public static void main(String[] args) throws IOException  {
		
		ServerSocket  ss = new ServerSocket(8888);
		
		System.out.println("服务器已经启动，准备等待客户端的连接。。。");
		System.out.println("ss.accept() 会线程阻塞 ，没有客户端连接 程序卡在这里 等待客户端连接");
		
	
		
		//不停的接收客户端的连接 并且读取客户端的输入 输出到自己的控制台
		while(true)
		{
			//接收客户端的连接
			Socket socket = ss.accept();
			
			Thread t = new ServerThread(socket);
			t.start();
			
		}
		
		
	}
}


class ServerThread extends Thread
{
	private Socket socket;
	
	public ServerThread(Socket socket)
	{
		this.socket = socket;
	}
	
	@Override
	public void run() /*throws IOException 子类不能比父类抛出更多的异常*/  {
		
		PrintStream ps;
		try {
			
			ps = new PrintStream(socket.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			String line = null;
			
			while( (line = br.readLine()) != null )
			{
//				socket.getInetAddress()
//				socket.getPort()
				
				System.out.println("服务器收到某个客户端的数据: " + line);
				
				String[] strs = line.split(",");
				
				//客户端要注册 1,zs,111,iam zs,1.jpg
				if("1".equals(strs[0]))
				{
					String name = strs[1];
					String password = strs[2];
					String signature = strs[3];
					String header = strs[4];
					
					String returnMessage = null;
					
					try {
						//1 加载驱动类 //2 用驱动管理器注册驱动
						Class.forName("com.mysql.jdbc.Driver");
						
						//3 用驱动管理器去获取数据库连接 建立java程序和数据库的桥梁
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_chat?useUnicode=true&characterEncoding=utf-8", "root", "root");
						//4 用连接准备一个工具 小推车
						Statement stat = conn.createStatement();
						
						String sql = "select * from t_user where name='"+name+"'";
						
						ResultSet rs = stat.executeQuery(sql);
						
						//就证明数据库存在这个用户名 就告诉客户端重新注册
						if(rs.next())
						{
							returnMessage = "1,nook";
						}else
						{
							//5 准备sql语句
							sql = "insert into t_user(name,password,signature,header) values('"+name+"','"+password+"','"+signature+"','"+header+"')";
							//6 工具执行sql 小推车把sql推到数据库执行
							
							stat.executeUpdate(sql);
							
							returnMessage = "1,ok";
						}
						
						//7 关闭资源
						stat.close();
						conn.close();
						
						
					} catch (Exception ex) {
						
						ex.printStackTrace();
					}
					
					//无论注册是否成功 给客户端的信息一定要返回 协议
					ps.println(returnMessage);
					ps.flush();
				}
				
				
				if("2".equals(strs[0]))
				{
					String name = strs[1];
					String password = strs[2];
					
					String returnMessage = null;
					
					try {
						//1 加载驱动类 //2 用驱动管理器注册驱动
						Class.forName("com.mysql.jdbc.Driver");
						
						//3 用驱动管理器去获取数据库连接 建立java程序和数据库的桥梁
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_chat?useUnicode=true&characterEncoding=utf-8", "root", "root");
						//4 用连接准备一个工具 小推车
						Statement stat = conn.createStatement();
						
						String sql = "select * from t_user where name='"+name+"' and password='"+password+"'";
						
						ResultSet rs = stat.executeQuery(sql);
						
						
						//根据用户名和密码最多找到一条 所以用if就可以 不用while循环
						if(rs.next())
						{
							StringBuffer sb = new StringBuffer();
							sb.append("2,ok,");
							
							int id = rs.getInt("id");
							sb.append(id);
							sb.append(",");
							sb.append(rs.getString("name"));
							sb.append(",");
							sb.append(rs.getString("signature"));
							sb.append(",");
							sb.append(rs.getString("header"));
							sb.append(";");
							
							
							
							
							sql = "SELECT * FROM t_user WHERE id IN ( SELECT friend_id FROM t_friend WHERE self_id = ( SELECT id FROM t_user WHERE NAME = '"+name+"' ))";
							
							rs = stat.executeQuery(sql);
							
							//如果找到好友
							while(rs.next())
							{
								sb.append(rs.getInt("id"));
								sb.append(",");
								sb.append(rs.getString("name"));
								sb.append(",");
								sb.append(rs.getString("signature"));
								sb.append(",");
								sb.append(rs.getString("header"));
								sb.append(";");
								
								
							}
							
							returnMessage = sb.toString();
							
							//如果用户名和密码正确，除了给客户返回自己和好友的信息还需要
							//缓存<userId , Socket> 以便后续服务器可以方便的根据userId找到Socket
							
							Server08.userIdAndSockets.put(id+"", socket);
							
						}else
						{
							
							 returnMessage = "2,nook";
						}
						
						
						//7 关闭资源
						stat.close();
						conn.close();
						
						
					} catch (Exception ex) {
						
						ex.printStackTrace();
					}
					
					//无论收到到了没有 根据协议给客户端的信息一定要返回
					ps.println(returnMessage);
					ps.flush();
					
					
				}
				
				if("3".equals(strs[0]))
				{
					//解析客户端发过来的数据
					String searchKey = strs[1];
					
					String returnMessage = null;
					
					try {
						//1 加载驱动类 //2 用驱动管理器注册驱动
						Class.forName("com.mysql.jdbc.Driver");
						
						//3 用驱动管理器去获取数据库连接 建立java程序和数据库的桥梁
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_chat?useUnicode=true&characterEncoding=utf-8", "root", "root");
						//4 用连接准备一个工具 小推车
						Statement stat = conn.createStatement();
						
						String sql = "select * from t_user where name like '%"+searchKey+"%'";
						
						ResultSet rs = stat.executeQuery(sql);
						
						
						//由于String的不可变性 += 的代价很大 不断去新开辟内存 销毁内存 性能很低
						//替换方案是Stringbuffer 意思就是一块内存可以追加内容
						StringBuffer sb = new StringBuffer();
						sb.append("3,ok,");
						
						while(rs.next())
						{
							sb.append(rs.getInt("id"));
							sb.append(",");
							sb.append(rs.getString("name"));
							sb.append(",");
							sb.append(rs.getString("signature"));
							sb.append(",");
							sb.append(rs.getString("header"));
							sb.append(";");
						}
						
						
						if(sb.toString().length() == 5)
						{
							
							returnMessage = "3,nook";
						}else
						{
							returnMessage = sb.toString().substring(0,sb.length()-1);
						}
						
						
						//7 关闭资源
						stat.close();
						conn.close();
						
						
					} catch (Exception ex) {
						
						ex.printStackTrace();
					}
					
					//无论收到到了没有 根据协议给客户端的信息一定要返回
					ps.println(returnMessage);
					ps.flush();
				}
				
				
				if("4".equals(strs[0]))
				{
					
					//4的第一种可能 4,1,2
					//4的第二种可能 4,1,2,ok|nook
					
					String selfId = strs[1];
					String friendId = strs[2];
					
					if(strs.length == 3)
					{
						//假设好友在线，如果不在线，较为复杂。。
						//缓存起来该消息，然后等对方上线之后，推送给他
						Socket friendSocket = Server08.userIdAndSockets.get(friendId);
						PrintStream friendPs = new PrintStream(friendSocket.getOutputStream());
						friendPs.println(line);
						friendPs.flush();
						
					}
					
					//如果是长度是4 说明是加好友是否统一的反馈
					if(strs.length == 4)
					{
						
						if("ok".equals(strs[3]))//对方统一加好友
						{
							
							//1 加载驱动类 //2 用驱动管理器注册驱动
							try {
								Class.forName("com.mysql.jdbc.Driver");
								//3 用驱动管理器去获取数据库连接 建立java程序和数据库的桥梁
								Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_chat?useUnicode=true&characterEncoding=utf-8", "root", "root");
								//4 用连接准备一个工具 小推车
								Statement stat = conn.createStatement();
								
								String sql = "insert into t_friend(self_id , friend_id) values("+selfId+","+friendId+")";
								stat.executeUpdate(sql);
								
								
								sql = "insert into t_friend(self_id , friend_id) values("+friendId+","+selfId+")";
								
								stat.executeUpdate(sql);
								
								
								//加完好友之后，然后查询双方的好友列表，发送给双方
								//1 查询李四（发出请求者）的自己和好友列表
								
								
								StringBuffer sb = new StringBuffer();
								sb.append(line+",");//4,1,2,ok
								
								sql = "select * from t_user where id="+selfId;
								
								ResultSet rs = stat.executeQuery(sql);
								
								if(rs.next())
								{
									sb.append(rs.getInt("id"));
									sb.append(",");
									sb.append(rs.getString("name"));
									sb.append(",");
									sb.append(rs.getString("signature"));
									sb.append(",");
									sb.append(rs.getString("header"));
									sb.append(";");
								}
								
								sql = "SELECT * from t_user where id in (SELECT friend_id from  t_friend where self_id="+selfId+")";

								rs = stat.executeQuery(sql);
								
								while(rs.next())
								{
									sb.append(rs.getInt("id"));
									sb.append(",");
									sb.append(rs.getString("name"));
									sb.append(",");
									sb.append(rs.getString("signature"));
									sb.append(",");
									sb.append(rs.getString("header"));
									sb.append(";");
								}
								
								Socket selfSocket = Server08.userIdAndSockets.get(selfId);
								PrintStream selfPs = new PrintStream(selfSocket.getOutputStream());
								//sb.toString.subString(0 , length-1); 不要截取掉最后一个;
								//因为假设只要一个好友，；分隔就成了String[] length=0
								selfPs.println(sb.toString());
								selfPs.flush();
								
							
								
								//2 查询ww（被请求的用户）的自己和好友列表
								
								sb = new StringBuffer();
								sb.append(line+",");//4,1,2,ok
								
								sql = "select * from t_user where id="+friendId;
								
								rs = stat.executeQuery(sql);
								
								if(rs.next())
								{
									sb.append(rs.getInt("id"));
									sb.append(",");
									sb.append(rs.getString("name"));
									sb.append(",");
									sb.append(rs.getString("signature"));
									sb.append(",");
									sb.append(rs.getString("header"));
									sb.append(";");
								}
								sql = "SELECT * from t_user where id in (SELECT friend_id from  t_friend where self_id="+friendId+")";

								rs = stat.executeQuery(sql);
								
								while(rs.next())
								{
									sb.append(rs.getInt("id"));
									sb.append(",");
									sb.append(rs.getString("name"));
									sb.append(",");
									sb.append(rs.getString("signature"));
									sb.append(",");
									sb.append(rs.getString("header"));
									sb.append(";");
								}
								
								Socket friendSocket = Server08.userIdAndSockets.get(friendId);
								PrintStream friendPs = new PrintStream(friendSocket.getOutputStream());
								friendPs.println(sb.toString());
								friendPs.flush();
								
								stat.close();
								conn.close();
							} catch (Exception e) {
								e.printStackTrace();
							}
							
							
							
						}else//对方不同意加好友
						{
							Socket selfSocket = Server08.userIdAndSockets.get(selfId);
							PrintStream selfPs = new PrintStream(selfSocket.getOutputStream());
							selfPs.println(line);
							selfPs.flush();
						}
						
					}
					
					
					
				}
				
				
				
				if("5".equals(strs[0]))
				{
					String friendId = strs[2];
					
					Socket friendSocket = Server08.userIdAndSockets.get(friendId);
					
					PrintStream friendPs = new PrintStream(friendSocket.getOutputStream());
					friendPs.println(line);
					friendPs.flush();
				}
				
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}