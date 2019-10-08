package com.uek.java;

public class FunctionTest02 {
	//注意：方法与方法属于平级关系，所以，不能方法中嵌套方法：
	
	//方法的声明：
	public static int getLength(int[] arr) {
		return arr.length;
	}
	
	public static void maxValue(int[] arr) {
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		System.out.println("最大值：" + max);
	}
	
	public static void minValue(int[] arr) {
		int min = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (min > arr[i]) {
				min = arr[i];
			}
		}
		System.out.println("最小值：" + min);
	}
	
	public static int[] sort(int[] arr) {
		
		for(int i=0;i<arr.length-1;i++) {
			for (int j = 0; j < arr.length-1-i; j++) {
				if (arr[j] < arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		int[] newArr = arr;
		return newArr;
	}
	
	public static void print(int[] arr) {
		for(int temp : arr) {
			System.out.print(temp+"\t");
		}
	}
	
	
	public static void main(String[] args) {
		
		int[] arr = new int[] {5,7,9,1,3,6};
		
		//返回数组长度：
		int length = getLength(arr);
		//System.out.println(length);
		System.out.println(getLength(arr));
		//打印最大值；
		maxValue(arr);
		//打印最小值：
		minValue(arr);
		//返回新数组，要求旧数组中的元素冒泡排序：
		int[] newArr = sort(arr);
		//遍历
		print(newArr);
		/**
		 * 当设计一个功能方法时，应该考虑：
		 * 1）方法是否需要有返回值；
		 * 2）方法名叫什么；
		 * 3）方法是否有形参列表；
		 */
		
		
	}
}
