package com.uek.whileTest;

import java.util.Scanner;

public class ForTest01 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		//需求：计算2000年1月1日到2008年1月1日相距多少天？
/*		int sum = 0;
		for(int i=2000;i<2008;i++) {
			//闰年：
			if(i % 4 == 0 && i % 100 != 100 || i % 400 == 0) {
				sum  += 366;
			}else {
				sum += 365;
			}
		}
		System.out.println(sum);*/
		
		//需求：计算用户输入的日期距离1900年1月1日相距多少天？
		//思路：1）年份    （闰年） 
		//				2) 月份     （闰年） 
		Scanner input = new Scanner(System.in);
		System.out.println("年份：");
		int year = input.nextInt();
		System.out.println("月份：");
		int month = input.nextInt();
		
		int sum = 0; //累加和
		//处理年份：
		for(int i=1900 ; i < year; i++) {
			//闰年：
			if(i % 4 == 0 && i % 100 != 100 || i % 400 == 0) {
				sum  += 366;
			}else {
				sum += 365;
			}
		}
		//月份：1 - 12
		for (int i = 1; i < month; i++) {
			//思路：大月，小月，二月
			if(i == 1 || i == 3 || i == 5 || i == 7 || i ==8 || i == 10 || i == 12) {
				sum += 31;
			}else if(i == 2) {
				//闰年：
				if(year % 4 == 0 && year % 100 != 100 || year % 400 == 0) {
					sum  += 29;
				}else {
					sum += 28;
				}
			}else {
				sum += 30;
			}
		}
		
		System.out.println("天数：" + sum);
		
	
	}
}
