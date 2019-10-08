package com.uek.java;
/**
 * 排序：冒泡排序：
 * 		在数组中，依次比较两个元素，如果满足条件（
 * 1.前一个元素 > 后二个元素；
 * 2.前一个元素 < 后二个元素），则两两之间进行位置交互；
 *   int[] arr = new int[]{30,25,40,15,100,60,20};
 */
public class ArrayTest04 {

	public static void main(String[] args) {
		
		int[] arr = new int[]{30,25,40,15,100,60,20};
		//冒泡排序;
		/**
		 * 第一版：不考虑效率，每次排序都是从头排到尾；
		 */
		//外层循环控制：排序的次数 : 只需求排序 ：n
		long start = System.currentTimeMillis(); //毫秒   10
		for (int i = 0; i < arr.length; i++) { // i=1
			// 内层循环控制：两两元素位置：
			// j+1 :   内层循环结束：arr.length 
			// arr.length-1 : 如果不-1 ， 循环则会访问到不存在的下标，然后报错
			for (int j = 0; j < arr.length-1; j++) {
				//两两位置交互：升序：前 > 后
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		long end = System.currentTimeMillis(); // 20
		System.out.println("时间：" + (end-start)); //20-10
		/**
		 * 第二版：优化：（1）只需要排序：n-1(n:元素个数)
		 *                            （2）只需要排序没有顺序的元素，有顺序的元素就不用排了；
		 *                              目的：提高程序效率；
		 *     排序：十大排序：不仅仅java, 数据结构-->所有编程语言
		 *       时间复杂度、空间复杂度；
		 *                  优点：
		 *                  缺点：
		 *     大数据阶段：快速排序、归并排序；
		 */
		//外层循环控制：排序的次数 : 只需求排序 ：n-1
		for (int i = 0; i < arr.length-1; i++) { // i=1
			// 内层循环控制：两两元素位置：
			// j+1 :   内层循环结束：arr.length 
			// arr.length-1 : 如果不-1 ， 循环则会访问到不存在的下标，然后报错
			for (int j = 0; j < arr.length-1-i; j++) {
				//两两位置交互：升序：前 > 后
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		//遍历数组：
	/*	for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j]+"\t");
		}*/
		
	/*	start = System.currentTimeMillis(); 
		for (int i = 0; i < 10000000; i++) {
			
		}
		end = System.currentTimeMillis(); 
		System.out.println("时间：" + (end-start)); */
	}
}







