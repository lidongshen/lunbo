package com.uek.whileTest;

public class WhileTest01 {
	public static void main(String[] args) {
		
		//需求：打印输出1-100之间能被5整除的数字，要求每3个一行；
		//1. 循环变量的初始化：
/*		int i = 1;
		int count = 0;    //计数器
		//2. 循环条件
		while(i <= 100) {
			//3. 循环体：业务逻辑
			if(i % 5 == 0) {
				System.out.print(i + "\t");
				count++; //每找到一个能被5整除的数，就计数加1；
				if(count % 3 == 0) { //
					System.out.println(); //换行
				}
			}
			//4. 步进、迭代：
			i++;
		}*/
		
		int i = 1;
		//2. 循环条件
		while(i <= 100) {
			//3. 循环体：业务逻辑
			if(i % 5 == 0) {
				System.out.print(i + "\t");
				if(i % 3 == 0) { //   3      15
					System.out.println(); //换行
				}
			}
			//4. 步进、迭代：
			i++;
		}
		
		
		
	}
}
