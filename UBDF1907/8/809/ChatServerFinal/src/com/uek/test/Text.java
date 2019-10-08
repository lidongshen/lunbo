package com.uek.test;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
//1.jicheng
import javax.swing.JTextArea;
import javax.swing.border.Border;
class PrivateChatView extends JFrame{
	//2.shengming
	private JTextArea jta1,jta2;
	private JPanel jp1,jp2,jp3;
	private JButton jb1,jb2;
	
	//3.initfangfa 
	
	public void init() {
		
		jta1 = new JTextArea();
		jta2 = new JTextArea();
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		
		jb1 = new JButton("文件");
		jb2 = new JButton();
		
		//this  设置边框大小和位置
		this.setLayout(null);
		this.setTitle("私聊界面");
		this.setSize(500, 400);
		this.setLocation(200, 200);
		this.setVisible(true);
		
		jta1.setBorder(BorderFactory.createLineBorder(Color.RED));
		jta1.setSize(300,200);
		jta1.setLocation(5, 5);
		this.add(jta1);
		
		jp1.setBorder(BorderFactory.createLineBorder(Color.RED));
		jp1.setSize(300,40);
		jp1.setLocation(5, 210);
		jp1.add(jb1);
		this.add(jp1);
		
		
	}
	
}

public class Text {
	public static void main(String[] args) {
		PrivateChatView pc= new PrivateChatView();
		pc.init();
	}
}
