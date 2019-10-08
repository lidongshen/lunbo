package com.uek.test.testThis;

public class Person {
	
	private String name;
	private int age;
	
	
	public Person() {
		super();
	}

	//构造器中的this是正在初始化的对象
	//new 和 初始化的区别和联系？
	//就近原则
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return this.name;
	}
	
	//实例方法的this指的是正在调用方法的对象
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void sum()
	{
		System.out.println(111);
		
	}
	
	
}
