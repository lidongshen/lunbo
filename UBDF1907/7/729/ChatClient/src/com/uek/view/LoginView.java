package com.uek.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;




/**
 * 最佳实践
 * 
 * 1 当前类继承JFrame类 成为一个界面类 
 * 		extends 目的不是为了复用代码 而是确实存在is a的关系
 * 
 * 2 所有的控件声明到成员变量 private
 * 3 写一个init方法 用来初始化成员控件，并且设置界面的常用信息
 *   最后显示界面
 * 
 * @author UEK-N
 * 
 * class ITTeacher extends Teacher 
 * 
 * 大部分class包含静态特征和动态特征
 * 
 * field
 * 
 * method
 * 
 */
public class LoginView extends JFrame{
	
	
	//JLable是只顯示
	private JLabel jl1 , jl2;
	
	private JTextField jtf;
	private JPasswordField jpf;
	
	private JButton jb1 , jb2;
	
	//这个是面板 是把一个JFrame可以划分为多个区域 面板
	//不能独立显示
	private JPanel jp1 , jp2 , jp3;
	
	public void init()
	{
		jl1 = new JLabel("用户名");
		jl2 = new JLabel("密  码");
		
		
		jtf = new JTextField(20);
		jpf = new JPasswordField(20);
		
		jb1 = new JButton("注册");
		
		//给jb1这个按钮绑定一个事件监听器，监听jb1按钮的单击事件
		//jb1.addActionListener(new RegisterListener());
		
		//接口本来不可以new，所以以下的代码实际是new了一个实现了接口的类
		//但是这个类的名字被省略了，也就是匿名了，这就是java中著名的匿名内部类
		//语法就是 new 抽象类|接口(){}
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("匿名内部类的监听器。。。");
				
				System.out.println("输入的用户名"+jtf.getText());
				
				//匿名内部类中的this是匿名内部类的对象
				LoginView.this.setVisible(false);
				
				new RegisterView().init();
			}
		});
		
		jb2 = new JButton("登录");
		
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		
		//面板的默认的布局方式是FlowLayout 加控件加到中间 往俩边
		jp1.add(jl1);jp1.add(jtf);
		jp2.add(jl2);jp2.add(jpf);
		jp3.add(jb1);jp3.add(jb2);
		
		
		
		//JFrame默认的布局方式是BorderLayout 
		//上下左右中 并且如果别的区域没有，可以被周围的控件占用
		this.add(BorderLayout.NORTH , jp1);
		this.add(jp2);
		this.add(BorderLayout.SOUTH ,jp3);
		
		
		this.setTitle("登录界面");
		this.setSize(400, 200);
		this.setLocation(0, 0);
		this.setVisible(true);
		
		
	}
	
	//类的内部还可以定义类，就做内部类 内部类分为4种，但是常用的就是匿名内部类
	//内部u类的好处，可以方便的访问外部类的成员 包括private的成员
	//如果内部类只用一次，就是只是一个地方注册，那么定义成匿名内部类就很合适
	class RegisterListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			System.out.println("我被点击了");
			

			System.out.println("输入的用户名"+jtf.getText());
			
			LoginView.this.setVisible(false);
			
			new RegisterView().init();
			
		}
		
	}

	
	public static void main(String[] args) {
		
		
		LoginView lv = new LoginView();
		lv.init();
		
	}
	
}

//外部类不方便访问内部类的field method 对于图形用户界面GUI，内部类
//往往要操作界面的field，比如输入框，密码框等，外部类做不到
class RegisterListener implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e) {
		

//		System.out.println("输入的用户名"+jtf.getText());
		
		System.out.println("我被点击了");
		
		
	}
	
}
