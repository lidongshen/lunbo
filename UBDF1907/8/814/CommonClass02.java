package com.uek1;

public class CommonClass02 {

	public static void main(String[] args) {
		
		//main方法中接收两个数字字符串参数
		String a = args[0];
		String b = args[1];
		//将第一个字符串直接转为Integer对象；
		Integer i1 = Integer.valueOf(a);
		//将第二个字符串解析int整数，然后用此整数构建Integer对象；
		int i = Integer.parseInt(b);
		Integer i2 = new Integer(i);
		//使用人工拆箱，获得上述两个对象int整数值，求和打印出来；
		int num1 = i1.intValue();
		int num2 = i2.intValue();
		System.out.println(num1 + num2);
		//使用自动拆箱，计算两数之积并打印出来。
		System.out.println(i1 * i2); //先拆箱，再计算
	}
}








