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

import com.uek.testIO和网络编程.v8.Client08;
import com.uek.utils.FrameUtils;

public class SearchView extends JFrame{

	private JPanel jp1 ,jp2;
	
	private JLabel jl;
	private JTextField jtf;
	private JButton jb1,jb2;
	
	
	private JTable jt;
	private JScrollPane jsp;//必须把jt放到jsp，表头才能显示
	
	
	public void init()
	{
		jp1 = new JPanel();
		jp2 = new JPanel();
		
		jl = new JLabel("请输入");
		jtf = new JTextField(20);
		jb1 = new JButton("搜好友");
		
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String searchKey = jtf.getText();
				
				
				String message = "3,"+searchKey;
				
				try {
					PrintStream ps = new PrintStream(Client08.selfSocket.getOutputStream());
					
					ps.println(message);
					ps.flush();
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		jb2 = new JButton("搜群");
				
		
		//Vector就类似与ArryList
		Vector<String> columnNames = new Vector<>();
		columnNames.add("id");
		columnNames.add("名字");
		columnNames.add("签名");
		columnNames.add("头像");
		
		Vector<Vector<String>> rows = new Vector<Vector<String>>();
		
		Vector<String> row1 = new Vector<>();
		row1.add("1");
		row1.add("zs");
		row1.add("iamzs");
		row1.add("1.jpg");
		
		Vector<String> row2 = new Vector<>();
		row2.add("2");
		row2.add("ls");
		row2.add("iamzs");
		row2.add("1.jpg");
		
		Vector<String> row3 = new Vector<>();
		row3.add("3");
		row3.add("ww");
		row3.add("iamzs");
		row3.add("1.jpg");
		
		rows.add(row1);
		rows.add(row2);
		rows.add(row3);
		
		
		
		
		jt = new JTable(rows, columnNames);
		jsp = new JScrollPane(jt);
		
		jp1.add(jl);
		jp1.add(jtf);
		jp1.add(jb1);
		jp1.add(jb2);
		
		this.add(BorderLayout.NORTH , jp1);
		
		
		jp2.add(jsp);
		
		this.add(jp2);
		
		this.setTitle("搜索界面");
		this.pack();
		this.setLocation(300, 300);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
	}
	
	
	
	
	public JPanel getJp2() {
		return jp2;
	}




	public static void main(String[] args) {
		SearchView sv = new SearchView();
		sv.init();
	
		
		FrameUtils.searchView = sv;
	}
	
	
}
