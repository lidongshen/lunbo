package com.uek.packaging1;

import com.uek.packaging.BigDog;

public class DogSon extends BigDog{
	
	String color;
	
	public DogSon(String color, int age, String sex, String color2) {
		super(color, age, sex);
		color = color2;
	}

	public DogSon() {
		super();
		
	}

	public DogSon(String color, int age, String sex) {
		super(color, age, sex);
		// TODO Auto-generated constructor stub
	}

	public void test() {
		System.out.println("狗儿子问爸爸，你是到底是公的，还是母的");
		//sex : protected修饰
		System.out.println("狗爸爸说，我是" + super.sex);
	}
	
	public static void main(String[] args) {
		DogSon dogSon = new DogSon("黑色", 3, "母" , "红色");
		//在继承条件下，外包的子类是可以直接访问父类protected
		//修饰的成员（成员变量，成员方法）
		dogSon.test();
		dogSon.sleep();
	}
}
