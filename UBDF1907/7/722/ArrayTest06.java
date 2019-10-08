package com.uek.javaSE;

public class ArrayTest06 {
	public static void main(String[] args) {
		
		/**
		 * 二维数组：一维数组，做为另外一个一维数组的元素存在；
		 */
		//1. 二维数组的声明及初始化：
		// 1.1）二维数组动态初始化：
		//语法：数据类型[][] 数组名 = new 数据类型[一维数组长度][二维数组长度];
		int[][] arr = new int[2][3];
		//1.2)只声明一维数组长度：
		int[][] arr1 = new int[2][];
		
		//1.2）二维数组静态初始化：
		//一维数组的长度是2；二维数组的长度是3；
		int[][] arr2 = new int[][] {{1,2,3} , {4,5,6}};
		//注意：Java中多维数组不必都是规则矩阵形式：
		//在二维数组开辟空间时可以不一样的；
		int [][] arr3 = new int[][] {{10,20,30} , {40,50}};
		
		/**
		 * String[][] str = new String[][3]; //一维数组长度没有指定；
		 * String[2][3] str = new String[][]; //声明时，不能指定数组长度；
		 * int[][] arr = new int[2][2]{{1,2} , {3,4}}; //动静初始化分开；
		 */
		
		//获取二维数组中的元素：
		int [][] arr4 = new int[][] {{10,20,30} , {40,50}};
		// 语法：一维数组：数组名[下标]
		//             二维数组：数组名[一维数组下标][二维数组下标]
		System.out.println(arr4[1][0]);
		
		double[][] doubleArr = new double[2][2];
		//给二维数组赋值;
		doubleArr[0][0] = 10.0;
		System.out.println(doubleArr[0][1]); // 0.0
		
		int[][] arr5 = new int[2][];
		System.out.println(arr5);         //[[I@7852e922
		System.out.println(arr5[0]); // null
		//
		arr5[0] = new int[] {1,2,3};
		arr5[1] = new int[2];
		arr5[1][0] = 10;
		arr5[1][1] = 20;
	}
}
























