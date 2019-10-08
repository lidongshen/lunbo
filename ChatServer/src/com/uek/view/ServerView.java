package com.uek.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import com.uek.test.Server;

public class ServerView extends JFrame{
	private JTabbedPane jtp;
	private JTextArea jt1,jt2;
	private JButton jb1,jb2;
	private JPanel jp1,jp2;
	
	public JTextArea getJt2() {
		return jt2;
	}
	public void init() {
		
		jtp = new JTabbedPane();
		jt1 = new JTextArea();
		jt2 = new JTextArea();
		jb1 = new JButton("发送系统消息");
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String chat = jt1.getText();
				String returnMeseage = "100," + chat;
				for (Socket socket : Server.userAndFriend.values()) {
					try {
						PrintStream ps = new PrintStream(socket.getOutputStream());
						ps.println(returnMeseage);
						ps.flush();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		jb2 = new JButton("保存到本地");
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				File file = new File("monitor.txt");
				try {
					FileOutputStream fos = new FileOutputStream(file);
					String content = jt2.getText();
					
					byte[] bytes= content.getBytes();
					
					//把字节数组写到fos，fos关联到的是monitor.txt
					fos.write(bytes);
						
					fos.close();
				
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		jp1 = new JPanel();
		jp2 = new JPanel();
		
		jp1.setLayout(null);
		
		jt1.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		jt1.setSize(470,290);
		jt1.setLocation(5, 5);
		jp1.add(jt1);
		
		jb1.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		jb1.setSize(470,30);
		jb1.setLocation(5, 300);
		jp1.add(jb1);
		
		jtp.addTab("系统消息",jp1);
		
		jp2.setLayout(null);
		jt2.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		jt2.setSize(470,290);
		jt2.setLocation(5, 5);
		jp2.add(jt2);
		
		jb2.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		jb2.setSize(470,30);
		jb2.setLocation(5, 300);
		jp2.add(jb2);
		jtp.addTab("监控", jp2);
		
		this.add(jtp);
		
		
		this.setTitle("服务器端界面");
		this.setSize(500, 400);
		this.setLocation(200, 200);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		ServerView sv = new ServerView();
		sv.init();
	}
}
