package com.uek.java2;
/**
 * 抽象类：
 * 语法角度 ；abstract
 * 程序设计角度：抽象类 ----> 标准，规范(当子类继承的是抽象父类时，
 * 		必须要按照抽象父类的要求去进行程序的设计。)
 */
//当类中包含了抽象方法时，该类必须要构建成抽象类：用abstract关键字来修饰；
abstract class Person{
	String name;
	//抽象方法：只有方法的声明，没有方法的实现；用abstract关键字来修饰；
	public abstract void show() ; // 我是残疾人
	public abstract void show1();
	
	public static void test() {
		System.out.println("我是正常人");
	}
	
}

/**
 * 当继续自抽象类时：
 * 	1）当前类自己实现抽象父类的抽象方法；
 * 2）如果不实现，将自己也修改抽象类；
 */
/*abstract  class XiaoMing extends Person{
	int score; 
	@Override
	public void show() {
		System.out.println("我是一名优秀学生!");
	}
}
*/

class XiaoMing extends Person{
	int score; 
	@Override
	public void show() {
		System.out.println("我是一名优秀学生!");
	}
	public void show1() {
		System.out.println();
	}
}

public class OOPTest04 {
	public static void main(String[] args) {
		//不能构建抽象类的对象：
		//Person person = new Person();
		//person.show();
		
		Person.test();
	}
}
