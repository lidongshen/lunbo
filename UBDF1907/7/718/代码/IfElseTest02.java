package com.uek.test01;

import java.util.Scanner;

/**
 * 	双分支练习：
 */
public class IfElseTest02 {
	public static void main(String[] args) {
		
		//需求5：闰年（条件：1.能被4整除，同时不能被100整除；2.能被400整除；）
		//模板代码：
		//快捷键：自动生成变量名 : ctrl + 1
/*	    Scanner input = new Scanner(System.in);
	    //快捷键：自动生成打印输出语句：alt + /
	    System.out.println("请输入年份：");
	    int year = input.nextInt();
	    //业务逻辑：表示闰年条件
	    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			System.out.println(year +",是闰年!");
		} else {
			System.out.println(year +",不是闰年!");
		}*/
	
	    //需求6：
		Scanner input = new Scanner(System.in);
		System.out.println("请用户名：");
		//next() : 接收键盘输入的一个字符串
		String userName = input.next();
		System.out.println("请密码：");
		String password = input.next();
		//业务逻辑：
		/**
		 * 字符串的比较，一般是不使用 “==”， 因为在内存中，
		 * “== ” 比较的是两个字符串的地址；
		 * equals()方法：该方法比较的才是字符串的内容；
		 */
/*		if (userName == "张三" && password =="1234") {
			System.out.println("登录成功！");
		} else {
			System.out.println("登录失败！");
		}*/
		if (userName.equals("张三") && password.equals("1234")) {
			System.out.println("登录成功！");
		} else {
			System.out.println("登录失败！");
		}
	}
}










