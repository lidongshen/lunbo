package com.uek.javaSE;

public class ArrayTest02 {
	public static void main(String[] args) {
		
		//1.数组的声明：
		int[] arr;   //标准，建议使用
		int arr1[]; //
		double[] arr2;
		String[] str;
		//自定义类型：
		//Student[] stus;
		//数组的声明时，不容许指定长度；
		//int[3] arr3;
		
		//2.初始化：
		//2.1) 动态初始化：数组声明且为数组元素分配空间与赋值的操作分开进行；
		//（1）在内存中，创建了数组的对象：
		//double[] arr4 = new double[3];
		//(2) 对数组的元素进行赋值：语法：数组名[下标]；
		//arr4[0] : 数组当中的第一个元素：类型是double
		//arr4[0] = 10; //自动转换
		//arr4[1] = 20.1;
		//arr4[2] = 10.5;
		//arr4[3] = 40.5;  超出数组容量的大小
		
		//需求：创建一个长度为100的int类型数组，然后给该数组的元素
		//           进行赋值：1 - 100；
		int[]  arr5 = new int[100];
		/**
		 * 数组的长度：数组名.length
		 * 遍历数组：
		 * int i=0 : 从数组的下标0的位置开始操作；
		 * int i=0; i<数组名.length;i++ ：整个循环的过程中，是以数组的下标来进行循环的；
		 *  				下标：[0 , length-1];
		 *  数组名[i] : 代表数组中具体的某一个元素；
		 *  for(int i=0; i<数组名.length;i++){
		 *            数组名[i];
		 *  }
		 */
		System.out.println(arr5.length);  //数组长度；100
		//在循环数组的过程中，对元素进行赋值;
		for (int i = 0; i < arr5.length; i++) {
			arr5[i] = i+1;   //arr5[0]
		}
		
		//循环数组，然后获取数组中的每一个元素：
		for (int i = 0; i < arr5.length; i++) {
			//输出每一个元素：
			System.out.println(arr5[i]);
		}
		
		//2.2) 静态初始化：在定义数组的同时就为数组元素分配空间并赋值。
		//9,5,7,6,3,1,4 : 数组中的元素；有几个元素，数组的长度就是几；
		//当前数组中，最后一个元素的下标是：6（长度-1）；
		int[] arr6 = new int[] {9,5,7,6,3,1,4};
		
	}
}





