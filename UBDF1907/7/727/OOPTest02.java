package com.uek.java;
/**
 * 方法的重写：
 */
class Animal{
	String name;
	public void cry() {
		System.out.println("动物在叫！");
	}
}

class Dog{
	//成员属性：
	Animal a;    //组合
	public Dog(Animal a) {
		this.a = a;
	}
	//父类实现的方法已经不能满足子类的需要时，这个时候子类就需要重新实现
	//父类的方法----->方法的重写（前提：先有继承）；
	//要求：子类重写方法时，方法的返回值类型，方法名，形参列表必须要和父类的方法一致；
/*	@Override  //注解 :   专门用于检查重写的方法语法是否正确，如果不正确会报编译错误
	public void cry() {
		System.out.println("我作为一条狗，我的叫：汪汪！！");
	}*/
	
	public void test() {
		System.out.println(a.name);
	}
	
	public void test() {
		//狗在叫：
		cry();
	}
}

class Cat{
	String eye;
	Animal a;   //组合
	public Cat(Animal a) {
		this.a = a;
	}
/*	@Override
	public void cry() {
		System.out.println("我是猫，我的叫法：喵喵！");
	}*/
	public void test() {
		System.out.println(a.name);
	}
}

public class OOPTest02 {
	public static void main(String[] args) {
		
		Dog dog = new Dog();
		dog.test();
		dog.sleep();
	}
}












