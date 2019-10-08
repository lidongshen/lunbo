package com.uek.homeWork;

public class resultTest {
	public static void main(String[] args) {
		
		//1！+2！+……+15!  
		long sum1 = 0; //总计算器
		for(int i=1;i<=15;i++) {
			long sum2 =1; //小计算器
			for(int j=1;j<=i;j++) {
				sum2 *= j;
			}
			sum1 += sum2; // 复合赋值运算符隐藏了强化转换
			System.out.println(sum1 +","+sum2);
		}
		
	}
}
