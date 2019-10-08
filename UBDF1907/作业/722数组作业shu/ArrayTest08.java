package com.uek.javaSE;

import java.util.Scanner;

public class ArrayTest08 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		//需求：求二维数组中所有元素之和：每一个数组元素的累加和；
		int[][] arr = new int[][] {{3,5,8} , {12,9} , {7,0,6,4}};
		
		//不管是一维还是二维数组，对于元素的操作，一般都是在遍历数组的过程中完成的；
		//外层循环：行
	/*	int sum = 0;
		for(int i=0;i<arr.length;i++) {
			int sum1 = 0;
			//内层循环：列
			for(int j=0;j<arr[i].length;j++) {
				sum += arr[i][j];
				sum1 += arr[i][j];
			}
			System.out.println(sum1);
		}
		System.out.println(sum);*/
		
		//需求: 键盘输入三个班，每个班5名同学的成绩，求每个班的平均分，和总平均分；
/*		Scanner input = new Scanner(System.in);
		int[][] scores = new int[3][5];
		int sum1 = 0;
		int count = 0;
		for (int i = 0; i < scores.length; i++) {
			int sum2 = 0;
			for (int j = 0; j < scores[i].length; j++) {
				System.out.println("请输入："+(i+1)+"班，第"+(j+1)+"位分数：");
				scores[i][j] = input.nextInt();
				sum1 += scores[i][j];
				sum2 += scores[i][j];
				count++;
			}
			
			System.out.println("每个班内的平均分：" + sum2 / scores[i].length);
		}
		System.out.println("总平均分："+ sum1 / count);*/
		
		
		//需求：
		int[][] arr2 = new int[3][];
		for (int i = 0; i < arr2.length; i++) {
			//二维数组中的一维数组初始化：
			arr2[i] = new int[i + 1];   //  2+1 = 3  
			for(int j = 0;j<arr2[i].length;j++) {
				//一维数组赋值：
				arr2[i][j] = i + 1;  // 3 3 3
				System.out.println(arr2[i][j]);
			}
		}
	}
}

























