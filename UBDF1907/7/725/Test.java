package com.uek.java;
/*
 * 异常:
 * 	 1)  数组下标越界：ArrayIndexOutOfBoundsException
 * 			原因：访问了不存在的下标；
 * 2）空指针异常：NullPointerException
 * 			原因：尝试操作null对象；
 * 						在访问引用类型的数据时，如果在没有构建对象的情况下，
 * 						就对该对象进行操作时，则会报该异常；
 */
//空类
class Dog{
	String name;
}

public class Test {
	public static void main(String[] args) {
		int[] arr = new int[2]; //长度：2
		arr[0] = 10;
		arr[1] = 20;
		//arr[3] = 30;
		
		Dog dog = null; //空对象
		System.out.println(dog.name);
	}
}
