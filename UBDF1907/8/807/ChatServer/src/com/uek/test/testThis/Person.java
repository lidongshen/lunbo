package com.uek.test.testThis;

public class Person {
	
	private String name;
	private int age;
	
	//equals方法的重写规则
	//1 判断是不是同一个 
	//2 即使不是同一个，一定是同一类
	//3 关键属性应该相同 关键属性是根据业务规则来的，比如银行卡 卡号 学生 学号
	@Override
	public boolean equals(Object obj) {
		
		if(this == obj)
			return true;
		
//		if(obj.getClass() == Person.class)
//		{
//			
//		}
		
		if(obj instanceof Person)
		{
			//假设name和age都是关键属性
			if(this.name.equals(((Person)obj).getName()) && this.age == ((Person)obj).getAge())
			{
				return true;
			}
			
		}
		
		
		return false;
	}
	
	public void person()
	{
		
		
	}
	
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
