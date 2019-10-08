package com.uek.homeWork;

import java.util.Scanner;

public class MaxAndMin {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		//需求：输入一批整数，使用循环求出最大值与最小值，输入0时结束。
		Scanner input = new Scanner(System.in);
		System.out.println("输一个数："); 
		int num = input.nextInt(); 
		int max = num;
		int min = num;
		int i = 2;
		for(;;) {
			System.out.println("输第"+(i++)+"个数："); 
			num = input.nextInt(); 
			if(num == 0) {
				break;
			}
			//比较：
			if (num > max) {
				max = num; 
			} 
			if(num < min){
				min = num; 
			}
		}
		System.out.println(max +","+min);
	
	
	}
}



















