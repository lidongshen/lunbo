package com.uek.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



/**
 * 
 * @author UEK-N
 *
 */
public class LoginView2{
	

	public static void main(String[] args) {
		
		JFrame jf = new JFrame();

		//JLable是只顯示
		JLabel jl1 , jl2;
		
		JTextField jtf;
		JPasswordField jpf;
		
		JButton jb1 , jb2;
		
		//这个是面板 是把一个JFrame可以划分为多个区域 面板
		//不能独立显示
		JPanel jp1 , jp2 , jp3;
		

		jl1 = new JLabel("用户名");
		jl2 = new JLabel("密  码");
		
		
		jtf = new JTextField(20);
		jpf = new JPasswordField(20);
		
		jb1 = new JButton("注册");
		jb2 = new JButton("登录");
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
			
			
		jf.add(jb1);//jf是界面 jb1是按钮 ，add是增加 也就是把按钮加到界面
		  //从面相对象的角度把按钮加到控件要你实现的话，你会定义
		  //几个类，几个方法？
			
		  //jf 如果是方法中的jf，是调用方法的对象
		  //jf 如果是构造器中的jf，是正在初始化的对象
		
		//面板的默认的布局方式是FlowLayout 加控件加到中间 往俩边
		jp1.add(jl1);jp1.add(jtf);
		jp2.add(jl2);jp2.add(jpf);
		jp3.add(jb1);jp3.add(jb2);
		
		
		
		//JFrame默认的布局方式是BorderLayout 
		//上下左右中 并且如果别的区域没有，可以被周围的控件占用
		jf.add(BorderLayout.NORTH , jp1);
		jf.add(jp2);
		jf.add(BorderLayout.SOUTH ,jp3);
		
		
		jf.setTitle("登录界面");
		jf.setSize(400, 200);
		jf.setLocation(300, 300);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);

			
		
	}
	
}
