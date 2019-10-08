package com.uek.javaSE;

public class ArrayTest03 {

	public static void main(String[] args) {
		
		/**
		 * 创建数组：
		 * int[] arr = new int[];       //错误，创建数组时，必须要指定长度
		 * int[5] arr = new int[5];  //声明时，不能指定长度；
		 * int[] arr = new int[3]{1,2,3}; //静态初始化时，不能在[]中指定长度；
		 */
		
		//默认初始化：
		//数组中，元素的默认值；
//		int[] arr = new int[5];
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		
/*		long[] arr = new long[5];
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]); // 0 = 0L
		}*/
		
/*		double[] arr = new double[5];
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]); 
		}*/
		
/*		boolean[] arr = new boolean[5];
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]); 
		}*/
		
		String[] arr = new String[5];
		arr[1] = "abc";
		//arr.length-1 = 4;
		arr[arr.length-1] = "def";
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]); 
		}
		/**
		 * null;
		 * abc
		 * null
		 * null
		 * def
		 */
		
		
		
	}
}


























