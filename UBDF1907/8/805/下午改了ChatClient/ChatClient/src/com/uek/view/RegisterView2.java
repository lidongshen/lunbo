package com.uek.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


//1 extends JFrame
public class RegisterView2 extends JFrame{
	
	
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
				
				
				//接收界面的输入
				String name = jtf1.getText();
				String password = jpf1.getText();
				String repassword = jpf2.getText();
				
				if(password.equals(repassword))
				{
					String signature = jtf2.getText();
					String header = jtf3.getText();
					
					
					
					try {
						//1 加载驱动类 //2 用驱动管理器注册驱动
						Class.forName("com.mysql.jdbc.Driver");
						
						//3 用驱动管理器去获取数据库连接 建立java程序和数据库的桥梁
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_chat", "root", "root");
						//4 用连接准备一个工具 小推车
						Statement stat = conn.createStatement();
						
						//5 准备sql语句
						String sql = "insert into t_user(name,password,signature,header) values('"+name+"','"+password+"','"+signature+"','"+header+"')";
						//6 工具执行sql 小推车把sql推到数据库执行
						
						stat.executeUpdate(sql);
						
						//7 关闭资源
						stat.close();
						conn.close();
						
						//第一个参数是弹出框的相对位置 设置null先
						JOptionPane.showMessageDialog(null, "添加成功！");
						
						RegisterView2.this.setVisible(false);
						
						new LoginView().init();
						
					} catch (Exception ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}
				}else
				{
					//第一个参数是弹出框的相对位置 设置null先
					JOptionPane.showMessageDialog(null, "2次密码不一致");
				}
				
				
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
		
		
		RegisterView2 rv = new RegisterView2();
		rv.init();
		
		
		System.out.println(rv.getJtf1().getText());
	}
	
	
	
	
}
