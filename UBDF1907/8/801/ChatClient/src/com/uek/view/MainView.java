package com.uek.view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainView extends JFrame{
	
	private JPanel jp1 , jp2 ,jp3 ,jp4;
	
	private JPanel jp11;
	private JLabel jl11;
	private JTextField jtf11;
	
	private JButton jb41;
	
	public void init()
	{
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
		
		jl11 = new JLabel("令狐冲");
		jl11.setBorder(BorderFactory.createLineBorder(Color.RED));
		jl11.setSize(60 , 30);
		jl11.setLocation(120, 20);
		
		jtf11 = new JTextField("令狐冲");
		jtf11.setBorder(BorderFactory.createLineBorder(Color.RED));
		jtf11.setSize(100 , 30);
		jtf11.setLocation(120, 60);
		
		//设置jp1为绝对布局
		jp1.setLayout(null);
		jp1.add(jp11);
		jp1.add(jl11);
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
		
		this.add(jp3);
		
		
		
		jp4 = new JPanel();
		
		//给JPanel设置边框 用于调试
		jp4.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		
		//设置宽度时候需要考虑border本身也有宽度
		jp4.setSize(235 , 50);
		//设置jp1在父容器也就是JFrame中的定位 左上角和父容器左上角的距离
		jp4.setLocation(5, 515);
		
		jb41 = new JButton("搜索");
		jp4.add(jb41);
		this.add(jp4);
		
		this.setTitle("xxx的主界面");
		this.setSize(250 , 600);
		this.setLocation(100, 100);
		//实际中可能点右上角的叉只是隐藏不是真正的关闭
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//调节大小
		this.setResizable(false);//re -size 
		this.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		MainView mv = new MainView();
		mv.init();
	}
	
}
