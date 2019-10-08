package com.uek.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


//1 extends JFrame
public class RegisterView extends JFrame{
	
	
	//2 声明控件
	private JLabel jl1 , jl2 ,jl3 ,jl4,jl5;
	private JTextField jtf1 ,jtf2 , jtf3;
	private JPasswordField jpf1 ,jpf2;
	
	private JButton jb1 , jb2;
	
	
	//3 init方法  new 控件 设置控件的布局 相互的位置和包含
	public void init()
	{
		JLabel jl1 = new JLabel("用户名");
		jl2 = new JLabel("密码");
		jl3 = new JLabel("确认密码");
		jl4 = new JLabel("签名");
		jl5 = new JLabel("头像");
		
		jtf1 = new JTextField(20);
		jtf1.setText("默认文本!");
		
		jtf2 = new JTextField(20);
		jtf3 = new JTextField(20);
		
		
		jpf1 = new JPasswordField(20);
		jpf2 = new JPasswordField(20);
		
		jb1 = new JButton("重置");
		jb2 = new JButton("注册");
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				RegisterView.this.setVisible(false);
				
				new MainView().init();
			}
		});

		//改变JFrame默认的布局方式BordeLayout成为表格布局 GridLayout
		this.setLayout(new GridLayout(6,2));
		
		//从左往右 从上往下
		this.add(jl1);this.add(jtf1);
		this.add(jl2);this.add(jpf1);
		this.add(jl3);this.add(jpf2);
		this.add(jl4);this.add(jtf2);
		this.add(jl5);this.add(jtf3);
		
		this.add(jb1);this.add(jb2);
		
		this.setTitle("注册页面");
		//自动打包 包裹 取代setSize pack是给一个合适的长宽
		this.pack();
		
		
		this.setLocation(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	
	public JTextField getJtf1() {
		return jtf1;
	}



	public static void main(String[] args) {
		
		
		RegisterView rv = new RegisterView();
		rv.init();
		
		
		System.out.println(rv.getJtf1().getText());
	}
	
	
	
	
}
