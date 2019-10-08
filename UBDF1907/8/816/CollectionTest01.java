package com.uek;

import java.util.Arrays;

/**
 * Java集合：
 *
 */
class Person{
	private String name;
	private int age;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}


class Dog{
	private String name;
	private int age;
	public Dog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dog(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + "]";
	}
	
}


public class CollectionTest01 {
	public static void main(String[] args) {
	
		/**
		 * 数组的数据类型;
		 */
		/*
		 * 1）基本数据类型数组：
		 */
		//动态初始化;
		int[] arr = new int[3];
		arr[0] = 1;
		arr[1] = 2;
		//静态初始化：
		int[] arr1 = new int[] {1,2,3};
		/*
		 * 2) 引用数据类型数组; 
		 */
		String[] str = new String[2];
		str[0] = "123";
		String[] str1 = {"456"};
		/**
		 * 自定义引用类型数组;
		 * 	1) 构建自定义类的模板；
		 * 	2）创建自定义引用类型的数组：动态初始化
		 *      Person[] p = new Person[3];
		 *  3）赋值元素时，元素为自定义类型的对象；
		 *      p[0] = new Person("张三",20);
		 *  4) 静态初始化：
		 *  	Person[] p2 = new Person[] {new Person("张三",20) , new Person("李四",20) , new Person("王五",20)}; 
		 *      
		 */
		
		/**
		 * 需求：1）构建一个长度为3的自定义引用类型的数组（Person: name ,age）
		 * 		添加引用类型元素；
		 * 		2）在数组中，再添加一个元素；
		 */
		//动态初始化：
		Person[] p = new Person[3];
		p[0] = new Person("张三",20);
		p[1] = new Person("李四",20);
		p[2] = new Person("王五",20);
		//静态初始化：
		Person[] p2 = new Person[] {new Person("张三",20) , new Person("李四",20) , new Person("王五",20)}; 
		
		
		//p[3] = new Person("赵六",20);
		//System.out.println(Arrays.toString(p));
		for(Person pp : p) {
			System.out.println(pp.toString());
		}
		
		Person[] p1 = new Person[p.length + 1];
		
		for (int i = 0; i < p.length; i++) {
			p1[i] = p[i];
		}
		
		p1[3] = new Person("赵六",20);
		System.out.println(Arrays.toString(p1));
		System.out.println("=========================");
		/**
		 * Dog类：color , age , name , length
		 * 要求构建长度为4的Dog类型数组，然后赋值，
		 * 遍历；（普通循环，增强循环）
		 * 在现有的基础上，再添加一个Dog元素；
		 * 在新数组中，按照age的大小进行升序排序；
		 */
		Dog[] dogs = new Dog[] {new Dog("小黑", 2) ,new Dog("小黄" ,1) , new Dog("小白" , 3)};
		Dog[] dogs1 = new Dog[dogs.length+1];
		for (int i = 0; i < dogs.length; i++) {
			dogs1[i] = dogs[i];
		}
		dogs1[dogs1.length-1] = new Dog("小花" , 4);
		
		for (int i = 0; i < dogs1.length; i++) {
			Dog dog = dogs1[i];
			System.out.println(dog.toString());
		}
		System.out.println("=========================");
		for (Dog dog : dogs1) {
			System.out.println(dog);
		}
		System.out.println("=========================");
		/**
		 * 冒泡排序：age大小
		 */
		//外层循环控制循环的次数：如果有n个元素，至少循环n-1次
		for(int i=0;i<dogs1.length-1;i++) {
			//内层循环控制两两比较：
			for(int j=0;j<dogs1.length-1-i;j++) {
				//比较策略：age
				if (dogs1[j].getAge() > dogs1[j+1].getAge()) {
					Dog temp = dogs1[j];
					dogs1[j] = dogs1[j+1];
					dogs1[j+1] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(dogs1));
		
	}
}











































