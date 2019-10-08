package com.uek.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.uek.test.Client;

public class PrivateChatView extends JFrame{
	private JTextArea jta1,jta2;
	private JButton jb1,jb2;
	private JPanel jp1,jp2,jp3;
	
	
	public JTextArea getJta1() {
		return jta1;
	}

	public void setJta1(JTextArea jta1) {
		this.jta1 = jta1;
	}

	public void init(String id ,String name) {
		jta1 = new JTextArea();
		jta2 = new JTextArea();
		
		jb1 = new JButton("文件");
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				jfc.showOpenDialog(null);
				
				File file = jfc.getSelectedFile();
				String returnMeseage = "12,requset,"+Client.selfUser.getId()+","+id+","+file.getAbsolutePath();
				
				PrintStream ps;
				try {
					ps = new PrintStream(Client.selfSocket.getOutputStream());
					ps.println(returnMeseage);
					ps.flush();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		jb2 = new JButton("发送");
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String selfText = jta2.getText();
				String returnMeseage = "5,"+Client.selfUser.getId()+","+id+"," + selfText;
				try {
					PrintStream ps = new PrintStream(Client.selfSocket.getOutputStream());
					ps.println(returnMeseage);
					ps.flush();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		this.setLayout(null);
		jta1.setBorder(BorderFactory.createLineBorder(Color.gray));
		jta1.setSize(300, 200);
		jta1.setLocation(5, 5);
		this.add(jta1);
		
		jp1.setBorder(BorderFactory.createLineBorder(Color.gray));
		jp1.setSize(300,40);
		jp1.setLocation(5, 210);
		jp1.add(jb1);
		this.add(jp1);
		
		jta2.setBorder(BorderFactory.createLineBorder(Color.gray));
		jta2.setSize(300, 50);
		jta2.setLocation(5, 255);
		this.add(jta2);
		
		jp2.setBorder(BorderFactory.createLineBorder(Color.gray));
		jp2.setSize(300,40);
		jp2.setLocation(5, 310);
		jp2.add(jb2);
		this.add(jp2);
		
		//jp3.setBorder(BorderFactory.createLineBorder(Color.gray));
		jp3.setSize(160,360);
		jp3.setLocation(310,0);
		ImageIcon img = new ImageIcon("image/qqxiu.jpg" );
		JLabel jl = new JLabel(img);
		jp3.add(jl);
		this.add(jp3);
		
		this.setTitle(id+"-"+name+"的聊天界面");
		this.setSize(500, 400);
		this.setLocation(200, 200);
		this.setVisible(true);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	public static void main(String[] args) {
		PrivateChatView pcv = new PrivateChatView();
		pcv.init("1","zs");
	}
}
