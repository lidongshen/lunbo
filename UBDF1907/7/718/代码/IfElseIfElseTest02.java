package com.uek.test01;

import java.util.Scanner;

public class IfElseIfElseTest02 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		//需求：找对象
/*		Scanner input = new Scanner(System.in);
		System.out.println("男友的身高：");
		int height = input.nextInt();
		System.out.println("男友的财产：");
		double money = input.nextDouble();
		System.out.println("男友的颜值：");
		boolean isHandsome = input.nextBoolean();
		
		//业务逻辑：
        if (height >= 180 && money >= 10000 && isHandsome) {
			System.out.println("赶紧嫁！");
		} else if(height >= 180 || money >= 10000 || isHandsome){
			System.out.println("凑合！");
		}else {
			System.out.println("不嫁！");
		}*/
        
        //嵌套分支：
		//
/*		Scanner input = new Scanner(System.in);
		System.out.println("秒数：");
		int score = input.nextInt();
		if (score > 8 ) {
			System.out.println("失败！");
		} else {
			System.out.println("输入性别：");
			String sex = input.next();
		    if (sex.equals("男")) {
				System.out.println("男子组");
			} else if(sex.equals("女")){
				System.out.println("女子组");
			}else {
				System.out.println("输入有误");
			}
		}*/
        
		Scanner input = new Scanner(System.in);
		System.out.println("月份：");
		int month = input.nextInt();
		
		//淡季
        if (month >=1 && month <= 3 || month >= 10 && month <= 12) {
    		System.out.println("年龄：");
    		int age = input.nextInt();
        	//儿童和老人
			if (age <= 18 || age >= 70) {
				System.out.println("20!");
			} else {
				System.out.println("40!");
			}
			//旺季：
		} else {
			//特殊情况：有学生证：
			System.out.println("是否有学生证：");
			boolean isStudent = input.nextBoolean();
			if (isStudent) {
				System.out.println("30!");
			} else {
				System.out.println("年龄：");
				int age = input.nextInt();
				if (age > 18 && age < 70) {
					System.out.println("60");
				} else {
					System.out.println("40");
				}
			}
		}        
	}
}






