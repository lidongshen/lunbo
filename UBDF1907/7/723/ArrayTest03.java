package com.uek.java;

import java.util.Random;

public class ArrayTest03 {
	public static void main(String[] args) {
		
		/**
		 * 合并数组：
		 * int[] arr = new int[]{元素};   
		 * 简写：
		 * 	int[] arr ={元素} ； （在编译器编译时，会根据前面数组的声明，做类型推断）
		 *
		 * int[] oldArr = {5,6,0,4,7,0,8,0,9};
		 * 要求把数组中为0的元素去掉，然后将不为0的元素存放到一个新的数组中；
		 * int[] newArr = {5,6,4,7,8,9}
		 */
		//思路：
		//1) 找到0元素的个数，确定新数组的长度；
	/*	int[] oldArr = {5,6,0, 4,7,0,8,0,9};
		int count = 0;
		for (int i = 0; i < oldArr.length; i++) {
			if (oldArr[i] == 0) {
				count++;
			}
		}*/
		//2) 创建新数组；
	/*	int[] newArr = new int[oldArr.length - count];
		//3) 通过循环旧数组，对新数组中的元素进行赋值；
		//3.1)  作为新数组的下标存在的
		int count1 = 0;
		for (int i = 0; i < oldArr.length; i++) {
			if (oldArr[i] != 0) {
				newArr[count1++] = oldArr[i];  // 
			//     5                                          5
		    //     6                                         6
		    //     4                                         4
			}
		}
		//4) 遍历新数组：
		for (int i = 0; i < newArr.length; i++) {
			System.out.println(newArr[i]);
		}*/
		
		/**
		 * 需求：生成100个随机数，放入数组中，然后出最大值，最小值，平均值；
		 */
	/*	Random r = new Random();
		int[] arr = new int[100];
		arr[0] = r.nextInt(101);
		int max = arr[0];
		int min = arr[0];
		int sum = 0;
		for (int i = 1; i < arr.length; i++) {
			arr[i] = r.nextInt(101);
			System.out.print(arr[i]+"\t");
			sum += arr[i];
			if (max < arr[i]) {
				max = arr[i];
			}
			if (min > arr[i]) {
				min = arr[i];
			}
		}
		System.out.println();
		System.out.println("平均值："+sum/arr.length+","+max+","+min);*/
	
		/**
		 * 需求：数组逆序操作：
		 * int[] arr = {1,2,3,4,5,6,7,8,9};
		 * 打印输出：9,8,7,6,5,3,4,3,2,1
		 * 思路: 第一个元素和最后一个元素交互位置
		 *           第二个元素和倒数第二个元素交互位置
		 *           。。。。。
		 *           当交互到数组中间位置时，停止交互；
		 */
/*		int[] arr = {1,2,3,4,5,6,7,8,9};
		//循环到数组的中间位置：
		for(int i=0;i<arr.length / 2;i++) {
			//元素之间两两交互：
			int temp = arr[i];
			arr[i] = arr[arr.length-1-i]; // i =1
			arr[arr.length-1-i] = temp;
			//System.out.print(arr[i] + "\t");
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}*/
		
		/**
		 * 需求：二分查找法（折半查找）：
		 * int[] arr = {1,2,3,4,5,6,7,8,9};
		 * 查找的元素8对应的下标；
		 * 二分查找法：要求数组的元素必须有序的；
		 */
		//1) 确定当前数组的起始位置，和结束位置：下标
		int[] arr1 = {1,2,3,4,5,6,7,8,9};  // 8
		int num = 8;
		int start = 0;
		int end  = arr1.length-1;
		//在循环的过程中来折半查找：
		//循环条件是：当查找的过程中，起始位置>=结束位置 ，说明没有找到
		while(start <= end) {
			//获取数组中，中间位置的元素以及对应的下标
			int middleIndex = (start+end) / 2;    // 7
			int middleValue = arr1[middleIndex]; // 8
			//判断：
			if (middleValue == num) {
				System.out.println("找到了，下标是" +middleIndex);
				break;
			}else if(middleValue > num) {
				//如果中间值比要查找的值大，在前半部分进行查找；
				//通过控制循环的结束位置：
				end = middleIndex - 1;
			}else {
				//如果中间值比要查找的值小，在后半部分进行查找；
				start = middleIndex + 1; //  6+1 = start:7
			}
		}
	}
}







