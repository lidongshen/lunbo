package com.uek.javaSE;

public class ArrayTest09 {

	public static void main(String[] args) {
		
		int[] arr1 = new int[3];
		arr1[2]  = 10;  //值
		arr1[2] = 20;
		
		String[] str = new String[2];
		str[1]  = "abc"; //赋的不是值，而是地址
		str[1] = "def";
		
		//数组赋值操作：
		//需求：新数组有4个元素，在添加旧数组元素后，在新数组的最后一个位置，添加一个
		//          具体的值：100；
		//旧数组：
/*		int[] arr2 = new int[] {1,2,3};
		//新数组：
		int[] arr3 = new int[arr2.length + 1];
		//遍历：
		for(int i=0;i<arr2.length;i++) {
			arr3[i] = arr2[i];
		}
		//最后一个元素：
		arr3[arr3.length-1] = 100;
		for (int i = 0; i < arr3.length; i++) {
			System.out.println(arr3[i]);
		}
		*/
		
		//从前往后循环：
		/*for(int i=1;i<=100;i++) {
			System.out.println(i);
		}*/
		
		//从后往前循环:
		/*for(int i=100; i>=1;i--) {
			System.out.println(i); // 100 99 98
		}*/
		
		//循环操作的数组的下标：
		//最后一个元素的下标：长度-1
/*		int[] arr2 = new int[] {1,2,3};
		//arr2.length-1:  i =2   i = 1
		// i > 1
		for(int i=arr2.length-1;i>1;i--) {
			//赋值: 前一个元素值赋值给后一个元素
			arr2[i] = arr2[i-1];
		}
		arr2[1] = 0;*/
		
/*		int[] arr2 = new int[] {1,2,3,4,5};
		int elem = 2;
		int index = -1;
		//该元素在数组中的下标位置：
		for(int i=0;i<arr2.length;i++) {
			if (arr2[i] == elem) {
				index = i; // 找到了
				break;  //当找到后就不需要再循环了
			}
		}
		//System.out.println(index);
		//移动：
		for(int i=arr2.length-1;i>index;i--) {
			arr2[i] = arr2[i -1];
		}
		arr2[index] = 100;
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}*/
		
		// 最大值，最小值：
		int[] arr2 = new int[] {0,5,7,9,4,2,6,8};
		//思路：确定一个标杆，让其它所有元素和该元素标记
/*		int max = arr2[0];
		for(int i=0;i<arr2.length;i++){
			//如果其它元素比max还大：
			if (arr2[i] > max) {
				max = arr2[i];
			}
		}
		System.out.println("最大值：" + max);
		//假设第一个元素是最小值：
		int min = arr2[0];
		for (int i = 0; i < arr2.length; i++) {
			if (arr2[i] < min) {
				min = arr2[i];
			}
		}
		System.out.println("最小值：" + min);*/
		
		int max = arr2[0];
		int min = arr2[0];
		for (int i = 0; i < arr2.length; i++) {
			if (arr2[i] > max) {
				max = arr2[i];
			}
			//相互不影响：
			if (arr2[i] < min) {
				min = arr2[i];
			}
		}
		System.out.println("最大值：" + max);
		System.out.println("最小值：" + min);
	}
	
}


















