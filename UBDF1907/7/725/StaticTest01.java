package com.uek.java;
/**
 *  需求： 计算机类
 *  属性：品牌（前3：联想，后3：戴尔），体积，价格；
 *  方法：介绍方法；
 *  6个对象：
 *		使用static关键字；
 */
//类里包含有哪些成员？
/**
 *       成员变量
 *       静态变量（类变量）
 *      构造方法（无参、有参）
 *      成员方法
 *      静态方法（类方法）
 */
class Computer1{
	
	static String brand;   //类变量(类级别，所有对象共享一份)
	int size;             //成员变量
	double price;
	
	public Computer1() {
		
	}
	public Computer1(int _size , double _price) {
		size = _size;
		price = _price;
	}
	//成员方法：
	public void info() {
		//类变量：
		System.out.println(brand+","+size+","+price);
		//类方法：
		staticFunc();
	}
	
	//注意：在类方法中不能调用非类成员（成员变量，成员方法）
	//类成员包含：类变量，类方法
	public static void staticFunc() {
		System.out.println("我是类方法" + brand); //引用类变量
		//引用成员变量：
	// System.out.println("尺寸：" + size); //报错
	 
	 //info(); //报错
	 
	}
}

public class StaticTest01 {
	public static void main(String[] args) {
		
		//对类变量进行赋值：
		/**
		 * 因为类变量、类方法属于类级别，所以可以直接使用类名调用：
		 * 语法：类名.类变量
		 *             类名.类方法()
		 */
		Computer1.brand = "联想";
		Computer1 c1 = new Computer1(10 , 5000.0);
		Computer1 c2 = new Computer1(20 , 6000.0);
		Computer1 c3 = new Computer1(30 , 4000.0);
		c1.info();
		c2.info();
		c3.info();
		Computer1.brand = "戴尔";
		Computer1 c4 = new Computer1(10 , 5000.0);
		Computer1 c5 = new Computer1(20 , 6000.0);
		Computer1 c6 = new Computer1(30 , 4000.0);
		c4.info();
		c5.info();
		c6.info();
		
		c1.staticFunc(); 
	}
}







