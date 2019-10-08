package com.uek.homeWork;

public class AddTest {
	public static void main(String[] args) {
		
		//需求：∑1+∑2+……+∑100:
		int sum1 = 0; //总和
		//循环的次数：
		for (int i = 1; i <=100 ; i++) {
			// 每累加完之后，清零
			int sum2 = 0; //每个数的累加和
			//内层循环：累加和
			for(int j=1;j<=i;j++) {
				sum2 += j;
			}
			//每次的结果进行累加：
			sum1 += sum2;
			System.out.println(sum1 +","+sum2);
		}
		
	}
}
