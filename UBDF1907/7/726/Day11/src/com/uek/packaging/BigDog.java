package com.uek.packaging;

public class BigDog {
	
	private String color;
	int age;
	protected String sex;
	
	public BigDog(String color, int age, String sex) {
		this.color = color;
		this.age = age;
		this.sex = sex;
	}

	public BigDog() {

	}

	void eat() {
		System.out.println("狗爸爸爱吃骨头！");
	}
	
	protected void sleep() {
		System.out.println("狗爸爸在睡觉！");
	}
	
	public String toString() {
		return sex;
	}
}







