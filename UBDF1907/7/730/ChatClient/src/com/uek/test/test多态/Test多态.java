package com.uek.test.test多态;

/**
 * 多态： java变量分2个类型，一个是编译型，一个是运行期类型。
 * 		  同样类型变量，执行同一个方法，总是表现出来运行时
 *  	  类型的行为特征
 *  
 * @author UEK-N
 *
 */
public class Test多态 {
	
	public static void main(String[] args) {
		Animal animal = new Animal();
		animal.cow();
		
		Animal cat = new Cat();
		cat.cow();
		
		Animal dog = new Dog();
		dog.cow();
		
	}
	
}

class Animal
{
	void cow()
	{
		System.out.println("动物都会吼叫！");
	}
}

class Cat extends Animal
{
	void cow()
	{
		System.out.println("苗苗！");
	}
}

class Dog extends Animal
{
	void cow()
	{
		System.out.println("汪汪！");
	}
}