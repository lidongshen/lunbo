// package ：包， 当前类所在的包路径；
package com.uek.test01;

import java.util.Scanner;

/**
 *  当前类用来测试双分支结构语法
 */
public class IfElseTest01 {
	public static void main(String[] args) {
		/*
		 * 双分支结构： 
		 * if(表达式){
		 *      当表达式成立执行的代码；
		 * }else{
		 *      当表达式不成立执行的代码；
		 * }
		 */
		//需求1：
		double score = 90.5;
		if(score > 90) {
			System.out.println("有奖品！");
		}else {
			System.out.println("没有奖品！");
		}
		
		System.out.println("===========分割线============");
		
		// 自动导出快捷键：alt + /
		// 注释快捷键：将选中的代码，按Ctrl+shift+/
		//自动补全分支结构快捷键：alt + /
		
		//需求2：
/*		Scanner input = new Scanner(System.in);
		System.out.println("输入一个数：");
		int num = input.nextInt();
		//  num % 2 ==0 : 偶数
		if(num % 2 ==0) {
			System.out.println(num + ",是偶数！");
		}else {
			System.out.println(num + ",是奇数！");
		}*/
		
		//需求3：
/*		Scanner input = new Scanner(System.in);
		System.out.println("输入一个数：");
		int num1 = input.nextInt();
		System.out.println("输入二个数：");
		int num2 = input.nextInt();
		if(num1 > num2) {
			System.out.println(num1);
		}else {
			System.out.println(num2);
		}*/
		
		// 需求4：
		double r = Math.random() * 4; //0.0-.3.99..
		System.out.println("圆的半径：" + r);
		// Java API :  
		/*
		 * 该方法属于类方法，所以可以直接使用类名调用；
		 * pow(double a, double b) 
             返回第一个参数的第二个参数次幂的值。
             Math.PI ： 常量，使用类名调用常量；
		 */
		//面积：
		double area = Math.pow(r, 2) * Math.PI;
		//周长：
		double zhouChang = Math.PI * r * 2;
		System.out.println(area+","+zhouChang);
		if (area > zhouChang) {
			System.out.println("面积大！");
		} else {
			System.out.println("周长大！");
		}
		
	}
}














