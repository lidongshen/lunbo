package com.uek.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.uek.test.Client;

public class RegisterView extends JFrame {
	private JLabel jl1, jl2, jl3, jl4, jl5;
	private JTextField jt1, jt2, jt3;
	private JPasswordField jpw1, jpw2;
	private JButton jb1, jb2;

	public JTextField getJt1() {
		return jt1;
	}

	public void init() {
		jl1 = new JLabel("用户名", SwingConstants.CENTER);
		jl2 = new JLabel("密    码", SwingConstants.CENTER);
		jl3 = new JLabel("确认密码", SwingConstants.CENTER);
		jl4 = new JLabel("签名", SwingConstants.CENTER);
		jl5 = new JLabel("头像", SwingConstants.CENTER);

		jt1 = new JTextField(20);
		jt2 = new JTextField(20);
		jt3 = new JTextField(20);

		jpw1 = new JPasswordField(20);
		jpw2 = new JPasswordField(20);

		jb1 = new JButton("重置");
		jb2 = new JButton("注册");
		jb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 获取键盘输入
				String name = jt1.getText();
				String passWord = jpw1.getText();
				String repassWord = jpw2.getText();
				String qianMing = jt2.getText();
				String touxiang = jt3.getText();
				// 如果两次密码输入正确就输出
				if (passWord.equals(repassWord)) {
					try {
						PrintStream ps = new PrintStream(Client.selfSocket.getOutputStream());
						ps.println("1," + name + "," + passWord + "," + qianMing + "," + touxiang);
						ps.flush();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else {
					JOptionPane.showMessageDialog(null, "密码不一致");
				}
			}
		});
		this.setLayout(new GridLayout(6, 2));
		this.add(jl1);
		this.add(jt1);
		this.add(jl2);
		this.add(jpw1);
		this.add(jl3);
		this.add(jpw2);
		this.add(jl4);
		this.add(jt2);
		this.add(jl5);
		this.add(jt3);
		this.add(jb1);
		this.add(jb2);

		this.setTitle("注册界面");
		this.pack();
		this.setIconImage(new ImageIcon("image/qq.png").getImage());
		this.setLocationRelativeTo(null);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		RegisterView r = new RegisterView();
		r.init();
	}

}
