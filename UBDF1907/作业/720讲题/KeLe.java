package com.uek.homeWork;

public class KeLe {

	public static void main(String[] args) {
		//声明变量：
		int money = 20;  //
		int price = 3;
		int temp = 0;  //瓶数
		int count = 0; //剩余的钱
		int sum = 0; // 总瓶数
		//剩余的钱 >= 3
		while(money >= price) {
			//1）先买： 
			temp = money / price;    // 6        2     1
			//2) 剩下钱：
			count = money % price; // 2       2      1
			//3) 剩余的钱+瓶数
			money = count + temp; // 8      4       2
			sum += temp; //记录每次买的瓶数   8+1=9
		}
		System.out.println(sum);
	}
}
