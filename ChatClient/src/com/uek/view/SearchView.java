package com.uek.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.uek.test.Client;
import com.uek.utils.JframUtils;

public class SearchView extends JFrame {
	// 声明变量
	private JLabel jl1;
	private JButton jb1, jb2, jb3, jb4;
	private JPanel jp1, jp2;
	private JTextField jt1;

	private JTable jt;
	private JScrollPane jsp;

	// 设置方法
	public void setJt(JTable jt) {
		this.jt = jt;
	}

	public void init() {
		// 创建实例
		jl1 = new JLabel("搜索");
		jt1 = new JTextField(20);
		
		
		jb1 = new JButton("搜好友");
		jb1.addActionListener(new ActionListener() {
			// searchKey关键
			@Override
			public void actionPerformed(ActionEvent e) {
				String searchKey = jt1.getText();
				String returnMeseage = "3," + searchKey;
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
		jb2 = new JButton("搜群");
		jb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String searchKey = jt1.getText();
				String returnMeseage = "7," + searchKey;
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
		jb3 = new JButton("加好友");
		jb3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int index = jt.getSelectedRow();
				String friendId = (String) jt.getValueAt(index, 0);
				String selfId = Client.selfUser.getId() + "";
				String returnMeseage = "4," + selfId + "," + friendId;
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
		jb4 = new JButton("加群");
		jb4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 8,1,2
				int index = jt.getSelectedRow();
				String crowdId = (String) jt.getValueAt(index, 0);
				String selfId = Client.selfUser.getId() + "";
				String returnMsesage = "8," + selfId + "," + crowdId;
				PrintStream ps;
				try {
					ps = new PrintStream(Client.selfSocket.getOutputStream());
					ps.println(returnMsesage);
					ps.flush();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		jp1 = new JPanel();
		jp2 = new JPanel();
		// 设置集合
		Vector<String> columnNames = new Vector<>();
		columnNames.add("id");
		columnNames.add("name");
		columnNames.add("signature");
		columnNames.add("heared");

		Vector<Vector<String>> rows = new Vector<Vector<String>>();
		Vector<String> row1 = new Vector<>();
		// row1.add("1");
		// row1.add("zs");
		// row1.add("iamzs");
		// row1.add("1.jpg");
		//
		// Vector<String> row2 = new Vector<>();
		// row2.add("2");
		// row2.add("ls");
		// row2.add("iamzs");
		// row2.add("1.jpg");
		//
		// Vector<String> row3 = new Vector<>();
		// row3.add("3");
		// row3.add("ww");
		// row3.add("iamzs");
		// row3.add("1.jpg");

		rows.add(row1);

		jt = new JTable(rows, columnNames);
		jsp = new JScrollPane(jt);
		
		jp1.add(jl1);
		jp1.add(jt1);
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		jp1.add(jb4);

		jp2.add(jsp);
		
		this.add(BorderLayout.NORTH,jp1);
		this.add(jp2);
		
		this.setTitle("搜所界面");
		this.pack();
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(200, 200);
		this.setVisible(true);

	}

	public JPanel getJp2() {
		return jp2;
	}

	public static void main(String[] args) {
		SearchView searchView = new SearchView();
		searchView.init();
		JframUtils.searchView = searchView;
	}

}
