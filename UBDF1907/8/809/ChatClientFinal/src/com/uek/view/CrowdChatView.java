package com.uek.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.PrintStream;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.uek.testIO和网络编程.v8.Client08;
import com.uek.utils.FrameUtils;

public class CrowdChatView extends JFrame{

	private JTextArea jta1 , jta2;
	private JPanel jp1 , jp2 ,jp3;
	private JButton jb1 , jb2;
	

	public void init(String crowdId , String[] crowdMembers)
	{
		jta1 = new JTextArea();
		jta2 = new JTextArea();
		
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		
		
		jb1 = new JButton("文件");
		jb2 = new JButton("发送");
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String chatContent = jta2.getText();
				
				String message = "11,"+Client08.selfUser.getId()+","+crowdId+","+ chatContent;
				
				try {
					PrintStream ps = new PrintStream(Client08.selfSocket.getOutputStream());
					ps.println(message);
					ps.flush();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		
		
		jta1.setBorder(BorderFactory.createLineBorder(Color.RED));
		
		jta1.setSize(300 , 200);
		jta1.setLocation(5,5);
		
		this.add(jta1);
		
		jp1.setBorder(BorderFactory.createLineBorder(Color.RED));
		
		jp1.setSize(300 , 40);
		jp1.setLocation(5,210);
		
		jp1.add(jb1);
		
		this.add(jp1);
		
		
		jta2.setBorder(BorderFactory.createLineBorder(Color.RED));
		
		jta2.setSize(300 , 60);
		jta2.setLocation(5,255);
		
		this.add(jta2);
		
		jp2.setBorder(BorderFactory.createLineBorder(Color.RED));
		
		jp2.setSize(300 , 40);
		jp2.setLocation(5,320);
		jp2.add(jb2);
		
		this.add(jp2);
		
		
		jp3.setBorder(BorderFactory.createLineBorder(Color.RED));
		
		jp3.setSize(170 , 355);
		jp3.setLocation(310,5);
		
		jp3.setLayout(null);
		
		//String[] crowdMembers = new String[] {"1,zs,zsqm,gsl.png","1,ls,lsqm,gsl.png"};
		initCrowdMemberList(crowdMembers);
		
		this.add(jp3);
		
		this.setLayout(null);
		this.setTitle(crowdId+"的聊天窗口");
		this.setSize(500,400);
		this.setLocation(200,200);//居中了
		this.setVisible(true);
	}
	
	/**
	 * 初始化群成员列表
	 * @param crowdMembers
	 */
	private void initCrowdMemberList(String[] crowdMembers) {
		
		//jp3加入所有的好友
		for (int i = 0; i < crowdMembers.length; i++) {
			
			String[] userInfo = crowdMembers[i].split(",");
			
			JPanel jp31 = new JPanel();
			
			//jp31.setBorder(BorderFactory.createLineBorder(Color.RED));
			jp31.setSize(225 , 80);
			jp31.setLocation(5, 5 + i*85 );
			
			
			jp31.setLayout(null);
			
			
			ImageIcon img = new ImageIcon("images/"+userInfo[3]);
			JLabel jl = new JLabel(img);
			
			JPanel jp311 = new JPanel();
			//jp311.setBorder(BorderFactory.createLineBorder(Color.RED));
			jp311.setSize(80 , 60);
			jp311.setLocation(10, 10);
			
			jp311.add(jl);
			
			jp31.add(jp311);
			
			
		
			
			JLabel jl2 = new JLabel(userInfo[1]);
			//jl2.setBorder(BorderFactory.createLineBorder(Color.RED));
			jl2.setSize(60 , 30);
			jl2.setLocation(120, 10);
			
			jp31.add(jl2);
			
			JTextField jtf2 = new JTextField(userInfo[2]);
			//jtf2.setBorder(BorderFactory.createLineBorder(Color.RED));
			jtf2.setSize(100 , 30);
			jtf2.setLocation(120, 40);
			
			jp31.add(jtf2);
			
			//不去newMouseLinstener接口而是new一个实现了该接口的MouseAdapter
			//只需要覆盖你想要覆盖的方法，别的不用管
			jp31.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseClicked(MouseEvent e) {
					
					int friendId = Integer.parseInt(userInfo[0]);
					
					//如果缓存的好友聊天界面中有
					if(FrameUtils.friendIdAndPrivateChatViews.get(friendId) != null)
					{
						//显示
						FrameUtils.friendIdAndPrivateChatViews.get(friendId).setVisible(true);
					}else//如果缓存的好友聊天界面中没有
					{
						//新建并显示并缓存
						PrivateChatView pv = new PrivateChatView();
						pv.init(friendId, userInfo[1]);
						
						//打开一个好友聊天界面需要缓存到我的聊天界面中
						
						FrameUtils.friendIdAndPrivateChatViews.put(friendId, pv);
					}
					
				
				}
					
				
			});
			
			jp3.add(jp31);
			
		}
	}
	
	
	public JTextArea getJta1() {
		return jta1;
	}



	public void setJta1(JTextArea jta1) {
		this.jta1 = jta1;
	}



	public static void main(String[] args) {
		CrowdChatView pv = new CrowdChatView();
		//pv.init("zs");
	}
	
}
