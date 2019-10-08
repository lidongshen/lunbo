package com.uek.java;

import java.util.Random;

public class ArrayTest02 {

	public static void main(String[] args) {
		/**
		 * 需求：获取数组最大值和最小值;
		 * 		数组长度：50
		 * 		要求使用随机类（random类）生成随机数作为元素 【0-100】；
		 *     找出>=60元素个数；
		 */
		//创建数组;
		Random random = new Random();
		int[] arr = new int[50];
		//同时可以声明多个变量：
		arr[0] = random.nextInt(101);
		int max =  arr[0];
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			arr[i] = random.nextInt(101);
			if (arr[i] > max) {
				max = arr[i];
			}
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 60) {
				count++;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
		System.out.println(max+","+min);
		System.out.println(count);	
	}
}
