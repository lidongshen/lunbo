package com.uek.test.test点名册;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Test点名 {
	
	public static void main(String[] args) {
		
		String[] names = new String[] {"刘艳辉" , "原则杨" , "赵胜涛",};
		
		
		
		JFrame jf = new JFrame();
		
		
		JLabel jl = new JLabel();
		jl.setText("谁是幸运儿");
		
		jf.add(BorderLayout.SOUTH , jl);
		
		JButton jb = new JButton();
		jb.setText("抽奖");
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Random rand = new Random();
				int index = rand.nextInt(names.length);
				jl.setText(names[index]);
				
			}
		});
		
		
		jf.add(jb);
		
		
		jf.setTitle("抽取幸运儿");
		jf.setSize(400,400);
		jf.setLocation(300, 300);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		
		
	}
	
}
