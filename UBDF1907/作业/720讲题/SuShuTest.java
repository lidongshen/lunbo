package com.uek.homeWork;

import java.util.Scanner;

/**
 * 判断输入的数，是否为素数：
 *
 */
public class SuShuTest {
	public static void main(String[] args) {
		
/*		Scanner input = new Scanner(System.in);
		System.out.println("请输入一个数:");
		int num = input.nextInt();
		//标记变量：控制状态
		boolean flag = true; // num为素数的情况
		
		if (num == 0 || num == 1) {
			System.out.println(num + "不是素数；");
		} else {
			//num = 1   自身  num % 
			//  
			for(int i=2;i<num;i++) {
				//不是素数：
				if (num % i == 0) {
					flag = false;  //改变状态
					break;
				}
			}
			
			if (flag) {
				System.out.println(num + "是素数！");
			} else {
				System.out.println(num + "不是素数！");
			}
		}*/
		
		for(int i=101;i<=150;i++) {
			boolean flag = true;
			for(int j=2;j<i;j++) {
				//不是素数：
				if (i % j == 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				System.out.println(i + "是素数！");
			} 
		}
	}
}














