package com.uek.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.uek.utils.FrameUtils;

public class MainView extends JFrame{
	
	private JPanel jp1 , jp2 ,jp3 ,jp4;
	
	private JPanel jp11;
	private JLabel jl11 ,jl12;
	private JTextField jtf11;
	
	private JButton jb41;
	
	public void init(String[] selfAndFriends)
	{
		String[] self = selfAndFriends[0].split(",");
		
		String name = self[1];
		String signature = self[2];
		String header = self[3];
		
		//设置JFrame的布局方式成为绝对布局 根据控件在容器中的location定位
		this.setLayout(null);
		
		jp1 = new JPanel();
		
		//给JPanel设置边框 用于调试
		jp1.setBorder(BorderFactory.createLineBorder(Color.RED));
		
		//设置宽度时候需要考虑border本身也有宽度
		jp1.setSize(235 , 100);
		//设置jp1在父容器也就是JFrame中的定位 左上角和父容器左上角的距离
		jp1.setLocation(5, 5);
		
		jp11 = new JPanel();
		jp11.setBorder(BorderFactory.createLineBorder(Color.RED));
		jp11.setSize(100 , 80);
		jp11.setLocation(10, 10);
		
		
		ImageIcon image = new ImageIcon("images//"+header);
		jl11 = new JLabel(image);
		
		jp11.add(jl11);
		
		jl12 = new JLabel(name);
		jl12.setBorder(BorderFactory.createLineBorder(Color.RED));
		jl12.setSize(60 , 30);
		jl12.setLocation(120, 20);
		
		jtf11 = new JTextField(signature);
		jtf11.setBorder(BorderFactory.createLineBorder(Color.RED));
		jtf11.setSize(100 , 30);
		jtf11.setLocation(120, 60);
		
		//设置jp1为绝对布局
		jp1.setLayout(null);
		jp1.add(jp11);
		jp1.add(jl12);
		jp1.add(jtf11);
		
		//jp1加到父容器之前把jp1的内容设置好
		this.add(jp1);
		
		jp2 = new JPanel();
		
		//给JPanel设置边框 用于调试
		jp2.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		//设置宽度时候需要考虑border本身也有宽度
		jp2.setSize(235 , 30);
		//设置jp1在父容器也就是JFrame中的定位 左上角和父容器左上角的距离
		jp2.setLocation(5, 110);
		
		this.add(jp2);
		
		
		jp3 = new JPanel();
		
		//给JPanel设置边框 用于调试
		jp3.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		
		//设置宽度时候需要考虑border本身也有宽度
		jp3.setSize(235 , 360);
		//设置jp1在父容器也就是JFrame中的定位 左上角和父容器左上角的距离
		jp3.setLocation(5, 145);
		
		
		jp3.setLayout(null);
		
		//初始化好友列表
		initFriendList(selfAndFriends);
		
		
		
		this.add(jp3);
		
		
		
		jp4 = new JPanel();
		
		//给JPanel设置边框 用于调试
		jp4.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		
		//设置宽度时候需要考虑border本身也有宽度
		jp4.setSize(235 , 50);
		//设置jp1在父容器也就是JFrame中的定位 左上角和父容器左上角的距离
		jp4.setLocation(5, 515);
		
		jb41 = new JButton("搜索");
		jb41.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				SearchView sv = new SearchView();
				sv.init();
				
				FrameUtils.searchView = sv;
				
				
			}
		});
		
		jp4.add(jb41);
		this.add(jp4);
		
		this.setTitle(name+"的主界面");
		this.setSize(250 , 600);
		this.setLocation(100, 100);
		//实际中可能点右上角的叉只是隐藏不是真正的关闭
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//调节大小
		this.setResizable(false);//re -size 
		this.setVisible(true);
	}


	/**
	 * 初始化好友列表
	 * @param friends
	 */
	private void initFriendList(String[] friends) {
		//jp3加入所有的好友
		for (int i = 1; i < friends.length; i++) {
			
			String[] userInfo = friends[i].split(",");
			
			JPanel jp31 = new JPanel();
			
			//jp31.setBorder(BorderFactory.createLineBorder(Color.RED));
			jp31.setSize(225 , 80);
			jp31.setLocation(5, 5 + (i-1)*85 );
			
			
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
			
			jp3.add(jp31);
			
		}
	}
	
	public JPanel getJp3() {
		return jp3;
	}


	public static void main(String[] args) {
		MainView mv = new MainView();
		
		String usersStr = "1,zs,iamzs,gsl.png;2,ls,iamls,gsl.png;3,ww,iamww,gsl.png";
		
		String[] selfAndFriends = usersStr.split(";");
		
		mv.init(selfAndFriends);
	}
	
}
