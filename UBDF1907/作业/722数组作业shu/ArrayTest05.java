package com.uek.javaSE;

import java.util.Scanner;

public class ArrayTest05 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		//需求：键盘输入，求一个班10名同学的平均分；
/*		Scanner input = new Scanner(System.in);
		int[] scoreArr = new int[10];
		int sum = 0;
		for (int i = 0; i < scoreArr.length; i++) {
			System.out.println("输入第"+(i+1)+"位同学成绩：");
			scoreArr[i] = input.nextInt();
			sum += scoreArr[i];
		}
		System.out.println("平均分："+ sum / scoreArr.length);*/
		
		//需求：创建一个char类型长度为26的数组，要求添加：‘A’ -'Z'元素；
/*		char[] charArr = new char[26];
		//遍历数组：
		for(int i=0;i<charArr.length;i++) {
			charArr[i] = (char)('A' + i);   // 'A' + 0 = int类型， 类型的自动提升
			System.out.println(charArr[i]);
		}*/
		
		//程序员发布一个合租的广告：一个月600, 带空调，限女性；
		//程序员留了个电话：
/*		int[] arr = new int[] {8,2,1,0,3};
		int[] index = new int[] {2,0,3,2,4,0,1,3,2,3,3};
		String phone = "";
		for(int i=0;i<index.length;i++) {
			phone += arr[index[i]];
			//  index :   2    0    3
			//  arr     :    1     8   0
		}
		System.out.println(phone);  // 18013820100
		*/
		
		//需求：人数 = 数组的长度
		Scanner input = new Scanner(System.in);
		System.out.println("人数");
		int num = input.nextInt();
		//创建数组：
		System.out.println("第"+num+"成绩：");
		int[] scores = new int[num];
		scores[0] = input.nextInt();
		//把第一个元素设置标杆：让所有的元素和该元素进行比较；
		// 56 74 89
		int max = scores[0];   // 56
		//从第二个元素开始遍历：
		for (int i = 1; i < scores.length; i++) {
			scores[i] = input.nextInt();  // 74
			//最高分：
			if (scores[i] > max) {  // 74 > 56
				max = scores[i]; //位置交换   max = 74
			}
		}
		System.out.println("最高分是：" + max);
		
		char c; // 等级
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] >= max - 10) {
				c = 'A';
			} else if(scores[i] >= max - 20){
				c = 'B';
			}else if(scores[i] >= max - 30){
				c = 'C';
			}else {
				c = 'D';
			}
			
			System.out.println("student " +i+ "score is " +scores[i]+ " gread is "+c);
		}
	}
}


















