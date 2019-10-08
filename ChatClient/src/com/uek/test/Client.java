package com.uek.test;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.uek.domain.User;
import com.uek.utils.JframUtils;
import com.uek.view.CrowdChatView;
import com.uek.view.LoginView;
import com.uek.view.MainView;
import com.uek.view.PrivateChatView;
import com.uek.view.SearchView;

public class Client {
	public static Socket selfSocket;
	public static User selfUser;

	public static void main(String[] args) throws IOException {
		// 创建客户端
		Socket socket = new Socket("localhost", 8888);
		Client.selfSocket = socket;
		// 多线程
		Thread t = new ClientThread(socket);
		t.start();
		LoginView lv = new LoginView();
		lv.init();

		JframUtils.loginView = lv;

		// SearchView sv = new SearchView();
		// sv.init();
		// JframUtils.searchView = sv;

		// MainView mv = new MainView();
		// mv.init("zs", "ss", "ls");
		// JframUtils.mainView=mv;

	}
}

class ClientThread extends Thread {
	private Socket socket;

	public ClientThread(Socket socket) {

		this.socket = socket;
	}

	@Override
	public void run() {
		BufferedReader br;
		try {
			PrintStream ps = new PrintStream(socket.getOutputStream());
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println("客户端收到的内容是：" + line);
				String[] str = line.split(",");
				// 注册 1,ok
				if ("1".equals(str[0])) {
					if ("ok".equals(str[1])) {
						JOptionPane.showMessageDialog(null, "注册成功");
						JframUtils.loginView.getJt1().setText(str[2]);
						JframUtils.registerView.dispose();
						JframUtils.loginView.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, str[2]);
					}
				}
				// 登录
				if ("2".equals(str[0])) {
					if ("ok".equals(str[1])) {
						String usersStr = line.substring(5);
						String[] users = usersStr.split(";");
						// 缓存
						// 1,zs,qianming,touxiang
						String user = users[0];
						String[] ss = user.split(",");
						User us = new User(Integer.parseInt(ss[0]), ss[1], ss[2], ss[3]);
						Client.selfUser = us;
						JframUtils.loginView.dispose();
						MainView mv = new MainView();
						mv.init(users);
						JframUtils.mainView = mv;
					} else {
						JOptionPane.showMessageDialog(null, str[2]);
					}
				}

				// 搜索好友
				if ("3".equals(str[0])) {
					if ("ok".equals(str[1])) {
						String useStr = line.substring(5);
						String[] uses = useStr.split(";");

						Vector<String> columnNames = new Vector<>();
						columnNames.add("id");
						columnNames.add("name");
						columnNames.add("signature");
						columnNames.add("heared");
						Vector<Vector<String>> rows = new Vector<Vector<String>>();
						for (String string : uses) {
							// id,name,pass,s,t
							String[] use = string.split(",");
							Vector<String> row1 = new Vector<>();
							row1.add(use[0]);
							row1.add(use[1]);
							row1.add(use[3]);
							row1.add(use[4]);
							rows.add(row1);
						}
						JTable jt = new JTable(rows, columnNames);

						JScrollPane jsp = new JScrollPane(jt);
						
						SearchView sv = JframUtils.searchView;
						sv.setJt(jt);
						JPanel jp = sv.getJp2();
						
						jp.removeAll();
						jp.add(jsp);
						jp.updateUI();
					} else {
						JOptionPane.showMessageDialog(null, str[2]);
					}
				}
				// 加好友
				if ("4".equals(str[0])) {
					// 4.no,1.2.xiaoxi
					
						if (str.length == 3) {
							String selfId = str[1];
							int select = JOptionPane.showConfirmDialog(null, selfId + "要加你为好友");
							String returnMessage = null;
							// 同意
							if (select == 0) {
								returnMessage = line + ",ok";
								ps.println(returnMessage);
								ps.flush();
							}
							if (select == 1) {
								returnMessage = line + ",nook";
								ps.println(returnMessage);
								ps.flush();
							}

						}

						if (str.length >= 4) {
							String selfId = str[1];
							String friendId = str[2];

							if ("ok".equals(str[3])) {
								// 更新好友列表
								// 4,1,2,ok,1,zs,zs,1.jpg;2,ls,ls,1.jpg
								int selfIdLength = selfId.length();
								int friendIdLength = friendId.length();
								String usersStr = line.substring(7 + selfIdLength + friendIdLength);
								String[] selfAndFriend = usersStr.split(";");
								// 首先获取到主界面
								MainView mainView = JframUtils.mainView;

								// 拿到存放好友列表的面板新增一个好友
								JPanel jp3 = mainView.getJp3();

								jp3.removeAll();
								// jp3加入所有的好友
								for (int i = 0; i < selfAndFriend.length; i++) {

									String[] userInfo = selfAndFriend[i].split(",");

									JPanel jp31 = new JPanel();

									// jp31.setBorder(BorderFactory.createLineBorder(Color.RED));
									jp31.setSize(225, 80);
									jp31.setLocation(5, 5 + i * 85);
									jp31.setBackground(null);
									jp31.setOpaque(false);
									jp31.setLayout(null);

									ImageIcon img = new ImageIcon("image/" + userInfo[4]);
									JLabel jl = new JLabel(img);

									JPanel jp311 = new JPanel();
									// jp311.setBorder(BorderFactory.createLineBorder(Color.RED));
									jp311.setSize(80, 60);
									jp311.setLocation(10, 10);

									jp311.add(jl);

									jp31.add(jp311);

									JLabel jl2 = new JLabel(userInfo[1]);
									// jl2.setBorder(BorderFactory.createLineBorder(Color.RED));
									jl2.setSize(60, 30);
									jl2.setLocation(120, 10);

									jp31.add(jl2);

									JTextField jtf2 = new JTextField(userInfo[3]);
									// jtf2.setBorder(BorderFactory.createLineBorder(Color.RED));
									jtf2.setSize(100, 30);
									jtf2.setLocation(120, 40);

									jp31.add(jtf2);
									jp31.addMouseListener(new MouseAdapter() {
										@Override
										public void mouseClicked(MouseEvent e) {
											String friendId = userInfo[0];
											if (JframUtils.friendIdAndChat.get(friendId) != null) {
												JframUtils.friendIdAndChat.get(friendId);
											} else {
												PrivateChatView pc = new PrivateChatView();
												pc.init(friendId, userInfo[1]);
												JframUtils.friendIdAndChat.put(friendId, pc);
											}

										}
									});
									jp3.add(jp31);
								}

								jp3.updateUI();
							}

							if ("nook".equals(str[3])) {

								JOptionPane.showMessageDialog(null, friendId + "拒绝了您的好友请求");
							}
						}
					}
				
				// 私聊
				if ("5".equals(str[0])) {
					String selfId = str[1];
					String chat = str[3];
					PrivateChatView pc = JframUtils.friendIdAndChat.get(selfId);
					String oldChat = pc.getJta1().getText();
					pc.getJta1().setText(
							oldChat + "\n" + new Date().toLocaleString() + " " + selfId + "和你说：" + "\n" + chat);

				}
				// 创建群
				if ("6".equals(str[0])) {
					if ("ok".equals(str[1])) {
						// 更新界面
						JOptionPane.showMessageDialog(null, "创建成功");
						String crowdId = str[2];

						String returnMessage = "9," + crowdId;

						ps = new PrintStream(Client.selfSocket.getOutputStream());
						ps.println(returnMessage);
						ps.flush();
						 
						
						
					} else {
						JOptionPane.showMessageDialog(null, "已经被注册过");
					}
				}
				// 搜群
				if ("7".equals(str[0])) {
					if ("ok".equals(str[1])) {
						// 7,ok,1,name,zs,logo;
						String useStr = line.substring(5);
						String[] uses = useStr.split(";");

						Vector<String> columnNames = new Vector<>();
						columnNames.add("id");
						columnNames.add("name");
						columnNames.add("creatName");
						columnNames.add("logo");
						Vector<Vector<String>> rows = new Vector<Vector<String>>();
						for (String string : uses) {
							String[] use = string.split(",");
							Vector<String> row1 = new Vector<>();
							row1.add(use[0]);
							row1.add(use[1]);
							row1.add(use[2]);
							row1.add(use[3]);
							rows.add(row1);
						}

						JTable jt = new JTable(rows, columnNames);
						JScrollPane jsp = new JScrollPane(jt);
						jsp.setOpaque(false);
						jsp.getViewport().setOpaque(false);
						SearchView sv = JframUtils.searchView;
						sv.setJt(jt);
						JPanel jp = sv.getJp2();
						jp.setSize(560, 400);
						jp.setLocation(10, 40);
						jp.setBackground(null);
						jp.setOpaque(false);
						jp.removeAll();
						jp.add(jsp);
						jp.updateUI();

					} else {
						JOptionPane.showMessageDialog(null, "搜索失败!");
					}
				}
				// 加群
				if ("8".equals(str[0])) {

					// 8,ok,1.name.logo.dec;
					if ("ok".equals(str[1])) {
						String userId = str[2];
						JOptionPane.showMessageDialog(null, "加入成功!");
						String crowdsStr = line.substring(5);

						String[] crowds = crowdsStr.split(";");

						MainView mv = JframUtils.mainView;
						JPanel jp5 = mv.getJp5();

						jp5.removeAll();

						// jp3加入所有的群
						for (int i = 0; i < crowds.length; i++) {

							String[] crowdInfo = crowds[i].split(",");

							JPanel jp31 = new JPanel();

							// jp31.setBorder(BorderFactory.createLineBorder(Color.RED));
							jp31.setSize(225, 80);
							jp31.setLocation(5, 5 + i * 85);
							jp31.setBackground(null);
							jp31.setOpaque(false);
							jp31.setLayout(null);
							ImageIcon img = new ImageIcon("image/" + crowdInfo[2]);
							JLabel jl = new JLabel(img);
							JPanel jp311 = new JPanel();
							// jp311.setBorder(BorderFactory.createLineBorder(Color.RED));
							jp311.setSize(80, 60);
							jp311.setLocation(10, 10);
							jp311.setBackground(null);
							jp311.setOpaque(false);
							jp311.add(jl);
							jp31.add(jp311);
							JLabel jl2 = new JLabel(crowdInfo[1]);
							// jl2.setBorder(BorderFactory.createLineBorder(Color.RED));
							jl2.setSize(60, 30);
							jl2.setLocation(120, 10);
							jp31.add(jl2);
							JTextField jtf2 = new JTextField(crowdInfo[3]);
							// jtf2.setBorder(BorderFactory.createLineBorder(Color.RED));
							jtf2.setSize(100, 30);
							jtf2.setLocation(120, 40);
							jp31.add(jtf2);
							jp31.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent e) {
									String crowdId = crowdInfo[0];

									String returnMessage = "10," + crowdId;

									PrintStream ps;
									try {
										ps = new PrintStream(Client.selfSocket.getOutputStream());
										ps.println(returnMessage);
										ps.flush();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
							});
							jp5.add(jp31);
						}
						jp5.updateUI();
					} else {
						JOptionPane.showMessageDialog(null, "就在本群中!");
					}
				}
				// 更新群界面
				if ("9".equals(str[0])) {
					if ("ok".equals(str[1])) {

						// 9,ok,1,ubdf1907,crowd.jpg,张三;2,高手群,crowd.jpg,张三;

						String crowdsStr = line.substring(5);

						String[] crowds = crowdsStr.split(";");

						MainView mv = JframUtils.mainView;
						JPanel jp5 = mv.getJp5();

						jp5.removeAll();

						// jp3加入所有的群
						for (int i = 0; i < crowds.length; i++) {

							String[] crowdInfo = crowds[i].split(",");

							JPanel jp31 = new JPanel();

							// jp31.setBorder(BorderFactory.createLineBorder(Color.RED));
							jp31.setSize(225, 80);
							jp31.setLocation(5, 5 + i * 85);
							jp31.setBackground(null);
							jp31.setOpaque(false);
							jp31.setLayout(null);
							ImageIcon img = new ImageIcon("image/" + crowdInfo[2]);
							JLabel jl = new JLabel(img);
							JPanel jp311 = new JPanel();
							// jp311.setBorder(BorderFactory.createLineBorder(Color.RED));
							jp311.setSize(80, 60);
							jp311.setLocation(10, 10);
							jp311.setBackground(null);
							jp311.setOpaque(false);
							jp311.add(jl);
							jp31.add(jp311);
							JLabel jl2 = new JLabel(crowdInfo[1]);
							// jl2.setBorder(BorderFactory.createLineBorder(Color.RED));
							jl2.setSize(60, 30);
							jl2.setLocation(120, 10);
							jp31.add(jl2);
							JTextField jtf2 = new JTextField(crowdInfo[3]);
							// jtf2.setBorder(BorderFactory.createLineBorder(Color.RED));
							jtf2.setSize(100, 30);
							jtf2.setLocation(120, 40);
							jp31.add(jtf2);
							jp31.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent e) {
									String crowdId = crowdInfo[0];

									String returnMessage = "10," + crowdId;

									PrintStream ps;
									try {
										ps = new PrintStream(Client.selfSocket.getOutputStream());
										ps.println(returnMessage);
										ps.flush();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
							});
							jp5.add(jp31);
						}
						jp5.updateUI();
					}
					if ("nook".equals(str[1])) {
						JOptionPane.showMessageDialog(null, "没有创建过群也没有加入过群!");
					}
				}
				// 群成员界面 10,ok,1
				if ("10".equals(str[0])) {
					if ("ok".equals(str[1])) {
						String crowdId = str[2];

						// 10,ok,1,1,q1,qm,gsl.png;2,q1,qm,gsl.png;

						String crowdMembersStr = line.substring(7 + crowdId.length());

						String[] crowdMembers = crowdMembersStr.split(";");

						// 如果缓存的群聊天界面中有
						if (JframUtils.crowdAndChat.get(crowdId) != null) {
							// 显示
							JframUtils.crowdAndChat.get(crowdId).setVisible(true);
						} else// 如果缓存的群聊天界面中没有
						{
							// 新建并显示并缓存

							CrowdChatView cv = new CrowdChatView();

							cv.init(crowdId, crowdMembers);

							// 打开一个好友聊天界面需要缓存到我的聊天界面中
							JframUtils.crowdAndChat.put(crowdId, cv);
						}
					}
					if ("nook".equals(str[1])) {
						JOptionPane.showMessageDialog(null, "服务器错误!");
					}
				}
				// 发消息群聊
				if ("11".equals(str[0])) {
					String fromId = str[1];
					String crowdId = str[2];
					String content = str[3];

					CrowdChatView cv = JframUtils.crowdAndChat.get(crowdId);

					String oldContent = cv.getJta1().getText();

					cv.getJta1().setText(
							oldContent + "\n" + new Date().toLocaleString() + " " + fromId + "和大家说：" + "\n" + content);

				}

				
				if("12".equals(str[0])) {
					//好友
					if("requset".equals(str[1])) {
						String selfId = str[2];
						String friendId = str[3];
						String fileName = str[4];
						String returnMeseage = "";
						int select = JOptionPane.showConfirmDialog(null, selfId+"向你传输文件："+fileName);
						if (select == 1) {// 拒绝接受
							returnMeseage = "12,response,nook," + selfId + "," + friendId + "," + fileName;
							ps.println(returnMeseage);
							ps.flush();
						}
						if(select == 0) {// 接受
							returnMeseage = "12,response,ok," + selfId + "," + friendId + "," + fileName;
							ps.println(returnMeseage);
							ps.flush();
							
							ServerSocket ss = new ServerSocket(8890);
							Socket fileSocket = ss.accept();
							File file = new File(fileName);
							new ReceiveFileThread(fileSocket,file).start();
						}
						
					}
					
					if("response".equals(str[1])) {
						String fileName = str[5];
						if("ok".equals(str[2])) {
							ServerSocket ss = new ServerSocket(8890);
							Socket sendSocket = ss.accept();
							File file = new File(fileName);
							new sendFileThread(sendSocket, file).start();
						}
						if("nook".equals(str[2])) {
							JOptionPane.showMessageDialog(null, str[4]+"拒绝了你的请求"+fileName);
						}
					}
				}
				
				// 弹出给系统发送的消息
				if ("100".equals(str[0])) {

					String chat = str[1];
					JOptionPane.showMessageDialog(null, chat);

				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}