package com.uek.whileTest;

import java.util.Scanner;

/**
 * 循环结构：doWhile
 *语法：
 *   循环变量初始化；
 *   do{
 *      循环体（业务逻辑）；
 *      迭代、步进；
 *   }while(循环条件);
 */
public class DoWhileTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		//打印输出1-100能被3整除的数字, 5个一行
/*		int i = 1;
		int count = 0;
		do {
			if(i % 3 == 0) {
				System.out.print(i+"\t");
				count++;
				if(count % 5 ==0) {
					System.out.println();
				}
			}
			i++;
		}while(i <= 100);*/
		
		/**
		 * dowhile结构特点：
		 * 		在程序执行的过程中，之上而下顺序执行，先执行一次循环体，
		 * 然后再进行循环条件的判断。
		 * 		循环至少执行一次；
		 */
/*		int a = 0;
		//不满足循环条件，所以不执行循环；
		while(a < 0) {
			System.out.println(a);
			a++;
		}*/
		
/*		int a = 0;
		do {
			System.out.println(a);
			a++;
		}while(a < 0);*/
		
		//需求：打印输出1-100之间数字的累加和；
/*		int i = 1;
		int sum = 0;
		do {
			sum += i;//sum = sum + i;
			i++;
		}while(i <= 100);
		System.out.println(sum);*/
		
		//需求： 打印输出1-100之间奇数和偶数各自的累加和；
/*		int i = 1;
		int sum1 = 0;
		int sum2 = 0;
		do {
			//判断：
			if (i % 2 != 0) {
				sum1 += i;
			} else {
				sum2 += i;
			}
			i++;
		}while(i <= 100);
		System.out.println(sum1 +","+ sum2);*/
		
		//需求：不断输入名字，直到输入exit 或 q 时停止；
/*		Scanner input = new Scanner(System.in);
		String name = "";
		do {
			System.out.println("输入名字：");
			name = input.next();
			// 如果名字不是exit ，同时名字不是q时，
			// 只要名字是exit , 或者是q,  循环终止； 
			// && :  如果第一个操作数是true时，还需判断第二个操作数
			//            如果第一个操作数是false时,就不需要判断第二个操作数
			//                true                                                 false
		}while(!name.equals("exit") && !name.equals("q"));*/
		
		//需求：统计1-200之间能被5整除但不能被3整除的数字的个数；
/*		int i = 1;
		int sum = 0;
		do {
			if (i % 5 ==0 && i % 3 != 0) {
				System.out.print(i+"\t");
				sum++;
			}
			i++;
		}while(i <= 200);
		System.out.println("个数：" + sum);*/
		
		//需求：
		Scanner input = new Scanner(System.in);
		String mai = "";// 买  不同意
		do {
			System.out.println("老婆问，可以购物吗？");
			mai = input.next();
			if(mai.equals("买")) {
				System.out.println("老婆疯狂购物！");
			}
		}while(mai.equals("买")); 
	}
}









