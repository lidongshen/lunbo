package com.uek.test01;

import java.util.Scanner;

/**
 * 循环结构： while
 */
public class WhileTest01 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		System.out.println("我最丑！");
		System.out.println("我最丑！");
		System.out.println("我最丑！");
		System.out.println("我最丑！");
		System.out.println("我最丑！");
		System.out.println("========================");
		
		//循环的四要素：
		//1. 循环变量初始化
/*		int i = 1;
		// 2. i <= 100 : 循环条件
		while(i <= 100) {
			//3. 循环语句
			System.out.println(i);
			//4. 循环变量更新 ,如果没有，造成死循环；
			//i++;
		}
		System.out.println(i);*/
		
/*		int i = 100;
		while(i <= 200) {
			//业务逻辑：
			if (i % 2 == 0) {
				System.out.print(i + "\t");
			}
			i++;
			
			System.out.print(i + "\t");
			//注意：迭代、步进，随着业务是可以改变的；
			i+=2; // i = i+2;     102   104
		}*/
		
/*		int num = 1;
		int sum = 0;
		while(num <= 100) {
			sum += num; 
			num++; 
		}
		System.out.println(sum);*/
		
		// 0 - 100  int类型
		// num 88
/*		int num = 0;
		while(num != 88) {
			num = (int)(Math.random() * 101);
			System.out.println(num);
		}*/
		
		//需求：
/*		int num = 100;
		int sum = 0;
		while(num <= 999) {
			if (num % 3 == 0 && num % 7 !=0) {
				System.out.println("num:" + num);
				sum += num;
			}
			num++;
		}
		System.out.println(sum);*/
		
		//需求：
/*		Scanner input = new Scanner(System.in);
		int i = 1;          // 个数
		int sum = 0; // 计数器
		while(i <= 10) {
			System.out.println("输入第"+i+"位学生年龄：");
			int age = input.nextInt();
			if(age > 18) {
				sum++;
			}
			i++; 
		}
		System.out.println(sum);*/
		
		//需求: 
		Scanner input = new Scanner(System.in);
		// 声明一个空字符串： "" ; 
		String name = "";
		while(!name.equals("q")) {
			System.out.println("输入名字：");
			name = input.next();
		}
	}
}











