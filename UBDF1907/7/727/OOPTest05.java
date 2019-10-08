package com.uek.java2;
/**
 * 接口：implements关键字
 * 		标准，规范（更加严格，是不容许有方法实现的）
 * 包含:
 * 		1) 抽象方法； public abstract来修饰，可以缺省
 * 		2)常量：public static final 常量名
 * 
 * 	当一个类实现了某个接口时，那么必须要实现接口中的方法；
 */
interface Animal{
	//常量：
	public static final double PI = 3.1415;
	
	//跑：
	//public abstract void run() ;
	void run();
	//在接口中，不能有实现方法：
/*	public void test() {
		System.out.println("test");
	}*/
}

//dog1类实现了animal接口：
class Dog1 implements Animal{
	
	//方法的实现：
	@Override
	public void run() {
		System.out.println("四条腿跑！");
	}
}

public class OOPTest05 {

}
