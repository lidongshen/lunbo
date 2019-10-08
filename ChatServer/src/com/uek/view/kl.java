package com.uek.view;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javafx.scene.layout.Border;

public class kl extends JFrame {

	
	
}

class TestScroll {
	public TestScroll() {
		JFrame jf = new JFrame("test");
		JPanel jp = new JPanel();
		JTextArea jta = new JTextArea(8, 20);
		JScrollPane jsp = new JScrollPane(jta);// 新建一个滚动条界面，将文本框传入
		jp.add(jsp);// 注意：将滚动条界面添加到组建中，而不是添加文本框了
		jf.add(jp);

		jf.pack();
		jf.setLocation(300, 300);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new TestScroll();
	}
}