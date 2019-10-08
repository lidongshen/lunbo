package com.uek.test;

import java.util.Random;
import java.util.Scanner;

public class Test控制台五子棋 {
	
	public static void main(String[] args) {
		
		//1 画棋盘
		String[][] chessPanel = new String[11][11];
		
		for (int i = 0; i < chessPanel.length; i++) {
			
			
			for (int j = 0; j < chessPanel.length; j++) {
				
				chessPanel[i][j] = "口";
				
			}
			
		}
		
		printChessPanel(chessPanel);
		
		Scanner sc = new Scanner(System.in);
		
		boolean flag = true;//标记是否已经分出输赢 继续下棋 
		
		
		while(flag)
		{
			System.out.println("请选手落子");
			
			//2 选手落子
			while(flag)
			{
				System.out.println("输入x坐标");
				int x = sc.nextInt();
				System.out.println("输入y坐标");
				int y = sc.nextInt();
				
				//下棋的位置已经有子了
				if(!chessPanel[x][y].equals("口"))
				{
					continue;
				}
				
				chessPanel[x][y] = "赢";
				printChessPanel(chessPanel);
				
				flag = judge(chessPanel);
				
				break;
			
				
			}
			
			//3 电脑落子
			
			
			Random rand = new Random();
			
			while(flag)
			{
				System.out.println("电脑落子");
				
				int x = rand.nextInt(chessPanel.length);
				int y = rand.nextInt(chessPanel.length);
				
				//下棋的位置已经有子了
				if(!chessPanel[x][y].equals("口"))
				{
					continue;
				}
				
				chessPanel[x][y] = "输";
				
				flag = judge(chessPanel);
				
				printChessPanel(chessPanel);
				
				break;
			}
		}
		
		
		//4 判断输赢
		
	}

	/**
	 * 打印棋盘
	 * @param chessPanel
	 */
	private static void printChessPanel(String[][] chessPanel) {
		for (String[] strings : chessPanel) {
			
			for (String string : strings) {
				
				System.out.print(string);
			}
			
			
			System.out.println();//换行
		}
	}

	/**
	 * 判断输赢
	 * @param chessPanel
	 */
	private static boolean judge(String[][] chessPanel) {
		
		//横向
		for (String[] strings : chessPanel) {
			
			String line = "";
			
			for (String string : strings) {
				
				line += string;//但是这里效率极低 因为字符串的不可变性
			}
			
			
			if(line.contains("赢赢赢赢赢"))
			{
				System.out.println("恭喜您获得胜利");
				
				return false;
			}
		}
		
		return true;
	}
}
