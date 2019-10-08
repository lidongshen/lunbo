package com.uek.view;

import javax.swing.JFrame;;

public class LoginView入门 {

	public static void main(String[] args) {
		
		//Frame是创建一个窗体界面
		JFrame jf = new JFrame();
		
		//是界面出现的相对位置 如果没有设置是出现在左上角 0 ，0 
		jf.setLocation(400, 400);
		
	    //界面的长宽
		jf.setSize(400, 400);
		
		//当点击右上角关闭按钮，线程结束 程序退出 否则只是不显示了 内存还在
		//如果能找到该jframe，调用setVisible(true)就又显示了
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//必须设置显示
		jf.setVisible(true);
		
		
	}
	
	
}
