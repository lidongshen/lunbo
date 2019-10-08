package com.uek.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import com.uek.test.Client;

public class CrowdChatView extends JFrame {

	private JTextArea jta1, jta2;
	private JButton jb1, jb2;
	private JPanel jp1, jp2, jp3;

	public JTextArea getJta1() {
		return jta1;
	}

	public void setJta1(JTextArea jta1) {
		this.jta1 = jta1;
	}

	public void init(String crowdId, String[] crowdMembers) {
		jta1 = new JTextArea();
		jta2 = new JTextArea();

		jb1 = new JButton("文件");
		jb2 = new JButton("发送");
		jb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String selfText = jta2.getText();
				String returnMeseage = "11," + Client.selfUser.getId() + "," + crowdId + "," + selfText;
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

		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		this.setLayout(null);
		jta1.setBorder(BorderFactory.createLineBorder(Color.gray));
		jta1.setSize(300, 200);
		jta1.setLocation(5, 5);
		this.add(jta1);

		jp1.setBorder(BorderFactory.createLineBorder(Color.gray));
		jp1.setSize(300, 40);
		jp1.setLocation(5, 210);
		jp1.add(jb1);
		this.add(jp1);

		jta2.setBorder(BorderFactory.createLineBorder(Color.gray));
		jta2.setSize(300, 50);
		jta2.setLocation(5, 255);
		this.add(jta2);

		jp2.setBorder(BorderFactory.createLineBorder(Color.gray));
		jp2.setSize(300, 40);
		jp2.setLocation(5, 310);
		jp2.add(jb2);
		this.add(jp2);

		jp3.setBorder(BorderFactory.createLineBorder(Color.gray));
		jp3.setSize(160, 345);
		jp3.setLocation(310, 5);
		jp3.setLayout(null);
		initCrowdMemberList(crowdMembers);
		this.add(jp3);

		this.setTitle( crowdId+ "群的聊天界面");
		this.setSize(500, 400);
		this.setLocation(200, 200);
		this.setVisible(true);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void initCrowdMemberList(String[] crowdMembers) {
		for (int i = 0; i < crowdMembers.length; i++) {
			//1,q1,qm,gsl.png;2,q1,qm,gsl.png;
			String[] crowInfo = crowdMembers[i].split(",");
			// 好友的第一个盒子
			JPanel jp31 = new JPanel();
			jp31.setBorder(BorderFactory.createLineBorder(Color.gray));
			jp31.setSize(150, 80);
			jp31.setLocation(5, 5 + i * 85);

			jp31.setLayout(null);
			// 头像
			ImageIcon img = new ImageIcon("image//" + crowInfo[3]);
			JLabel jl = new JLabel(img);
			// 头像框
			JPanel jp311 = new JPanel();
			// jp311.setBorder(BorderFactory.createLineBorder(Color.RED));
			jp311.setSize(80, 60);
			jp311.setLocation(10, 10);

			jp311.add(jl);

			jp31.add(jp311);
			// 网名
			JLabel jl2 = new JLabel(crowInfo[1]);
			// jl2.setBorder(BorderFactory.createLineBorder(Color.RED));
			jl2.setSize(40, 30);
			jl2.setLocation(100, 10);

			jp31.add(jl2);
			// 签名
			JTextField jtf2 = new JTextField(crowInfo[2]);
			// jtf2.setBorder(BorderFactory.createLineBorder(Color.RED));
			jtf2.setSize(40, 30);
			jtf2.setLocation(100, 40);

			jp31.add(jtf2);
			jp3.add(jp31);
			
		}
	}
	
	
}
