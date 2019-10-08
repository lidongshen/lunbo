package com.uek.test01;

import java.util.Scanner;

/**
 * 多分支结构练习：
 */
public class IfElseIfElseTest01 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		//需求：输入一个月份，然后打印出该月对应的天数
		// 注意：需要考虑闰月的情况：
/*		Scanner input = new Scanner(System.in);
		System.out.println("输入年份：");
		int year = input.nextInt();
		System.out.println("输入月份：");
		int month = input.nextInt();*/
		//业务逻辑：通过代码，你想实现什么功能
/*		if (month == 1) {
			System.out.println("31天");
		} else if(month == 2){
			//分两种情况处理：
			if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
				System.out.println("29天");
			} else {
				System.out.println("28天");
			}
		}else if(month == 11) {
			System.out.println("31天");
		}else {
			// 12月；
		}*/
		
		//优化：分支是可以嵌套的；
/*		if (month == 1 || month == 3 || month == 5) {
			System.out.println("31天");
		} else if(month == 2){
			//分两种情况处理：
			if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
				System.out.println("29天");
			} else {
				System.out.println("28天");
			}
		}else if(month < 1 || month > 12) {
			System.out.println("输入错误！");
		}else { //小月
			System.out.println("30天");
		}*/
		
		//需求：
		// 标识符重名；
		Scanner scan = new Scanner(System.in);
		System.out.println("输入分数：");
		int score = scan.nextInt();  // 90
		//业务逻辑：
		if (score == 100) {
			System.out.println("宝马！");
		} else if(score >= 80 ){
			System.out.println("手机！");
		}else if(score >= 60 ) {
			System.out.println("ipad");
		}/*else {
			System.out.println("没有!");
		}*/
		
//		score = 99;
//		if(score > 90) {}
//		if(score > 80) {}
	}
}










