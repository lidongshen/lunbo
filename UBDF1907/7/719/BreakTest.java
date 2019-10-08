package com.uek.whileTest;

import java.util.Random;
import java.util.Scanner;

/**
 * 跳转语句：
 *
 */
public class BreakTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
/*		int i = 1;
		while(i <= 100) {
			if(i == 10) {
				break; //break后不能添加任何语句
				System.out.println("");
			}
		}*/
		
/*		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(j == 2) {
					break;
				}
				System.out.println(i+","+j);
			}
		}*/
		
//		int score = 90;
//		if (score > 90) {
//			break;        // break只能用在switch和循环结构中；
//		} else {
//			System.out.println("");
//		}
		
/*		int score1 = 90;
		do {
			if(score > 90) {
				break;
			}
		}while(score1 <= 100);
		*/
		
		// 需求：生成0-100之间的随机数，直到生成88终止，停止循环；
		// 提示：break ,   死循环
		//random类：
/*		for(;;) {
			
		}*/
//		Random random = new Random();
//		int num = 0; //节省内存空间
//		while(true) {
//			num = random.nextInt(101);
//			System.out.println(num);
//			if (num == 88) {
//				break;
//			}
//		}
		
		//需求: 100以内的数求和，求出累加和第一次大于20的当前数：
		// 1-累加-100 ,    和>20 循环终止，累加结果打印输出：和 + 数 > 20
/*		int sum = 0;
		for(int i=1;i<=100;i++) {
			sum += i;
			if (sum > 20) {
				System.out.println("当前数：" + i);
				break;
			}
		}
		System.out.println(sum);*/
		
		//需求：
		Scanner input = new Scanner(System.in);
		for(int i=1;i<=3;i++) {
			System.out.println("用户名：");
			String name = input.next();
			System.out.println("密码：");
			String password = input.next();
			if (name.equals("张无忌") && password.equals("888")) {
				System.out.println("登录成功！");
				break; //终止循环
			} else {
				if (i != 3) {
					System.out.println("还有"+(3-i)+"次");
				} else {
					System.out.println("跳出！");
				}
			}
		}
		
		
	}
}












