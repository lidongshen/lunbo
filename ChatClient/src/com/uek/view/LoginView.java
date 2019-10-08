package com.uek.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.uek.test.Client;
import com.uek.utils.JframUtils;

public class LoginView extends JFrame {
	private JLabel jl1, jl2;
	private JTextField jt1;
	private JPasswordField jpw1;
	private JButton jb1, jb2;
	private JPanel jp1, jp2, jp3;

	public JTextField getJt1() {
		return jt1;
	}

	public void init() {

		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();

		jl1 = new JLabel("用户名");
		jl2 = new JLabel("密    码");

		jpw1 = new JPasswordField(20);
		jt1 = new JTextField(20);

		jb1 = new JButton("登录");
		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = jt1.getText();
				String password = jpw1.getText();
				String meseage = "2," + name + "," + password;
				PrintStream ps;
				try {
					ps = new PrintStream(Client.selfSocket.getOutputStream());
					ps.println(meseage);
					ps.flush();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		jb2 = new JButton("注册");
		jb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JframUtils.loginView.setVisible(false);
				RegisterView registerView = new RegisterView();
				registerView.init();
				JframUtils.registerView = registerView;

			}
		});

		jp1.add(jl1);
		jp1.add(jt1);
		jp2.add(jl2);
		jp2.add(jpw1);
		jp3.add(jb1);
		jp3.add(jb2);

		this.add(BorderLayout.NORTH, jp1);
		this.add(jp2);
		this.add(BorderLayout.SOUTH, jp3);

		this.setTitle("登录界面");
		this.setSize(400, 200);
		this.setIconImage(new ImageIcon("image/qq.png").getImage());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		LoginView l = new LoginView();
		l.init();
	}
}
