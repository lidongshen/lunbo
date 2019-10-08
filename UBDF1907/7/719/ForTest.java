package com.uek.whileTest;

import java.util.Scanner;

import java.util.Random;

/**
 * 循环结构：for
 * 语法：（执行顺序） 
 *      for(1.循环变量初始化 ; 2.循环条件 ; 4.迭代/步进){
 *      	   3.循环体（业务逻辑）；
 *      }
 */
public class ForTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
/*		
		//需求：1-100的累加：
		int sum = 0;
		for(int i = 1; i<=100; i++) {
			sum += i;
		}
		System.out.println(sum);
		
		//需求： 1-200之间，能被5整除的数字，要求每6个一行
		int count = 0;
		for(int i = 1; i <= 200;i++) {
			if (i % 5 == 0) {
				System.out.print(i + "\t");
				count++;
				if (count % 6 == 0) {
					System.out.println();
				}
			}
		}
		
		//需求：0 - 100 ，奇数和，偶数和
		int sum1 = 0;
		int sum2 = 0;
		for(int i=0;i<=100;i++) {
			if (i % 2 == 0) {
				sum1 += i;
			} else {
				sum2 += i;
			}
		}
		System.out.println(sum1+","+sum2);*/
		
		//需求：从键盘输入一个班5位同学的分数，然后求和；
/*		Scanner input = new Scanner(System.in);
		double sums = 0;
		int i=1; //注意：可以把循环变量体到外面
		// for(;;)  : 造成死循环：如果循环条件和循环变量的更新（迭代）都缺省时
		for(;;) { 
			System.out.println("输入第"+i+"同学的分数：");
			double score = input.nextDouble();
			sums += score;
		}*/
		
		//需求： 使用for(;;){}   使用 break : 循环终止；
		Scanner input = new Scanner(System.in);
		/*
		 * 思路：1)接收键盘：0-2
		 *                判断：如果是0-2，进行下面逻辑；
		 *                             如果不是，提示输入错误；
		 *             2）0-2 ： 
		 *                   情况：0 ：
		 *                               1 ：
		 *                               2 ： 
		 *            3）是否循环继续：键盘输入 ：y -->循环继续
		 *                                               输入不是 y ---> 循环结束：break                
		 */
		//死循环：
//		for(;;) {
//			System.out.println("请输入数字：");
//			int num = input.nextInt(); // 6
//			if (num >= 0 && num <= 2) {
//				/*if (num == 0) {
//					System.out.println("石头！");
//				} else if(num == 1){
//					System.out.println("剪刀！");
//				}else {
//					System.out.println("布！");
//				}*/
//				//注意：switch后跟表达式的数据类型
//				// switch结构比较适合，业务逻辑相对简单的多分支情况；
//				switch (num) {
//					//case后跟常量---> num值
//					case 0:
//						System.out.println("石头！");
//						break; // break : 结束一个分支
//					case 1:
//						System.out.println("剪刀！");
//						break;
//					case 2:
//						System.out.println("布！");
//						break;
//				}
//				//3)
//				System.out.println("是否继续？：");
//				String isFlag = input.next();
//				if (isFlag.equals("y") || isFlag.equals("Y")) { // 
//					System.out.println("继续！");
//				} else {
//					break;  // break : 终止循环（跳出循环）
//				}
//			}else {
//				System.out.println("如果不是，提示输入错误；");
//			}
//		}
		
		//需求：Java API  : random ：随机数类
		// static : 类方法（直接使用类名调用，如果没有static修饰，那么该方法必须要该类的对象调用）  
		//int：方法的返回值类型     nextInt()  方法名：
		//构建该类的对象：
		//语法：类名		对象名	=   new   构造方法();
		//注意：在java中，只有java.lang包下的类不需要导入，其它包下的类都提前导入包信息；
		//Random random = new Random();
		//调用普通方法语法：对象名.方法名();
		// nextInt() : int 类型范围内的随机数：正负21亿；
		//nextInt(数字) ： [0 - 数字)  :     [ 闭    ) 开
/*		int num = 0;
		for(int i=1;i<=30;i++) {
			num = random.nextInt(5);
			System.out.println(num); //
		} */
		
		Random random = new Random(); 
		for(int i=1;i<=10;i++) {
			int num = random.nextInt(3); 
			System.out.print(num+"\t");
			switch (num) {
			case 0:
				System.out.println("怕怕！");
				break;
			case 1:
				System.out.println("喜欢！");
				break;
			case 2:
				System.out.println("下酒菜！");
				break;
			}
		}
	}
}









