package com.uek.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTextArea;

import com.uek.domain.Friend;
import com.uek.domain.User;
import com.uek.service.impl.UserServiceImpl;
import com.uek.service.inter.IUserService;
import com.uek.utils.JframUtils;
import com.uek.utils.MessageUtil;
import com.uek.view.ServerView;

public class Server {
	public static Map<String, Socket> userAndFriend = new HashMap<String, Socket>();

	public static void main(String[] args) throws IOException {
		// 创建服务器
		ServerSocket ss = new ServerSocket(8888);
		// 进行连接和循环，实现可以一直有不同的客户端来访问服务器
		ServerView sv = new ServerView();
		sv.init();
		JframUtils.serverView = sv;
		while (true) {
			Socket s = ss.accept();
			Thread t = new ServerTheard(s);
			t.start();

		}
	}
}

class ServerTheard extends Thread {
	private Socket socket;

	public ServerTheard(Socket socket) {

		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintStream ps = new PrintStream(socket.getOutputStream());
			String line = null;
			ServerView serverView = JframUtils.serverView;
			// 得到以前的内容
			JTextArea jt2 = serverView.getJt2();
			String oldChat = jt2.getText();
			// 拼接新的内容
			String newChat = "";
			
			while ((line = br.readLine()) != null) {
				System.out.println("服务器收到的内容：" + line);
				String[] str = line.split(",");
				
				IUserService userService = new UserServiceImpl();
				
				// 注册 1,zs,111,123,11
				if ("1".equals(str[0])) {
					// 首先解析出来数据
					String name = str[1];
					String passWord = str[2];
					String signature = str[3];
					String heared = str[4];
					oldChat = jt2.getText();
					newChat = oldChat + "\n" +name+" "+"正在注册" + new Date().toLocaleString() + " " +  "注册的内容是："+line.substring(1);
					jt2.setText(newChat);
					// 定义返回值
					String returnMeseage = null;
					
					User user = new User(name, passWord, signature, heared);
					try {
						userService.register(user);
						returnMeseage = "1,ok,"+name;
					} catch (Exception e) {
						returnMeseage = "1,nook,"+ e.getMessage();
					}
					MessageUtil.sendMessage(socket, returnMeseage);

				}
				// 登录界面
				if ("2".equals(str[0])) {
					oldChat = jt2.getText();
					newChat = oldChat + "\n" + "登录" + new Date().toLocaleString() + " " + str[1] + "正在登陆";
					jt2.setText(newChat);
					
					String name = str[1];
					String passWord = str[2];
					StringBuffer sb = new StringBuffer();
					String returnMeseage = null;

	
					try {
						User user = userService.login(name, passWord);
						
						List<User> friendList = userService.friendList(user);
						
						for (User user2 : friendList) {
							sb.append(user2);
							sb.append(";");
						}
						
						returnMeseage = "2,ok," + user.toString() +";"+ sb.toString() ;
						Server.userAndFriend.put(user.getId() + "", socket);
						
						oldChat = jt2.getText();
						newChat = oldChat + "\n" + "登录" + new Date().toLocaleString() + " " + str[1] + "登录成功！";
						jt2.setText(newChat);
					} catch (Exception e) {
						returnMeseage = "2,nook," + e.getMessage();

						oldChat = jt2.getText();
						newChat = oldChat + "\n" + "登录" + new Date().toLocaleString() + " " + str[1] + "登录失败！";
						jt2.setText(newChat);
						
					}
					
					MessageUtil.sendMessage(socket, returnMeseage);
				}
				// 搜索好友
				if ("3".equals(str[0])) {
					String SearKey = str[1];

					String returnMeseage = null;
					
					try {
						List<User> seachFriendList = userService.seachFriendList(SearKey);
						StringBuffer sb = new StringBuffer();
						for (User user2 : seachFriendList) {
							sb.append(user2);
							sb.append(";");
						}
						returnMeseage = "3,ok,"+sb;
					}catch (Exception e) {
						returnMeseage = "3,nook,"+e.getMessage();
					}
					MessageUtil.sendMessage(socket, returnMeseage);
				}
				// 加好友界面
				if ("4".equals(str[0])) {
					// 4,1,3
					String selfId = str[1];
					String friendId = str[2];
					Friend friend = new Friend(Integer.parseInt(selfId),Integer.parseInt(friendId));
					
						
						if (str.length == 3) {
							oldChat = jt2.getText();
							newChat = oldChat + "\n" + new Date().toLocaleString() + " " + selfId + "申请加"+friendId+"为好友！";
							jt2.setText(newChat);
							
							Socket friendSocket = Server.userAndFriend.get(friendId);
							MessageUtil.sendMessage(friendSocket, line);
						}
						// 4,1,3,ok||nook
						if (str.length == 4) {
							if ("ok".equals(str[3])) {
								oldChat = jt2.getText();
								newChat = oldChat + "\n" + new Date().toLocaleString() + " " + selfId + "加"+friendId+"成功！";
								jt2.setText(newChat);
								//加好友
								userService.addFriend(friend);
								StringBuffer sb = new StringBuffer();
								//4,1,3,ok||nook
								sb.append(line + ",");
								// 加完好友，进行查询好友列表得到好友列表
								User selfUser = userService.load(Integer.parseInt(selfId));
								List<User> selfFriendList = userService.friendList(selfUser);
								for (User selfuser : selfFriendList) {
									sb.append(selfuser);
									sb.append(";");
								}
								Socket selfSocket = Server.userAndFriend.get(selfId);
								MessageUtil.sendMessage(selfSocket, sb.toString());
								
								// 被加好友的列表
								sb = new StringBuffer();
								sb.append(line + ",");
								User friendUser1 = userService.load(Integer.parseInt(friendId));
								
								List<User> friendFriendList = userService.friendList(friendUser1);
								for (User frienduser : friendFriendList) {
									sb.append(frienduser);
									sb.append(";");
								}
								Socket friendSocket = Server.userAndFriend.get(friendId);
								MessageUtil.sendMessage(friendSocket, sb.toString());
								
							} else {
								oldChat = jt2.getText();
								newChat = oldChat + "\n" + new Date().toLocaleString() + " " +friendId  + "拒绝了"+selfId+"好友请求！";
								jt2.setText(newChat);
								
								Socket selfSocket = Server.userAndFriend.get(selfId);
								MessageUtil.sendMessage(selfSocket, line);
							}
						}
					
				}
				
				
				// 私聊
				if ("5".equals(str[0])) {
					oldChat = jt2.getText();
					newChat = oldChat + "\n" + "私聊" + new Date().toLocaleString() + " " + str[1] + "和" + str[2]
							+ "发送了内容：" + str[3];
					jt2.setText(newChat);

					String friendId = str[2];
					Socket friendSocket = Server.userAndFriend.get(friendId);
					MessageUtil.sendMessage(friendSocket, line);
				}
				// 创建群
				if ("6".equals(str[0])) {
					//// 6,创建人id,什么时间,群名字,群描述,群logo
					String createrId = str[1];
					String creatTime = str[2];
					String name = str[3];
					String desc = str[4];
					String logo = str[5];
					oldChat = jt2.getText();
					newChat = oldChat + "\n" +createrId+"正在创建群" + new Date().toLocaleString() + " " +"创建的群信息是：" + line.substring(23);
					jt2.setText(newChat);
					String returnMeseage = null;
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/t_test?userUnicode=true&setCharsetEncoding=utf-8", "root",
							"root");
					Statement stat = conn.createStatement();
					String sql = "select * from t_crowd where name='" + name + "'";
					ResultSet rs = stat.executeQuery(sql);
					if (rs.next()) {
						returnMeseage = "6,nook";
					} else {
						sql = "insert into t_crowd(creater_id,creater_time,name,description,logo) values('" + createrId
								+ "','" + creatTime + "','" + name + "','" + desc + "','" + logo + "')";
						stat.executeUpdate(sql);
						sql = "select last_insert_id()";
						rs = stat.executeQuery(sql);
						rs.next();// 因为有指针指向了结果集中的第一条记录的前边 next向第一条
						int crowdId = rs.getInt(1);
						sql = "insert into t_crowd_member(user_id,crowd_id,join_time,status) values('" + createrId
								+ "','" + crowdId + "','" + new Date().toLocaleString() + "','" + 1 + "')";
						stat.executeUpdate(sql);
						returnMeseage = "6,ok,"+ createrId;
					}
					stat.close();
					conn.close();
					ps.println(returnMeseage);
					ps.flush();
				}
				// 搜群
				if ("7".equals(str[0])) {
					String SearchKey = str[1];
					String returnMeseage = null;
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/t_test?userUnicode=true&setCharsetEncoding=utf-8", "root",
							"root");
					Statement stat = conn.createStatement();
					String sql = "select t1.* , t2.name as creater_name from t_crowd t1 join t_user t2 on t1.creater_id=t2.id where t1.name like '%"
							+ SearchKey + "%'";
					ResultSet rs = stat.executeQuery(sql);
					StringBuffer sb = new StringBuffer();
					sb.append("7,ok,");
					while (rs.next()) {
						sb.append(rs.getInt("id"));
						sb.append(",");
						sb.append(rs.getString("name"));
						sb.append(",");
						sb.append(rs.getString("creater_name"));
						sb.append(",");
						sb.append(rs.getString("logo"));
						sb.append(";");
					}
					if (sb.toString().length() == 5) {
						returnMeseage = "7,nook";
					} else {
						returnMeseage = sb.toString();
					}
					stat.close();
					conn.close();
					ps.println(returnMeseage);
					ps.flush();

				}
				// 加群
				if ("8".equals(str[0])) {
					// 8,1,2
					String userId = str[1];
					String crowdId = str[2];
					oldChat = jt2.getText();
					newChat = oldChat + "\n" + new Date().toLocaleString() + " " +userId  + "申请加入"+crowdId+"群！";
					jt2.setText(newChat);
					String returnMeseage = null;
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/t_test?userUnicode=true&setCharsetEncoding=utf-8", "root",
							"root");
					Statement stat = conn.createStatement();
					String sql = "select user_id from t_crowd_member where crowd_id = '" + crowdId + "'and user_id='"
							+ userId + "' ";
					ResultSet rs = stat.executeQuery(sql);

					if (rs.next()) {
						returnMeseage = "8,nook";
						oldChat = jt2.getText();
						newChat = oldChat + "\n" + new Date().toLocaleString() + " " +userId  + "已经在"+crowdId+"群中！";
						jt2.setText(newChat);
					} else {
						sql = "insert into t_crowd_member(user_id,crowd_id,join_time,status) values('" + userId + "','"
								+ crowdId + "','" + new Date().toLocaleString() + "','" + 1 + "')";
						stat.executeUpdate(sql);
						sql = "select t2.id,t2.name,t2.logo,t2.description from t_crowd_member t1 join t_crowd t2 on t1.crowd_id=t2.id   where t1.user_id="
								+ userId;
						rs = stat.executeQuery(sql);
						StringBuffer sb = new StringBuffer();
						sb.append("8,ok,");
						while (rs.next()) {
							sb.append(rs.getInt("id"));
							sb.append(",");
							sb.append(rs.getString("name"));
							sb.append(",");
							sb.append(rs.getString("logo"));
							sb.append(",");
							sb.append(rs.getString("description"));
							sb.append(";");
						}

						returnMeseage = sb.toString();
						stat.close();
						conn.close();
						
						oldChat = jt2.getText();
						newChat = oldChat + "\n" + new Date().toLocaleString() + " " +userId  + "加入到"+crowdId+"群中！";
						jt2.setText(newChat);
					}
					ps.println(returnMeseage);
					ps.flush();
				}
				// 群点击按钮实时刷新界面
				if ("9".equals(str[0])) {
					String userId = str[1];
					String returnMessage = null;
					StringBuffer sb = new StringBuffer();
					sb.append("9,ok,");
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/t_test?userUnicode=true&setCharsetEncoding=utf-8", "root",
							"root");
					Statement stat = conn.createStatement();

					String sql = "select t2.id,t2.name,t2.logo,t2.description from t_crowd_member t1 join t_crowd t2 on t1.crowd_id=t2.id   where t1.user_id="
							+ userId;

					ResultSet rs = stat.executeQuery(sql);
					while (rs.next()) {
						sb.append(rs.getInt("id"));
						sb.append(",");
						sb.append(rs.getString("name"));
						sb.append(",");
						sb.append(rs.getString("logo"));
						sb.append(",");
						sb.append(rs.getString("description"));
						sb.append(";");
					}
					if (sb.toString().length() == 5) {
						returnMessage = "9,nook";
					} else {
						returnMessage = sb.toString();
					}

					stat.close();
					conn.close();
					ps.println(returnMessage);
					ps.flush();
				}

				// 获取所有成员
				if ("10".equals(str[0])) {
					String crowdId = str[1];
					String returnMessage = null;
					StringBuffer sb = new StringBuffer();
					sb.append("10,ok," + crowdId + ",");

					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn = DriverManager.getConnection(
								"jdbc:mysql://localhost:3306/t_test?userUnicode=true&setCharsetEncoding=utf-8", "root",
								"root");
						Statement stat = conn.createStatement();

						String sql = "select t2.*  from t_crowd_member t1 join t_user t2 on t1.user_id=t2.id  where t1.crowd_id="
								+ crowdId;

						ResultSet rs = stat.executeQuery(sql);

						while (rs.next()) {

							sb.append(rs.getInt("id"));
							sb.append(",");
							sb.append(rs.getString("name"));
							sb.append(",");
							sb.append(rs.getString("signature"));
							sb.append(",");
							sb.append(rs.getString("heared"));
							sb.append(";");
						}

						if (sb.toString().length() == (7 + crowdId.length())) {

							returnMessage = "10,nook";
						} else {
							returnMessage = sb.toString();
						}
						stat.close();
						conn.close();
					} catch (Exception e) {
						returnMessage = "10,nook";
						e.printStackTrace();
					}
					ps.println(returnMessage);
					ps.flush();
				}

				// 发消息的群聊
				if ("11".equals(str[0])) {
					String userId = str[1];
					String crowdId = str[2];
					String chatContent = str[3];
					oldChat = jt2.getText();
					newChat = oldChat + "\n" + "群聊" + new Date().toLocaleString() + " " + userId + "在" + crowdId
							+ "群发送了内容：" + chatContent;
					jt2.setText(newChat);
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/t_test?userUnicode=true&setCharsetEncoding=utf-8", "root",
							"root");
					Statement stat = conn.createStatement();

					// 只需要user_id这一列，所以只查询这一列 效率高
					String sql = "select user_id from t_crowd_member where crowd_id=" + crowdId;

					ResultSet rs = stat.executeQuery(sql);
					while (rs.next()) {
						int crowdMemberId = rs.getInt("user_id");

						Socket crowdMemberSocket = Server.userAndFriend.get(crowdMemberId + "");

						// 只给在线的群成员发送群聊的信息
						if (crowdMemberSocket != null) {
							PrintStream crowdMemberPs = new PrintStream(crowdMemberSocket.getOutputStream());
							crowdMemberPs.println(line);
							crowdMemberPs.flush();
						}

					}

				}
				
				if("12".equals(str[0])) {
					//好友
					if("requset".equals(str[1])) {
						Socket friendSocket = Server.userAndFriend.get(str[3]);
						MessageUtil.sendMessage(friendSocket, line);
					}
					
					if("response".equals(str[1])) {
						String selfId = str[3];
						String friendId = str[4];
						String fileName = str[5];
						Socket selfSocket = Server.userAndFriend.get(selfId);
						MessageUtil.sendMessage(selfSocket, line);
						
						Thread.sleep(1000);
						
						if("ok".equals(str[2])) {
							Socket sendSocket = new Socket("localhost",8890);
							
							Socket receiveSocket = new Socket("localhost",8890);
							
							File file = new File(fileName);
							new ReceiceAndSendFileThread(sendSocket,receiveSocket,selfId,friendId,file).start();
						}
					
					
					
					
					}
					
					
					
				}	
				
				
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}