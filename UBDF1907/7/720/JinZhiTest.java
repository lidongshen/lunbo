package com.uek.homeWork;

import java.util.Scanner;

/**
 * 从键盘输入某个十进制整数数，转换成对应的二进制整数并输出。
 * 十进制 ---> 八进制
 */
public class JinZhiTest {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("输入十进制数：");
		int num = input.nextInt();
		//思路：循环---取余,  商---取余：
		//            循环结束 ： 商= 0；
		//商
		int temp1 = 0;
		//余数：
		int temp2 = 0;
		//字符串：字符串拼接 ： 
		String str = "";
		do {
			temp1 = num / 2;
			temp2 = num % 2;
			str = temp2 + str;  // 1 + "0" ="10"
			//重新赋值：上一次计算的结果（商）赋值给num
			num = temp1;
		}while(temp1 != 0);
		System.out.println(num+"--->"+str);
	}
}
