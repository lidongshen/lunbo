package com.uek.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.uek.test.Client;
import com.uek.utils.JframUtils;

public class MainView extends JFrame {
	private JTabbedPane jtp;
	private JPanel jp1, jp2, jp3, jp4, jp5;
	private JLabel jl1, jl2;
	private JPanel jp11;
	private JTextField jt1;
	private JButton jb1, jb2;

	public JPanel getJp3() {
		return jp3;
	}

	public JPanel getJp5() {
		return jp5;
	}

	public void init(String[] selfAndFriend) {
		// 背景图片
		ImageIcon icon = new ImageIcon("image/main.jpg");
		JPanel jp0 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				Image img = icon.getImage();
				g.drawImage(img, 0, 0, icon.getIconWidth(), icon.getIconHeight(), icon.getImageObserver());
			}
		};
		jp0.setLayout(null);
		
		String[] self = selfAndFriend[0].split(",");
		String name = self[1];
		String signature = self[3];
		String header = self[4];

		// 设置绝对定位jp1 第一个盒子
		
		jp1 = new JPanel();
		jp1.setBorder(BorderFactory.createLineBorder(Color.gray));
		jp1.setSize(235, 100);
		jp1.setLocation(5, 5);
		jp1.setBackground(null);
		jp1.setOpaque(false);

		// 设置jp11绝对定位 左边
		jp11 = new JPanel();
		// jp11.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		jp11.setSize(100, 80);
		jp11.setLocation(10, 10);
		jp11.setBackground(null);
		jp11.setOpaque(false);
		// 头像
		ImageIcon image = new ImageIcon("image//" + header);
		jl2 = new JLabel(image);
		jp11.add(jl2);

		// 设置jl1的位置 网名
		jl1 = new JLabel(name);
		// jl1.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		jl1.setSize(50, 20);
		jl1.setLocation(120, 20);
		// 设置jt1 签名
		jt1 = new JTextField(signature);
		// jt1.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		jt1.setSize(100, 35);
		jt1.setLocation(120, 45);

		jp1.setLayout(null);

		
		jp1.add(jp11);
		jp1.add(jl1);
		jp1.add(jt1);
		jp0.add(jp1);
		// 搜索框
		jp2 = new JPanel();
		jp2.setBorder(BorderFactory.createLineBorder(Color.gray));
		jp2.setSize(235, 30);
		jp2.setLocation(5, 110);
		jp2.setBackground(null);
		jp2.setOpaque(false);
		jp0.add(jp2);

		// 选项卡界面
		UIManager.put("TabbedPane.contentOpaque", false);
		jtp = new JTabbedPane();
		jtp.setBorder(BorderFactory.createLineBorder(Color.gray));
		jtp.setSize(235, 360);
		jtp.setLocation(5, 145);
		
		// 好友框
		jp3 = new JPanel();
		jp3.setBorder(BorderFactory.createLineBorder(Color.gray));
		jp3.setSize(220, 340);
		jp3.setLocation(10, 10);
		jp3.setBackground(null);
		jp3.setOpaque(false);
		jp3.setLayout(null);
		// 方法
		initFriendList(selfAndFriend);
		jtp.add("好友", jp3);
		
		// 群框
		jp5 = new JPanel();
		jp5.setBorder(BorderFactory.createLineBorder(Color.gray));
		jp5.setSize(220, 340);
		jp5.setLocation(10, 10);
		jp5.setBackground(null);
		jp5.setOpaque(false);
		jp5.setLayout(null);
		// 方法
		//String[] crowd = new String[] { "1,q1,c1,zs.jpg", "2,q2,c2,ls.jpg" };
		//initCrowdList(crowd);
		jtp.add("群", jp5);
		jtp.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				if (jtp.getSelectedIndex() == 1) {
					String message = "9," + Client.selfUser.getId();

					PrintStream ps;
					try {
						ps = new PrintStream(Client.selfSocket.getOutputStream());
						ps.println(message);
						ps.flush();

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}

		});
		jp0.add(jtp);
		
		// 搜索框大小
		jp4 = new JPanel();
		jp4.setBorder(BorderFactory.createLineBorder(Color.gray));
		jp4.setSize(235, 50);
		jp4.setLocation(5, 515);
		jp4.setBackground(null);
		jp4.setOpaque(false);
		// 设置按钮
		jb1 = new JButton("搜索");
		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SearchView rv = new SearchView();
				rv.init();
				JframUtils.searchView = rv;
			}
		});

		jb2 = new JButton("创建群");
		jb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 6,创建人id,什么时间,群名字,群描述,群logo
				String crowdMeseage = JOptionPane.showInputDialog("请输入群名称，群简介，图片：");
				String date = new Date().toLocaleString();
				String returnMeseage = "6," + Client.selfUser.getId() + "," + date + "," + crowdMeseage;
				try {
					PrintStream ps = new PrintStream(Client.selfSocket.getOutputStream());
					ps.println(returnMeseage);
					ps.flush();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		jp4.add(jb1);
		jp4.add(jb2);
		jp0.add(jp4);
		this.add(jp0);
		this.setTitle(name + "主界面登录");
		this.setSize(icon.getIconWidth(), icon.getIconHeight());
		//this.setSize(250, 600);
		this.setLocation(100, 100);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	// 好友列表
	private void initFriendList(String[] Friend) {
		for (int i = 1; i < Friend.length; i++) {
			String[] userInfo = Friend[i].split(",");
			// 好友的第一个盒子
			JPanel jp31 = new JPanel();
			jp31.setBorder(BorderFactory.createLineBorder(Color.gray));
			jp31.setSize(225, 80);
			jp31.setLocation(5, 5 + (i - 1) * 85);
			jp31.setBackground(null);
			jp31.setOpaque(false);
			jp31.setLayout(null);
			// 头像
			ImageIcon img = new ImageIcon("image//" + userInfo[4]);
			JLabel jl = new JLabel(img);
			// 头像框
			JPanel jp311 = new JPanel();
			// jp311.setBorder(BorderFactory.createLineBorder(Color.RED));
			jp311.setSize(80, 60);
			jp311.setLocation(10, 10);
			jp311.setBackground(null);
			jp311.setOpaque(false);
			jp311.add(jl);

			jp31.add(jp311);
			// 网名
			JLabel jl2 = new JLabel(userInfo[1]);
			// jl2.setBorder(BorderFactory.createLineBorder(Color.RED));
			jl2.setSize(60, 30);
			jl2.setLocation(120, 10);

			jp31.add(jl2);
			// 签名
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
	}

	// 群好友列表
	private void initCrowdList(String[] crowd) {
		for (int i = 0; i < crowd.length; i++) {
			String[] crowInfo = crowd[i].split(",");
			// 好友的第一个盒子
			JPanel jp31 = new JPanel();
			jp31.setBorder(BorderFactory.createLineBorder(Color.gray));
			jp31.setSize(225, 80);
			jp31.setLocation(5, 5 + i * 85);
			jp31.setBackground(null);
			jp31.setOpaque(false);
			jp31.setLayout(null);
			// 头像
			ImageIcon img = new ImageIcon("image//" + crowInfo[3]);
			JLabel jl = new JLabel(img);
			// 头像框
			JPanel jp311 = new JPanel();
			// jp311.setBorder(BorderFactory.createLineBorder(Color.RED));
			jp311.setSize(80, 60);
			jp311.setLocation(10, 10);
			jp311.setBackground(null);
			jp311.setOpaque(false);
			jp311.add(jl);

			jp31.add(jp311);
			// 网名
			JLabel jl2 = new JLabel(crowInfo[1]);
			// jl2.setBorder(BorderFactory.createLineBorder(Color.RED));
			jl2.setSize(60, 30);
			jl2.setLocation(120, 10);

			jp31.add(jl2);
			// 签名
			JTextField jtf2 = new JTextField(crowInfo[2]);
			// jtf2.setBorder(BorderFactory.createLineBorder(Color.RED));
			jtf2.setSize(100, 30);
			jtf2.setLocation(120, 40);

			jp31.add(jtf2);

			jp5.add(jp31);

		}
	}

	public static void main(String[] args) {
		MainView mv = new MainView();
		String usersStr = "1,zs,iamzs,gsl.png;2,ls,iamls,gsl.png;3,ww,iamww,gsl.png";

		String[] selfAndFriend = usersStr.split(";");

		mv.init(selfAndFriend);

	}
}
