package com.uek.java;
/**
 * 方法的重载：
 * 		在同一个类中，同一个方法名，方法的形参列表不同（形参的类型，个数，顺序不同）；
 *特殊情况：
 *1）方法的返回值类型不同，不构成方法的重载；
 *2）形参的变量名不同，不构成方法的重载；
 */
public class FcuntionTest03 {
	//方法的重名,报错：
	public static void add(int i , int j) {
		System.out.println(i + j);
	}
	
	public static int  add(int i , long l1) {
		//业务逻辑;
		return (int)(i + l1); // long,类型自动提示
	}
	
	public static void main(String[] args) {
		
		int a = 10;
		int b = 20;
		long l = 30L;
		//在调用重载的方法时，是根据参数来决定调用的是哪个重载方法：
		//方法的返回值，不一定必须使用，根据业务需求决定；
		add(a , l);
		
		add(a , b);
		
	}
}
