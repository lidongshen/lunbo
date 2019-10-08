package com.uek.packaging;

public class PackagingTest {
	public static void main(String[] args) {
		/**
		 * 测试访问权限：
		 */
		Student s = new Student();
		//本包下的所有类，都可以访问默认权限：
		//s.age = 40;
		//本包下，可以直接访问默认权限：
		s.info();
		
		//public修饰：
		//s.length = 173;
		s.say();
		
		s.setName("张三");//
		
		
		
		
		BigDog dog1 = new BigDog("黑色", 2, '公');
		dog1.color = "红色";
		dog1.age = 3;
		dog1.sex = '母';
	}
}
