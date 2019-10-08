package com.uek.test01;

import java.util.Scanner;

public class SwitchTest02 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		//需求：输入一个字符串：春 。。。 输入有误
		// 春意盎然 ，夏日炎炎 秋高气爽，冬雪皑皑   
/*		Scanner input = new Scanner(System.in);
		String season = input.next();
		switch (season) { // String
		case "春":
			System.out.println("");
			break;
		case "夏":
			System.out.println("");
			break;
		case "秋":
			System.out.println("");
			break;
		case "冬":
			System.out.println("");
			break;
		default:
			System.out.println("输入有误！");
			break;
		}*/
		
		// 需求：
/*		Scanner input = new Scanner(System.in);
		System.out.println("分数：");
		double score = input.nextDouble();*/
		// 类型的自动提示：一个容量大的值，和一个容量小的值进行运算，结果是容量大的数据类型；
		// double / int = double;   ---> 截断小数位；
		// 61 / 60 = (int)1......    ---> 1  
		//  50 / 60 = 0....... ---> 0
/*		switch ((int)(score / 60)) {
		  case 0:  
			System.out.println("不合格");
			break;
		  case 1:  
			System.out.println("合格");
			break;
		default:
			System.out.println("输入错误！");
			break;
		}*/
		
		//需求：
		Scanner input = new Scanner(System.in);
		System.out.println("月份：");
		int month = input.nextInt();
		// switch(值)；
		switch (month) {
		//case 穿透：
			case 3:
			case 4:
			case 5:
				System.out.println("春！");
				break;
			case 6:
			case 7:
			case 8:
				System.out.println("夏！");
				break;
			case 9:
			case 10:
			case 11:
				System.out.println("秋！");
				break;
			case 12:
			case 1:
			case 2:
				System.out.println("冬！");
				break;
		default:
			System.out.println("输入有误");
			break;
		}
		
	}
}












