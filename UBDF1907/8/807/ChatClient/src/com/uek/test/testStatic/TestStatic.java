package com.uek.test.testStatic;

public class TestStatic {
	public static void main(String[] args) {
		
		Person p0 = null;
		//不会空指针 p0没有 会去永生带找p0的类型Person.country
		//java允许实例访问类成员，编译没问题 但是c#就不允许实例访问类成员
		//其实类成员就会去永生带找，建议通过类名访问，即使看到对象访问类成员
		//直接把实例对象换成类名 比如以下就换成Person.country
		System.out.println(p0.country);
		System.out.println(Person.country);
		
		
		Person p1 = new Person();
		p1.setName("zs");
		p1.setAge(30);
		
		Person p2 = new Person();
		p2.setName("ls");
		p2.setAge(40);
		

		//System.out.println(p1.age);
		System.out.println(p1);
		System.out.println(p1.toString());
		
		System.out.println(p2);
		System.out.println(p2.toString());
	}
}

class Person
{
	static private String name;
	static private int age;
	
	public static String country = "中国";//类变量所有实例共享 不在短命区
	
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age)
	{
		if(age > 130)
		{
			age = 130;
		}
		
		this.age = age;
	}
	
	public int getAge()
	{
		return this.age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
}
