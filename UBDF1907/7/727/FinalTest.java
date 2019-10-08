package com.uek.java1;

import javafx.animation.Animation;

/**
 * Final关键字：
 *   1）使用final修饰类 , 不能被继承；
 *   	修饰类：四种访问权限 ，其中修饰类只有public ,默认的；
 *   					修饰属性，方法：四种都可以；
 *   2）使用final修饰方法，子类不能重写，但是父类中可以重载；
 *   3）final修饰的变量，不可改变；
 *   4) final关键字，一般与static一起使用：public static final int PI = 3.1415;
 *			final和 private abstract两个关键字连续一起使用；
 */
/*final class Animal{
	String name;
}

class Dog extends Animal{
	
}
*/
class A{
	//private abstract final String name = "A";  //不能一起使用
	
	private final String eye = "蓝色眼睛";
	
	public void test() {
		System.out.println(this.eye);
	}
	
	public static void main(String[] args) {
		
		A a = new A();
		a.test();
	}
}


class Animal{
	String name;
	final int age;
	public Animal() {
		age = 10;
	}
	public Animal(String name , int age) {
		this.name = name;
		this.age = age;
	}
	
	private final void eat() {
		//age = 20; //不可改变
		System.out.println(age);
		System.out.println(name+",在吃！");
	}
	
	public final void eat(String name) {
		eat();
		System.out.println(name+",在吃！");
	}
	
}

class Dog1 extends Animal{
	
	/*public final void eat() {
		
	}*/
}



public class FinalTest {
	public static void main(String[] args) {
		
		Animal a = new Animal();
		//a.eat();
		a.eat("小动物");
	}
}




























