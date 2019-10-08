package com.uek.java;
/**
 *  类的第三个成员：
 *   1）成员变量；
 *   2）成员方法：
 *   3）构造方法();
 *   
 *   语法：
 *   [修饰符] 类名（[形参列表]）｛
			代码块；
	 ｝
	 和普通方法的区别：
	 1）构造方法没有返回值类型；
	 2）方法名就是类名；
 *
 *构造方法的分类：
 *	1）无参构造方法（
 *    在编译器编译类时，自动赋予该类一个无参构造方法，所以才能构建对象；
 *    但是，一定自定义构造方法，那么编译器就不会再赋予该类无参构造方法了）；
 * 2）有参构造方法；
 *
 *构造方法的功能：
 * 		1）专门用来构建类的对象；
 * 		2）在构建对象的同时，对该对象的属性赋初始值；
 */
class Cat{
	String color;
	int age;
	//添加构造方法：无参构造方法
/*	public Cat() {
		System.out.println("正在构建一只猫！");
	}*/
	
	//有参构造方法：
	//注意：形参属于局部变量，在栈中开辟空间
	public Cat(String _color , int _age) {
		//一边造对象，一边赋值：
		color = _color;
		age = _age;
	}
	
	public void eat() {
		System.out.println(color+","+age);
	}
}

public class Test {
	public static void main(String[] args) {
		//new Cat() ；相当于在调用构造方法，来创建     对象
		Cat cat =  new Cat("黑色" , 2);
		cat.eat();
	}
}















