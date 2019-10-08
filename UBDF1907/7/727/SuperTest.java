package com.uek.java;
/**
 * super关键字：
 *
 */
class Stu{
	String name;
	int age;
	public Stu() {
		
	}
	public Stu(String name , int age) {
		this.name = name;
		this.age = age;
	}
	
	public void show () {
		System.out.println(name +","+age);
	}
}

class ZhangSan extends Stu{
	
	public ZhangSan() {
		super();  // 位置必须是第一行
	}
	public ZhangSan(String name , int age) {
		//在调用父类的有参构造方法来为父类的对象属性赋值：
		super(name, age);  
		System.out.println("子类对象构建中！");
	}
	
	public void info() {
		//调用父类的name属性：
		System.out.println(this.name);     // 张三
		System.out.println(super.name); 
		this.show();
		super.show();
	}
}

public class SuperTest {
	public static void main(String[] args) {
		
		ZhangSan zhangSan = new ZhangSan("张三" , 20);
		zhangSan.info();
	}
}
