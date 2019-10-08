package com.uek.java;
/**
 * 数组的增删改查：   增
 *
 */
public class ArrayTest01 {
	public static void main(String[] args) {
		
		//查询：查询指定元素，如果有输出：下标，如果没有，打印，没有找到；
/*		boolean flag = false;  //标记变量，控制的是状态
		int[] arr = new int[] {8,7,4,5,6,1,3};
		int select = 1;
		int index = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == select) {
				flag = true; //发生了某种事件，改变状态
				index = i;
				break;
			}
		}
		*//**
		 * if (flag)  == if(flag == true)
		 * if(!flag) =  flag = false
		 *//*
		if (!flag) {
			System.out.println("没有找到！");
		} else {
			System.out.println("找到了" + index);
		}*/
		
		//需求：数组元素的删除
/*		int[] arr1 = new int[] {9,7,8,4,5,6,1,9};
		int select1 = 8;
		int index1 = -1;
		//1)  8的下标；
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] == select1) {
				index1 = i;
			}
		}
		//2）移动；
		for(int i=index1;i<arr1.length-1;i++) {
			arr1[i] = arr1[i+1];
		}
		//3)
		arr1[arr1.length-1] = 0;
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}*/
		
		//数组元素：修改：
		int[] arr1 = new int[] {9,7,8,4,5,6,1,9};
		int select1 = 8; //100
		for(int i=0;i<arr1.length;i++) {
			if (arr1[i] == select1) {
				arr1[i] = 100;
			}
		}
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + "\t");
		}
		
		//数组的赋值内存分析：
		int[] arr2 = new int[] {1,2,3};
		int[] arr3 = arr2;
		int[] arr4 = new int[] {1,2,3};
		
	}
}












