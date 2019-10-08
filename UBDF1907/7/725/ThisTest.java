package com.uek.java;
/**
 * this : 
 *
 */
class Stu1{
	String name;
	int score;
	int age;
	char sex;
	int id;
	
	//构造方法：
	public Stu1() {
		
	}
	
	public Stu1(String name , int score , int age , char sex , int id) {
	/*	this.name = name;
		this.score = score; *///考虑构造方法的调用
		//使用this关键字在构造方法中，来调用其它的重载构造方法：
		// 语法要求this关键字必须写在该构造方法的第一行；
		//注意：在构造方法中，第一条语句：this();  该语句隐藏了
		//this(); //调用无参构造方法
		this(name , score);
		
		this.age = age;
		this.sex = sex;
		 this.id = id;
	}
	
	//在成员变量和局部变量重名时，使用this来区分；
	//this.name : 代表的是成员变量
	public Stu1(String _name , int _score) {
		name = name;
		this.score = score;
	}
	
	//为什么成员方法中，可以直接使用this呢？
	//答案：每一个成员方法，都有两个隐藏参数：this , super;
	public void test() {
		this.name = "张三";
		
		test2();              //在成员方法中，调用其它成员方法，简写
		this.test2();    //详写  ，二者没有任何区别
	}
	
	public void test2() {
		
	}
	
	
	
	//类成员在类加载时，就已经初始化了，这个时候，根本就没有创建任何对象；
	public static void test1() {
		//this.name = "李四";
	}
}

public class ThisTest {
	public static void main(String[] args) {
		
		Stu1 s = new Stu1();
		Stu1 s2 = new Stu1();
		s2.test();
	}
	
}
