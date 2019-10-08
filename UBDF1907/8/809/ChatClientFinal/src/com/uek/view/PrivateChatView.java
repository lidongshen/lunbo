package com.uek.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.uek.testIO和网络编程.v8.Client08;

public class PrivateChatView extends JFrame{

	private JTextArea jta1 , jta2;
	private JPanel jp1 , jp2 ,jp3;
	private JButton jb1 , jb2;
	

	public void init(int id , String name)
	{
		jta1 = new JTextArea();
		jta2 = new JTextArea();
		
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		
		
		jb1 = new JButton("文件");
		
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser jfc =  new JFileChooser();
				jfc.showOpenDialog(null);
				
				File file = jfc.getSelectedFile();
				
				String protoMessage = "20,request,"+Client08.selfUser.getId()+","+id+","+file.getAbsolutePath();
				
				
				PrintStream ps;
				try {
					ps = new PrintStream(Client08.selfSocket.getOutputStream());
					ps.println(protoMessage);
					ps.flush();
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		jb2 = new JButton("发送");
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//获取聊天框的数据
				String content = jta2.getText();
				
				//根据协议拼接要给服务器发送的字符串
				String message = "5,"+Client08.selfUser.getId()+","+id+","+content;
			
				try {
					PrintStream ps = new PrintStream(Client08.selfSocket.getOutputStream());
					
					ps.println(message);
					ps.flush();
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		
		
		jta1.setBorder(BorderFactory.createLineBorder(Color.RED));
		
		jta1.setSize(300 , 200);
		jta1.setLocation(5,5);
		
		this.add(jta1);
		
		jp1.setBorder(BorderFactory.createLineBorder(Color.RED));
		
		jp1.setSize(300 , 40);
		jp1.setLocation(5,210);
		
		jp1.add(jb1);
		
		this.add(jp1);
		
		
		jta2.setBorder(BorderFactory.createLineBorder(Color.RED));
		
		jta2.setSize(300 , 60);
		jta2.setLocation(5,255);
		
		this.add(jta2);
		
		jp2.setBorder(BorderFactory.createLineBorder(Color.RED));
		
		jp2.setSize(300 , 40);
		jp2.setLocation(5,320);
		jp2.add(jb2);
		
		this.add(jp2);
		
		
		jp3.setBorder(BorderFactory.createLineBorder(Color.RED));
		
		jp3.setSize(170 , 355);
		jp3.setLocation(310,5);
		
		this.add(jp3);
		
		this.setLayout(null);
		this.setTitle("和"+id+"-"+name+"的聊天窗口");
		this.setSize(500,400);
		this.setLocation(200,200);//居中了
		this.setVisible(true);
	}
	
	
	
	public JTextArea getJta1() {
		return jta1;
	}



	public void setJta1(JTextArea jta1) {
		this.jta1 = jta1;
	}



	public static void main(String[] args) {
		PrivateChatView pv = new PrivateChatView();
		pv.init(1,"zs");
	}
	
}
