package com.uek.packaging;
/**
 * 面向对象三大特征：封装
 * 		面向“接口”编程
 * 
 * 封装：目的就是保证了对象所封装的数据的安全；
 * 在编程中，封装是使用四个访问修饰符来控制外界对对象属性的访问权限；
 * java中的四个访问修饰符；(权限从高到低)
		1、private : 权限是最严密，只能在本类中被访问；
		2、默认的（访问修饰符缺省）：只能在本包中直接被访问；
		3、Protected : 本包可以直接访问，外包子类可以直接访问；
		4、Public : 公共的，公开的， 项目下，所用包都可以访问；
 */

public class Student{
	//最严密的访问权限，只能在本类中访问
	private String name;
	private int age;
	private char sex;
	private String[] like;
	private double length;
	
	/**
	 * 提供对外的“接口”：我们可以设置一些业务逻辑，防止暴力访问
	 * set方法：没有返回值类型 ，方法名：set+属性名 , 有形参
	 */
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		if (age > 50) {
			System.out.println("外界输入的数据有问题！");
		}
		this.age = age;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	
	
	
	
	
	
	private void score() {
		System.out.println(this.name +"分数是：90分");
	}
	
	//默认权限：
    void info() {
		System.out.println("我是三好学生！");
	}
	
    public void say() {
    	System.out.println("学生在演讲！");
    }
    
	public void test() {
		this.name = "张泽";
		//成员方法之间的调用：
		this.score();
		//在本类中，访问默认修饰属性的权限：
		this.age = 20;
		
		this.info();
	}
	
}

class Test {
	public static void main(String[] args) {
		
		Student student = new Student();
		//student.name = "张三";
		//student.score();
		//本包下的所有类，都可以访问默认权限：
		student.age = 30;
	}
}




























